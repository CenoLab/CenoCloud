package com.iot.nero.parent_resources.entity;

import java.io.Serializable;
import java.util.Date;

public class Resource implements Serializable {

    private Integer id;
    private String uuid;
    private String hashCode;
    private String systemIdentification;
    private String storageNode;
    private String path;
    private String name;
    private Integer size;
    private String type;
    private Integer uploaderId;
    private String uploadTime;
    private Integer useCount;
    private Integer del;
    private String createTime;
    private String modifyTime;

    public Resource() {
    }

    public Resource(Integer id, String uuid, String hashCode, String systemIdentification, String storageNode, String path, String name, Integer size, String type, Integer uploaderId, String uploadTime, Integer useCount, Integer del, String createTime, String modifyTime) {
        this.id = id;
        this.uuid = uuid;
        this.hashCode = hashCode;
        this.systemIdentification = systemIdentification;
        this.storageNode = storageNode;
        this.path = path;
        this.name = name;
        this.size = size;
        this.type = type;
        this.uploaderId = uploaderId;
        this.uploadTime = uploadTime;
        this.useCount = useCount;
        this.del = del;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getSystemIdentification() {
        return systemIdentification;
    }

    public void setSystemIdentification(String systemIdentification) {
        this.systemIdentification = systemIdentification;
    }

    public String getStorageNode() {
        return storageNode;
    }

    public void setStorageNode(String storageNode) {
        this.storageNode = storageNode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Integer uploaderId) {
        this.uploaderId = uploaderId;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", systemIdentification='" + systemIdentification + '\'' +
                ", storageNode='" + storageNode + '\'' +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                ", uploaderId=" + uploaderId +
                ", uploadTime='" + uploadTime + '\'' +
                ", useCount=" + useCount +
                ", del=" + del +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
