package com.tina.restaurant.vo;

// 模板 替换，编译期擦除
public class MenuResultVO<T> {
    private int code; //状态码
    private T data; //数据响应
    private String error;//错误
    private int count ; //总页数

    public int getCode() {
        return code;
    }

    public MenuResultVO<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public MenuResultVO<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getError() {
        return error;
    }

    public MenuResultVO<T> setError(String error) {
        this.error = error;
        return this;
    }

    public int getCount() {
        return count;
    }

    public MenuResultVO<T> setCount(int count) {
        this.count = count;
        return this;
    }

    @Override
    public String toString() {
        return "MenuResultVO{" +
                "code=" + code +
                ", data=" + data +
                ", error='" + error + '\'' +
                ", count=" + count +
                '}';
    }
}