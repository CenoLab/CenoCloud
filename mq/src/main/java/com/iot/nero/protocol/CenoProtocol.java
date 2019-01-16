package com.iot.nero.protocol;

import java.io.Serializable;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/12/18
 * Time   下午1:50
 */
public class CenoProtocol implements Serializable {
    /**
     * 协议版本说明
     * 协议版本为8位
     * 默认第一版本为 00000001
     */
    private byte[] version; //协议版本                                                                  8
    /**
     * 协议类型说明
     * 协议类型为4位
     * 0000 正常数据通讯
     * 0001 系统数据点协议下发
     * 0010 设备数据点协议解析成功上行
     * 0011 设备数据点协议解析失败上行
     * 0100 远程muc更新命令下发
     * 0101 远程muc更新成功上行
     * 0110 远程muc更新失败上行
     */
    private byte[] type; //协议类型                                                                       4
    private byte[] app_version;// 应用版本                                                           4
    //系统协议剩余16位待定

    /**
     * 数据协议：
     * 当系统协议 type 为 0001 时，data 为 json数据协议。
     * 当系统协议 type 为 0000 时，data 为 正常设备数据，按照用户数据协议解析。
     */
    private byte[] data;



    private String dataString;

    byte[] encode(){
        byte[] finalProtocol = new byte[16+dataString.getBytes().length];
        return null;
        //return version+type+app_version+dataString.getBytes();
    }

}
