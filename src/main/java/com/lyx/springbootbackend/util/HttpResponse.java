package com.lyx.springbootbackend.util;


/**
 * @author LYX-夜光
 * @date 2020/6/22
 */
public class HttpResponse {
    public static final int SUCCESS = 200;
    public static final int USER_ERROR = 402;
    public static final int SERVER_ERROR = 500;

    private int code;
    private String msg;
    private Object data;

    public static HttpResponse success(String msg) {
        HttpResponse response = new HttpResponse();
        response.setCode(HttpResponse.SUCCESS);
        response.setMsg(msg);
        return response;
    }

    public static HttpResponse success(String msg, Object data) {
        HttpResponse response = new HttpResponse();
        response.setCode(HttpResponse.SUCCESS);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public static HttpResponse failure(int code, String msg) {
        HttpResponse response = new HttpResponse();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

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

    @Override
    public String toString() {
        return "HttpStatus{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
