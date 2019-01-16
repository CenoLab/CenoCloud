package com.iot.nero.utils;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午3:12.
 */
public enum Constant {
    ACTIVE(1),
    NOT_ACTIVE(0);
    public int flag;
    Constant(int i) {
        this.flag = i;
    }

    public int getI() {
        return flag;
    }
}
