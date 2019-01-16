package com.iot.nero.parent_system.dto.system;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/16
 * Time   下午7:33
 */
public class Baseboard implements Serializable, oshi.hardware.Baseboard {

    private String manufacturer;
    private String model;
    private String version;
    private String serialnumber;

    public Baseboard() {
    }

    public Baseboard(String manufacturer, String model, String version, String serialnumber) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.version = version;
        this.serialnumber = serialnumber;
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

    public String getVersion() {
        return version;
    }


    public void setVersion(String version) {
        this.version = version;
    }

    public String getSerialNumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    @Override
    public String toString() {
        return "Baseboard{" +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", version='" + version + '\'' +
                ", serialnumber='" + serialnumber + '\'' +
                '}';
    }
}
