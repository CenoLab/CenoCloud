package com.iot.nero.facade_alarm.dao;

import com.iot.nero.parent_alarm.entity.Express;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/21
 * Time   下午4:14
 */
public interface ExpressDao {

    /**
     * 通过id获取表达式
     * @param eid
     * @return
     */
    Express getExpressById(@Param("id") Integer eid);

    /**
     * 获取所有表达式
     * @return
     */
    List<Express> getAllExpress();

    /**
     * 通过表达式获取表达式
     * @param expressStr
     * @return
     */
    Express getExpressByStr(@Param("express") String expressStr);
}
