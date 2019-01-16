package com.iot.nero.facade_forum.dao;

import com.iot.nero.parent_facade.entity.Entry;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/29
 * Time   下午3:40
 */
public interface EntryDao {
    List<Entry> listEntries();
}
