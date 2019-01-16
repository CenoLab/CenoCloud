package com.iot.nero.facade_forum.dao;

import com.iot.nero.parent_facade.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   下午7:50
 */
public interface TagDao {

    List<Tag> listTags(@Param("tag") String tag);

    Tag findTagById(@Param("id") Integer id);

    Integer addTag(@Param("name") String name, @Param("authorId") Integer authorId);
}
