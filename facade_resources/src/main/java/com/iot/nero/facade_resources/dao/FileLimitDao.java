package com.iot.nero.facade_resources.dao;

import com.iot.nero.parent_resources.entity.FileLimit;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/6/2
 * Time   下午4:41
 */
public interface FileLimitDao {

    List<FileLimit> listFileLimits(String systemIdentification);
}
