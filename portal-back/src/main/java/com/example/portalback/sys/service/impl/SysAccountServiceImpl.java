package com.example.portalback.sys.service.impl;

import com.example.portalback.base.model.PageModel;
import com.example.portalback.sys.bean.SysAccountBean;
import com.example.portalback.sys.dao.SysAccountRepository;
import com.example.portalback.sys.entity.SysAccount;
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
import org.springframework.util.Assert;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SysAccountServiceImpl implements SysAccountService {

    @Autowired
    private SysAccountRepository sysAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Assert.isTrue(StringUtils.isNotBlank(username), "please input username");

        boolean exist = sysAccountRepository.existsUserByUsername(username);
        if (exist) {
            SysAccount user = sysAccountRepository.findUserByUsername(username);
            SysAccountBean bean = SysAccountBean.formatBean(user);
            return bean;
        } else {
            throw new UsernameNotFoundException("do not find this user!");
        }
    }

    @Override
    public Page<SysAccountBean> pageAccount(PageModel model) {

        List<Sort.Order> orders = model.getSorts().stream()
                .map(sort -> Sort.Order.by(sort.getName()).with(Sort.Direction.valueOf(Optional.ofNullable(sort.getValue()).filter(StringUtils::isNotBlank).map(StringUtils::upperCase).orElse("DESC"))))
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

        return sysAccountRepository.findAll(specification, pageable).map(SysAccountBean::formatBean);
    }

    @Override
    public SysAccountBean getAccount(String userId) {
        Assert.isTrue(sysAccountRepository.existsById(userId), "do not find user");
        SysAccount user = sysAccountRepository.getOne(userId);
        SysAccountBean sysAccountBean = SysAccountBean.formatBean(user);
        return sysAccountBean;
    }

    @Override
    public void loginSuccess(String userId) {
        SysAccount one = sysAccountRepository.getOne(userId);
        one.setLoginTime(LocalDateTime.now());
        sysAccountRepository.save(one);
    }

    @Override
    public void addAccount(SysAccountBean bean) {
        SysAccount entity = SysAccountBean.getEntity(bean);
        entity.setCreateTime(LocalDateTime.now());
        entity.setId(null);
        entity.setEnabled(true);
        sysAccountRepository.save(entity);
    }

}
