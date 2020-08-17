package com.example.portalback.sys.service.impl;

import com.example.portalback.base.model.PageModel;
import com.example.portalback.sys.bean.AccountBean;
import com.example.portalback.sys.bean.RoleBean;
import com.example.portalback.sys.dao.*;
import com.example.portalback.sys.entity.SysAccount;
import com.example.portalback.sys.entity.SysAccountRole;
import com.example.portalback.sys.entity.SysRole;
import com.example.portalback.sys.service.SysAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SysAccountServiceImpl implements SysAccountService {

    @Autowired
    private SysAccountRepository sysAccountRepository;

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public UserDetails loadUserByUsername(@NotBlank String username) throws UsernameNotFoundException {
        boolean exist = sysAccountRepository.existsUserByUsername(username);
        if (exist) {
            SysAccount account = sysAccountRepository.findUserByUsername(username);
            List<RoleBean> accountRoles = this.getAccountRoles(account.getId());
            AccountBean bean = AccountBean.formatBean(account, accountRoles);
            return bean;
        } else {
            throw new UsernameNotFoundException("do not find this user!");
        }
    }

    @Override
    public List<RoleBean> getAccountRoles(String accountId) {
        List<SysAccountRole> sysAccountRoles = accountRoleRepository.findAllByAccountId(accountId);
        List<String> roleIds = sysAccountRoles.parallelStream()
            .map(SysAccountRole::getRoleId)
            .collect(Collectors.toList());
        List<SysRole> roles = sysRoleRepository.findAllByIdIn(roleIds);
        List<RoleBean> collect = roles.parallelStream()
            .map(RoleBean::formatBean)
            .collect(Collectors.toList());

        return collect;
    }

    @Override
    public Page<AccountBean> pageAccount(PageModel model) {
        List<Sort.Order> orders = model.getSorts().stream()
            .map(sort -> Sort.Order.by(sort.getName())
                .with(Sort.Direction.valueOf(Optional.ofNullable(sort.getValue())
                    .filter(StringUtils::isNotBlank)
                    .map(StringUtils::upperCase)
                    .orElse("DESC"))))
            .collect(Collectors.toList());
        Pageable pageable = PageRequest.of(model.getPageNo() - 1, model.getPageSize(), Sort.by(orders));

        Specification<SysAccount> specification =
            (Specification<SysAccount>) (root, cq, cb) -> {
                Predicate[] predicates = model.getFilters().stream().map(filter -> {
                    Path<String> username = root.get(filter.getName());
                    Predicate like = cb.like(username, "%" + filter.getValue() + "%");
                    return like;
                }).toArray(Predicate[]::new);
                return cq.where(predicates).getRestriction();
            };

        Function<SysAccount, AccountBean> function = sysAccount -> {
            List<RoleBean> accountRoles = this.getAccountRoles(sysAccount.getId());
            return AccountBean.formatBean(sysAccount, accountRoles);
        };

        return sysAccountRepository.findAll(specification, pageable).map(function);
    }

    @Override
    public void loginSuccess(String userId) {
        SysAccount one = sysAccountRepository.getOne(userId);
        one.setLoginTime(LocalDateTime.now());
        sysAccountRepository.save(one);
    }

    @Override
    public void addAccount(AccountBean bean) {
        SysAccount entity = AccountBean.getEntity(bean);
        entity.setCreateTime(LocalDateTime.now());
        entity.setId(null);
        entity.setEnabled(true);
        sysAccountRepository.save(entity);
    }

}
