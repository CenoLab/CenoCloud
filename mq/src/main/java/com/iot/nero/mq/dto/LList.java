package com.iot.nero.mq.dto;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/27
 * Time   下午2:32
 */
public class LList<T> implements Serializable {
    private Integer allCount;
    private T list;

    public LList(Integer allCount, T list) {
        this.allCount = allCount;
        this.list = list;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "LList{" +
                "allCount=" + allCount +
                ", list=" + list +
                '}';
    }
}
