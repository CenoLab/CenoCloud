package com.iot.nero.service_system.service.impl;

import com.iot.nero.dto.Result;
import com.iot.nero.parent_system.dto.*;
import com.iot.nero.parent_system.dto.system.*;
import com.iot.nero.service.ISystemService;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/16
 * Time   下午6:37
 */
public class SystemService implements ISystemService {

    /**
     * 系统状态
     *
     * @return Result<SystemStatus>
     */
    public Result<SystemStatus> getSystemStatus() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();

        SystemStatus systemStatus = new SystemStatus();

        ComputerSystem computerSystem = new ComputerSystem(
                hal.getComputerSystem().getManufacturer(),
                hal.getComputerSystem().getModel(),
                hal.getComputerSystem().getSerialNumber(),
                new Firmware(
                        hal.getComputerSystem().getFirmware().getManufacturer(),
                        hal.getComputerSystem().getFirmware().getName(),
                        hal.getComputerSystem().getFirmware().getDescription(),
                        hal.getComputerSystem().getFirmware().getVersion(),
                        hal.getComputerSystem().getFirmware().getReleaseDate()
                ),
                new Baseboard(
                        hal.getComputerSystem().getBaseboard().getManufacturer(),
                        hal.getComputerSystem().getBaseboard().getModel(),
                        hal.getComputerSystem().getBaseboard().getVersion(),
                        hal.getComputerSystem().getBaseboard().getSerialNumber()
                )
        );

        Processor processor = new Processor(
                hal.getProcessor().getPhysicalProcessorCount(),
                hal.getProcessor().getLogicalProcessorCount(),
                hal.getProcessor().getIdentifier(),
                hal.getProcessor().getProcessorID()
        );

        Memory memory = new Memory(
                FormatUtil.formatBytes(hal.getMemory().getAvailable()),
                FormatUtil.formatBytes(hal.getMemory().getTotal()),
                FormatUtil.formatBytes(hal.getMemory().getSwapUsed()),
                FormatUtil.formatBytes(hal.getMemory().getSwapTotal())
                );

        CPU cpu = new CPU();

        Processes processes = new Processes();
        Sensors sensors = new Sensors();
        Power power = new Power();
        Disks disks = new Disks();
        FileSystem fileSystem = new FileSystem();
        NetworkInterfaces networkInterfaces = new NetworkInterfaces();
        NetworkParameterss networkParameterss = new NetworkParameterss();
        Displays displays = new Displays();
        USBDevices usbDevices = new USBDevices();

        systemStatus.setComputerSystem(computerSystem);
        systemStatus.setProcessor(processor);
        systemStatus.setMemory(memory);
        return new Result<SystemStatus>(true,systemStatus);
    }

    /**
     * jvm 状态
     */
    public Result<JVMStatus> getJVMStatus() {
        JVMStatus jvmStatus = new JVMStatus();
        try {
            //获取JVM的启动时间，版本及名称，当前进程ID
            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            jvmStatus.setJvmStartTime(simpleDateFormat.format(new Date(runtimeMXBean.getStartTime())));
            jvmStatus.setJvmVersion(runtimeMXBean.getVmVersion());
            jvmStatus.setJvmName(runtimeMXBean.getVmName());
            jvmStatus.setProcessId(runtimeMXBean.getName().split("@")[0]);

            //获取JVM内存使用状况，包括堆内存和非堆内存
            MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
            jvmStatus.setNonHeapMemoryUsage(memoryMXBean.getNonHeapMemoryUsage());
            jvmStatus.setHeapMemoryUsage(memoryMXBean.getHeapMemoryUsage());

            //操作系统及硬件信息：系统名称、版本，CPU内核，机器总内存、可用内存、可用内存占比
            OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            jvmStatus.setOsName(operatingSystemMXBean.getName());
            jvmStatus.setOsVersion(operatingSystemMXBean.getVersion());
            jvmStatus.setProcessors(operatingSystemMXBean.getAvailableProcessors());

            jvmStatus.setTotalPhysicalMenory(Runtime.getRuntime().totalMemory());
            jvmStatus.setFreePhysicalMenory(Runtime.getRuntime().freeMemory());
            DecimalFormat decimalFormat = new DecimalFormat("0.00%");
            if (Runtime.getRuntime().totalMemory() > 0) {
                jvmStatus.setFreePhysicalMenoryRatio(decimalFormat.format(Double.valueOf(Runtime.getRuntime().freeMemory()) / Runtime.getRuntime().totalMemory()));
            }
            return new Result<JVMStatus>(true, jvmStatus);
        } catch (Exception e) {
            return new Result<JVMStatus>(false, e.getMessage());
        }
    }


    /**
     * MQ运行状态
     */
    public Result<MQStatus> getMQStauts() {
        return null;
    }

    /**
     * 各服务运行状态
     */
    public Result<List<ServiceStatus>> getServiceStatus() {
        return null;
    }

    /**
     * tomcat 运行状态
     */
    public Result<TomcatStatus> getTomcatStatus() {
        return null;
    }

    /**
     * nginx 运行状态
     */
    public Result<NginxStatus> getNginxStatus() {
        return null;
    }

    /**
     * apache 运行状态
     */
    public Result<ApacheStatus> getApacheStatus() {
        return null;
    }


}
