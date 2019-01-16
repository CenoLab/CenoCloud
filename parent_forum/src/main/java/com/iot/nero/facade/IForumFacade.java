package com.iot.nero.facade;

import com.iot.nero.parent_facade.entity.Activity;
import com.iot.nero.parent_facade.entity.Attention;
import com.iot.nero.parent_facade.entity.Entry;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/29
 * Time   下午3:33
 */
public interface IForumFacade {
    List<Entry> getEntry();

    List<Activity> getActivities(Integer page, Integer num);

    List<Attention> getAttentions(Integer page, Integer num);
}
