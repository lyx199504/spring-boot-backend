package com.lyx.springbootbackend.util;


/**
 * @author LYX-夜光
 * @date 2020/6/22
 */
public class HttpStatus {
    public static int success = 200;
    public static int userError = 402;
    public static int serverError = 500;

    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setHttpStatus(int code, String msg, Object data) {
        setCode(code);
        setMsg(msg);
        setData(data);
    }
}
