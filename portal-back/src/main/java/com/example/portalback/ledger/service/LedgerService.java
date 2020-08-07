package com.example.portalback.ledger.service;

import com.example.portalback.base.model.PageModel;
import com.example.portalback.ledger.bean.LedgerBean;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author LIN
 */
public interface LedgerService {
    Page<LedgerBean> page(PageModel model);

    void create(LedgerBean bean);

    void delete(String id);

    void saveAllWithoutExist(List<LedgerBean> collect);

    void saveAll(List<LedgerBean> collect);

    LedgerBean getOne(String id);

    LedgerBean edit(LedgerBean bean);

    List<LedgerBean> findAllByIds(List<String> ids);

    void deleteSelect(List<String> ids);

    List<LedgerBean> getLedgersByGroupId(String groupId);

    void bindingGroupIds(List<String> groupIds);

    void unbindingGroupId(String id);
}
