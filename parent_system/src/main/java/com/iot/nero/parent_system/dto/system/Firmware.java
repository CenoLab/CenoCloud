package com.iot.nero.parent_system.dto.system;

import org.threeten.bp.LocalDate;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/16
 * Time   下午7:33
 */
public class Firmware implements Serializable, oshi.hardware.Firmware {
    private String manufacturer;
    private String name;
    private String description;
    private String version;
    private LocalDate releaseDate;

    public Firmware() {
    }

    public Firmware(String manufacturer, String name, String description, String version, LocalDate releaseDate) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.description = description;
        this.version = version;
        this.releaseDate = releaseDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Firmware{" +
                "manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", version='" + version + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
