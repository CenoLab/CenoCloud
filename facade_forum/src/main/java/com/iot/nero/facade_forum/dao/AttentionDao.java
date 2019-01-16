package com.iot.nero.facade_forum.dao;

import com.iot.nero.parent_facade.entity.Attention;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/29
 * Time   下午3:41
 */
public interface AttentionDao {
    List<Attention> listAttentions(@Param("page") Integer page,
                                   @Param("num") Integer num);
}
