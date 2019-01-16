package com.iot.nero.parent_system.dto.system;


import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/16
 * Time   下午7:32
 */
public class ComputerSystem implements Serializable, oshi.hardware.ComputerSystem {
    private String manufacturer;
    private String model;
    private String serialnumber;
    private Firmware firmware;
    private Baseboard baseboard;

    public ComputerSystem() {
    }

    public ComputerSystem(String manufacturer, String model, String serialnumber, Firmware firmware, Baseboard baseboard) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.serialnumber = serialnumber;
        this.firmware = firmware;
        this.baseboard = baseboard;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialnumber;
    }

    public void setSerialNumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Firmware getFirmware() {
        return firmware;
    }

    public void setFirmware(Firmware firmware) {
        this.firmware = firmware;
    }

    public Baseboard getBaseboard() {
        return baseboard;
    }

    public void setBaseboard(Baseboard baseboard) {
        this.baseboard = baseboard;
    }

    @Override
    public String toString() {
        return "ComputerSystem{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", serialnumber='" + serialnumber + '\'' +
                ", firmware=" + firmware +
                ", baseboard=" + baseboard +
                '}';
    }
}
