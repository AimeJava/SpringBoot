package com.tina.restaurant.vo;

import com.github.pagehelper.Page;

// 模板 替换，编译期擦除
// new ResultVO<String>(); // java javac 编译
// new ResultVO<Student>();
public class ResultVO<T> {

    private int code; //状态码
    private T data; //数据响应
    private Page page; //页数
    private String error;//错误
    private Throwable throwable;//异常

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}