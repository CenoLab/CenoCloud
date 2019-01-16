package com.iot.nero.parent_system.dto;

import java.io.Serializable;
import java.lang.management.MemoryUsage;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/16
 * Time   下午6:46
 */
public class JVMStatus implements Serializable {

    private static final long serialVersionUID = 7593745554626593803L;
    /**
     * JVM 启动时间
     */
    private String jvmStartTime;
    /**
     * JVM 版本信息
     */
    private String jvmVersion;
    /**
     * jvm名称
     */
    private String jvmName;
    /**
     * 当前线程ID
     */
    private String processId;
    /**
     * 非堆内存使用情况(MB)
     */
    private MemoryUsage nonHeapMemoryUsage;
    /**
     * 堆内存使用情况(MB)
     */
    private MemoryUsage heapMemoryUsage;
    /**
     * 操作系统名称
     */
    private String osName;
    /**
     * 操作系统版本
     */
    private String osVersion;
    /**
     * 机器总内存(MB)
     */
    private long totalPhysicalMenory;
    /**
     * 机器以使用内存(MB)
     */
    private long freePhysicalMenory;
    /**
     * 机器可用内存比例
     */
    private String freePhysicalMenoryRatio;
    /**
     * CPU内核
     */
    private int processors;

    public JVMStatus() {
    }

    public JVMStatus(String jvmStartTime, String jvmVersion, String jvmName, String processId, MemoryUsage nonHeapMemoryUsage, MemoryUsage heapMemoryUsage, String osName, String osVersion, long totalPhysicalMenory, long freePhysicalMenory, String freePhysicalMenoryRatio, int processors) {
        this.jvmStartTime = jvmStartTime;
        this.jvmVersion = jvmVersion;
        this.jvmName = jvmName;
        this.processId = processId;
        this.nonHeapMemoryUsage = nonHeapMemoryUsage;
        this.heapMemoryUsage = heapMemoryUsage;
        this.osName = osName;
        this.osVersion = osVersion;
        this.totalPhysicalMenory = totalPhysicalMenory;
        this.freePhysicalMenory = freePhysicalMenory;
        this.freePhysicalMenoryRatio = freePhysicalMenoryRatio;
        this.processors = processors;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getJvmStartTime() {
        return jvmStartTime;
    }

    public void setJvmStartTime(String jvmStartTime) {
        this.jvmStartTime = jvmStartTime;
    }

    public String getJvmVersion() {
        return jvmVersion;
    }

    public void setJvmVersion(String jvmVersion) {
        this.jvmVersion = jvmVersion;
    }

    public String getJvmName() {
        return jvmName;
    }

    public void setJvmName(String jvmName) {
        this.jvmName = jvmName;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public MemoryUsage getNonHeapMemoryUsage() {
        return nonHeapMemoryUsage;
    }

    public void setNonHeapMemoryUsage(MemoryUsage nonHeapMemoryUsage) {
        this.nonHeapMemoryUsage = nonHeapMemoryUsage;
    }

    public MemoryUsage getHeapMemoryUsage() {
        return heapMemoryUsage;
    }

    public void setHeapMemoryUsage(MemoryUsage heapMemoryUsage) {
        this.heapMemoryUsage = heapMemoryUsage;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public long getTotalPhysicalMenory() {
        return totalPhysicalMenory;
    }

    public void setTotalPhysicalMenory(long totalPhysicalMenory) {
        this.totalPhysicalMenory = totalPhysicalMenory;
    }

    public long getFreePhysicalMenory() {
        return freePhysicalMenory;
    }

    public void setFreePhysicalMenory(long freePhysicalMenory) {
        this.freePhysicalMenory = freePhysicalMenory;
    }

    public String getFreePhysicalMenoryRatio() {
        return freePhysicalMenoryRatio;
    }

    public void setFreePhysicalMenoryRatio(String freePhysicalMenoryRatio) {
        this.freePhysicalMenoryRatio = freePhysicalMenoryRatio;
    }

    public int getProcessors() {
        return processors;
    }

    public void setProcessors(int processors) {
        this.processors = processors;
    }

    @Override
    public String toString() {
        return "JVMStatus{" +
                "jvmStartTime='" + jvmStartTime + '\'' +
                ", jvmVersion='" + jvmVersion + '\'' +
                ", jvmName='" + jvmName + '\'' +
                ", processId='" + processId + '\'' +
                ", nonHeapMemoryUsage=" + nonHeapMemoryUsage +
                ", heapMemoryUsage=" + heapMemoryUsage +
                ", osName='" + osName + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", totalPhysicalMenory=" + totalPhysicalMenory +
                ", freePhysicalMenory=" + freePhysicalMenory +
                ", freePhysicalMenoryRatio='" + freePhysicalMenoryRatio + '\'' +
                ", processors=" + processors +
                '}';
    }
}
