package com.example.portalback.people.controller;

import com.example.portalback.common.entity.ResponseObj;
import com.example.portalback.people.bean.PeopleBean;
import com.example.portalback.people.core.PeopleManager;
import com.example.portalback.people.model.PeopleModel;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author LIN
 */
@RequestMapping("people")
@RestController
public class PeopleController {

    @Resource
    private PeopleManager peopleManager;

    /**
     * 添加/编辑人
     *
     * @param model
     * @return
     */
    @PostMapping("editPeople")
    public ResponseObj editPeople(@RequestBody PeopleModel model) {
        try {
            PeopleBean bean = peopleManager.editPeople(PeopleModel.formatBean(model));
            return ResponseObj.success(bean, "add success");
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    /**
     * 添加人
     *
     * @param model
     * @return
     */
    @PostMapping("addPeople")
    public ResponseObj addPeople(@RequestBody PeopleModel model) {
        try {
            PeopleBean bean = peopleManager.addPeople(PeopleModel.formatBean(model));
            return ResponseObj.success(bean, "add success");
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    /**
     * 删除人
     *
     * @param peopleId
     * @return
     */
    @GetMapping("deletePeople")
    public ResponseObj deletePeople(@RequestParam("peopleId") String peopleId) {
        try {
            peopleManager.deletePeople(peopleId);
            return ResponseObj.success(null, "delete success");
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    @GetMapping("pagePeople")
    public ResponseObj pagePeople(@RequestParam("pageNo") Integer pageNo,
                                  @RequestParam("pageSize") Integer pageSize,
                                  @RequestParam(value = "sortKey", required = false) String sortKey,
                                  @RequestParam(value = "selectKey", required = false) String selectKey,
                                  @RequestParam(value = "selectValue", required = false) String selectValue) {
        try {
            Page<PeopleBean> page = peopleManager.pagePeople(pageNo, pageSize, sortKey, selectKey, selectValue);
            return ResponseObj.success(page, "success");
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }
}
