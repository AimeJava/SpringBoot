package com.tina.restaurant.vo;

// 模板 替换，编译期擦除
public class ShareResultVO<T> {
    private int code; //状态码
    private T data; //数据响应
    private String error;//错误

    public int getCode() {
        return code;
    }

    public ShareResultVO<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ShareResultVO<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getError() {
        return error;
    }

    public ShareResultVO<T> setError(String error) {
        this.error = error;
        return this;
    }
}