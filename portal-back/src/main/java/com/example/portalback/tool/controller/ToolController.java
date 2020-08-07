package com.example.portalback.tool.controller;

import com.example.portalback.common.entity.ResponseObj;
import com.example.portalback.tool.core.ToolManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author LIN
 */
@RequestMapping("tool")
public class ToolController {

    @Autowired
    private ToolManager toolManager;

    @PostMapping("uploadFile")
    public ResponseObj uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String url = toolManager.uploadFile(file);
            return ResponseObj.success(url);
        } catch (Exception e) {
            return ResponseObj.failure(e);
        }
    }

}
