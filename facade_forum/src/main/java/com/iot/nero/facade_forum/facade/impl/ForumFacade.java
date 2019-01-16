package com.iot.nero.facade_forum.facade.impl;

import com.iot.nero.facade.IForumFacade;
import com.iot.nero.facade_forum.dao.ActivityDao;
import com.iot.nero.facade_forum.dao.AttentionDao;
import com.iot.nero.facade_forum.dao.EntryDao;
import com.iot.nero.parent_facade.entity.Activity;
import com.iot.nero.parent_facade.entity.Attention;
import com.iot.nero.parent_facade.entity.Entry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/29
 * Time   下午3:40
 */
public class ForumFacade implements IForumFacade {

    @Autowired
    private EntryDao entryDao;

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private AttentionDao attentionDao;


    public List<Entry> getEntry() {
        return entryDao.listEntries();
    }

    public List<Activity> getActivities(Integer page, Integer num) {
        return activityDao.listActivities(page,num);
    }

    public List<Attention> getAttentions(Integer page, Integer num) {
        return attentionDao.listAttentions(page,num);
    }
}
