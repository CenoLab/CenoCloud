package com.iot.nero.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午4:19
 */
public class Result<T> implements Serializable{

    private boolean state;
    private T data;
    private String msg;

    public Result(boolean state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public Result(boolean state, T data) {
        this.state = state;
        this.data = data;
    }

    public Result(boolean state, T data, String msg) {
        this.state = state;
        this.data = data;
        this.msg = msg;
    }


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "state=" + state +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
