package com.iot.nero.facade_resources.facade.impl;

import com.iot.nero.facade.IResourcesFacade;
import com.iot.nero.facade_resources.dao.FileDao;
import com.iot.nero.facade_resources.dao.FileLimitDao;
import com.iot.nero.parent_resources.entity.FileLimit;
import com.iot.nero.parent_resources.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author neroyangs
 * Email  nerosoft@outlook.com
 * Date   2017/7/21
 * Time   下午12:08
 */
public class ResourcesFacade implements IResourcesFacade {


        @Autowired
        private FileDao fileDao;

        @Autowired
        private FileLimitDao fileLimitDao;



        public boolean isTypeAllow(String systemIdentification,String type){

            Map<String,Boolean> allowMap = new HashMap<String, Boolean>();

            // TODO 此处应该数据库并缓存下
            List<FileLimit> fileLimits = fileLimitDao.listFileLimits(systemIdentification);
            if(!fileLimits.isEmpty()){
                for (FileLimit fileLimit:fileLimits){
                    allowMap.put(fileLimit.getType(),true);
                }
            }

            if(allowMap.get(type)!=null && allowMap.get(type)){
                return true;
            }
            return false;
        }

    public Resource addResource(byte[] file, Integer uploaderId, String fileName,String systemIdentification) {
        return null;
    }

    public Resource getResourceById(Integer resourceId) {
        return null;
    }

    public Resource getResourceByUuid(String uuId) {
        return null;
    }

    public Resource getResourceByHashCode(String uuId) {
        return null;
    }
}
