package com.iot.nero.parent_system.dto.system;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/16
 * Time   下午8:08
 */
public class Memory implements Serializable {

    private String available;
    private String total;
    private String swapUsed;
    private String swapTotal;

    public Memory() {
    }

    public Memory(String available, String total, String swapUsed, String swapTotal) {
        this.available = available;
        this.total = total;
        this.swapUsed = swapUsed;
        this.swapTotal = swapTotal;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSwapUsed() {
        return swapUsed;
    }

    public void setSwapUsed(String swapUsed) {
        this.swapUsed = swapUsed;
    }

    public String getSwapTotal() {
        return swapTotal;
    }

    public void setSwapTotal(String swapTotal) {
        this.swapTotal = swapTotal;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "available='" + available + '\'' +
                ", total='" + total + '\'' +
                ", swapUsed='" + swapUsed + '\'' +
                ", swapTotal='" + swapTotal + '\'' +
                '}';
    }
}
