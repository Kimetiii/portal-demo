package com.example.portalback.ledger.service.impl;

import com.example.portalback.base.model.PageModel;
import com.example.portalback.common.util.CustomUtils;
import com.example.portalback.ledger.bean.LedgerBean;
import com.example.portalback.ledger.dao.LedgerRepository;
import com.example.portalback.ledger.entity.Ledger;
import com.example.portalback.ledger.service.LedgerService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author LIN
 */
@Service
public class LedgerServiceImpl implements LedgerService {

    @Autowired
    private LedgerRepository ledgerRepository;

    @Override
    public Page<LedgerBean> page(PageModel model) {

        List<Sort.Order> orders = model.getSorts().stream()
                .map(sort -> Sort.Order.by(sort.getName()).with(Sort.Direction.valueOf(sort.getValue())))
                .collect(Collectors.toList());
        Pageable pageable = PageRequest.of(model.getPageNo() - 1, model.getPageSize(), Sort.by(orders));

        Specification<Ledger> specification = (Specification<Ledger>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> collect = model.getFilters().stream().map(filter -> {
                Path<String> username = root.get(filter.getName());
                Predicate like = criteriaBuilder.like(username, "%" + filter.getValue() + "%");
                return like;
            }).collect(Collectors.toList());
            return criteriaQuery.where((collect.toArray(new Predicate[collect.size()]))).getRestriction();
        };

        return ledgerRepository.findAll(specification, pageable).map(LedgerBean::formatBean);
    }

    @Override
    public void create(LedgerBean bean) {
        Ledger entity = LedgerBean.getEntity(bean);
        entity.setId(null);
        entity.setCreateTime(LocalDateTime.now());
        ledgerRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        ledgerRepository.findById(id).map(Ledger::getGroupId).filter(StringUtils::isNotBlank).ifPresent(groupId -> {
            if (ledgerRepository.countByGroupId(groupId) == 2) {
                Ledger tmpLedger = ledgerRepository.findByGroupIdAndIdIsNot(groupId, id);
                tmpLedger.setGroupId(null);
                ledgerRepository.save(tmpLedger);
            }
        });
        ledgerRepository.deleteById(id);
    }

    @Override
    public void saveAllWithoutExist(List<LedgerBean> collect) {
        List<Ledger> result = collect.stream().map(LedgerBean::getEntity)
                .filter(ledger -> !ledgerRepository.existsByContent(ledger.getContent()))
                .collect(Collectors.toList());
        ledgerRepository.saveAll(result);
    }

    @Override
    public void saveAll(List<LedgerBean> collect) {
        List<Ledger> result = collect.stream().map(LedgerBean::getEntity).collect(Collectors.toList());
        ledgerRepository.saveAll(result);
    }

    @Override
    public LedgerBean getOne(String id) {
        return LedgerBean.formatBean(ledgerRepository.getOne(id));
    }

    @Override
    public LedgerBean edit(LedgerBean bean) {
        Optional<Ledger> opt = ledgerRepository.findById(bean.getId());
        Ledger query = opt.orElseThrow(NullPointerException::new);
        query.setAmount(bean.getAmount());
        query.setContent(bean.getContent());
        query.setRecordTime(bean.getRecordTime());
        query.setUpdateTime(LocalDateTime.now());
        Ledger dbLedger = ledgerRepository.save(query);
        return LedgerBean.formatBean(dbLedger);
    }

    @Override
    public List<LedgerBean> findAllByIds(List<String> ids) {
        return ledgerRepository.findAllByIdIn(ids).stream().map(LedgerBean::formatBean).collect(Collectors.toList());
    }

    @Override
    public void deleteSelect(List<String> ids) {
        ledgerRepository.deleteInBatch(ids.stream().map(id -> {
            Ledger query = new Ledger();
            query.setId(id);
            return query;
        }).collect(Collectors.toList()));
    }

    @Override
    public List<LedgerBean> getLedgersByGroupId(String groupId) {
        Ledger query = new Ledger();
        query.setGroupId(groupId);
        return ledgerRepository.findAll(Example.of(query)).stream().map(LedgerBean::formatBean).collect(Collectors.toList());
    }

    @Override
    public void bindingGroupIds(List<String> groupIds) {
        Assert.isTrue(CollectionUtils.isNotEmpty(groupIds), "must not null");
        List<Ledger> query = ledgerRepository.findAllByIdIn(groupIds);
        String uuid = CustomUtils.uuid();
        List<Ledger> collect = query.stream().peek(entity -> entity.setGroupId(uuid)).collect(Collectors.toList());
        ledgerRepository.saveAll(collect);
    }

    @Override
    public void unbindingGroupId(String id) {
        Ledger one = ledgerRepository.getOne(id);
        one.setGroupId(null);
        ledgerRepository.save(one);
    }
}
