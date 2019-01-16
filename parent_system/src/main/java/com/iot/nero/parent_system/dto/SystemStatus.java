package com.iot.nero.parent_system.dto;

import com.iot.nero.parent_system.dto.system.*;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/16
 * Time   下午7:11
 */
public class SystemStatus implements Serializable {
    private ComputerSystem computerSystem;
    private Processor processor;
    private Memory memory;
    private CPU cpu;
    private Processes processes;
    private Sensors sensors;
    private Power power;
    private Disks disks;
    private FileSystem fileSystem;
    private NetworkInterfaces networkInterfaces;
    private NetworkParameterss networkParameterss;
    private Displays displays;
    private USBDevices usbDevices;

    public SystemStatus() {
    }

    public SystemStatus(ComputerSystem computerSystem, Processor processor, Memory memory, CPU cpu, Processes processes, Sensors sensors, Power power, Disks disks, FileSystem fileSystem, NetworkInterfaces networkInterfaces, NetworkParameterss networkParameterss, Displays displays, USBDevices usbDevices) {
        this.computerSystem = computerSystem;
        this.processor = processor;
        this.memory = memory;
        this.cpu = cpu;
        this.processes = processes;
        this.sensors = sensors;
        this.power = power;
        this.disks = disks;
        this.fileSystem = fileSystem;
        this.networkInterfaces = networkInterfaces;
        this.networkParameterss = networkParameterss;
        this.displays = displays;
        this.usbDevices = usbDevices;
    }

    public ComputerSystem getComputerSystem() {
        return computerSystem;
    }

    public void setComputerSystem(ComputerSystem computerSystem) {
        this.computerSystem = computerSystem;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Processes getProcesses() {
        return processes;
    }

    public void setProcesses(Processes processes) {
        this.processes = processes;
    }

    public Sensors getSensors() {
        return sensors;
    }

    public void setSensors(Sensors sensors) {
        this.sensors = sensors;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public Disks getDisks() {
        return disks;
    }

    public void setDisks(Disks disks) {
        this.disks = disks;
    }

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public NetworkInterfaces getNetworkInterfaces() {
        return networkInterfaces;
    }

    public void setNetworkInterfaces(NetworkInterfaces networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
    }

    public NetworkParameterss getNetworkParameterss() {
        return networkParameterss;
    }

    public void setNetworkParameterss(NetworkParameterss networkParameterss) {
        this.networkParameterss = networkParameterss;
    }

    public Displays getDisplays() {
        return displays;
    }

    public void setDisplays(Displays displays) {
        this.displays = displays;
    }

    public USBDevices getUsbDevices() {
        return usbDevices;
    }

    public void setUsbDevices(USBDevices usbDevices) {
        this.usbDevices = usbDevices;
    }

    @Override
    public String toString() {
        return "SystemStatus{" +
                "computerSystem=" + computerSystem +
                ", processor=" + processor +
                ", memory=" + memory +
                ", cpu=" + cpu +
                ", processes=" + processes +
                ", sensors=" + sensors +
                ", power=" + power +
                ", disks=" + disks +
                ", fileSystem=" + fileSystem +
                ", networkInterfaces=" + networkInterfaces +
                ", networkParameterss=" + networkParameterss +
                ", displays=" + displays +
                ", usbDevices=" + usbDevices +
                '}';
    }
}
