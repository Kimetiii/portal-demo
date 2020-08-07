package com.example.portalback.common.entity;

import lombok.Data;

@Data
public class ResponseObj {

    private int code = 200;
    private Object data;
    private String msg = "";

    public static ResponseObj success() {
        return ResponseObj.success(null, "success");
    }

    public static ResponseObj success(Object data) {
        return ResponseObj.success(data, "success");
    }

    public static ResponseObj success(String msg) {
        return ResponseObj.success(null, msg);
    }

    public static ResponseObj success(Object data, String msg) {
        ResponseObj res = new ResponseObj();
        res.data = data;
        res.msg = msg;
        return res;
    }

    public static ResponseObj failure(Exception e) {
        return ResponseObj.failure(-1, e.getMessage());
    }

    public static ResponseObj failure(int code, String msg) {
        ResponseObj res = new ResponseObj();
        res.code = code;
        res.msg = msg;
        return res;
    }

    public static ResponseObj build(int code, Object data, String msg) {
        ResponseObj res = new ResponseObj();
        res.code = code;
        res.data = data;
        res.msg = msg;
        return res;
    }

}
