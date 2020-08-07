package com.example.portalback.ledger.controller;

import com.example.portalback.common.entity.ResponseObj;
import com.example.portalback.ledger.bean.LedgerBean;
import com.example.portalback.ledger.core.LedgerManager;
import com.example.portalback.ledger.model.LedgerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LIN
 */
@RestController
@RequestMapping("ledger")
public class LedgerController {

    @Autowired
    private LedgerManager ledgerManager;

    @PostMapping("page")
    public ResponseObj page(@RequestBody LedgerModel model) {
        try {
            Page<LedgerBean> page = ledgerManager.page(model);
            return ResponseObj.success(page, "success");
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    @GetMapping("getLedgersByGroupId")
    public ResponseObj getLedgersByGroupId(@RequestParam("groupId") String groupId) {
        try {
            List<LedgerBean> list = ledgerManager.getLedgersByGroupId(groupId);
            return ResponseObj.success(list, "success");
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    @PostMapping("create4SameGroup")
    public ResponseObj create4SameGroup(@RequestBody List<LedgerModel> list) {
        try {
            ledgerManager.create4SameGroup(list.stream().map(LedgerModel::formatBean).collect(Collectors.toList()));
            return ResponseObj.success();
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    @PostMapping("edit")
    public ResponseObj edit(@RequestBody LedgerModel model) {
        try {
            LedgerBean edit = ledgerManager.edit(LedgerModel.formatBean(model));
            return ResponseObj.success(edit);
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    @GetMapping("delete")
    public ResponseObj delete(@RequestParam("id") String id) {
        try {
            ledgerManager.delete(id);
            return ResponseObj.success();
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    @PostMapping("deleteSelect")
    public ResponseObj deleteSelect(@RequestParam("ids") List<String> ids) {
        try {
            ledgerManager.deleteSelect(ids);
            return ResponseObj.success();
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    @PostMapping("upload")
    public ResponseObj upload(@RequestParam("file") MultipartFile file) {
        try {
            ledgerManager.upload(file);
            return ResponseObj.success();
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    @GetMapping("download")
    public void download(@RequestParam("id") String id, HttpServletResponse response) {
        ledgerManager.download(id, response);
    }

    @PostMapping("downloadSelect")
    public void downloadSelect(@RequestParam("ids") List<String> ids, HttpServletResponse response) {
        try {
            ledgerManager.downloadSelect(ids, response);
        } catch (Exception ignored) {
        }
    }

    @PostMapping("bindingGroupIds")
    public ResponseObj bindingGroupIds(@RequestParam("ids") List<String> ids) {
        try {
            ledgerManager.bindingGroupIds(ids);
            return ResponseObj.success();
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

    @GetMapping("unbindingGroupId")
    public ResponseObj unbindingGroupId(@RequestParam("id") String id) {
        try {
            ledgerManager.unbindingGroupId(id);
            return ResponseObj.success();
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

}
