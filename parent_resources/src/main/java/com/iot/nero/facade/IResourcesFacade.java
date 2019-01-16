package com.iot.nero.facade;

import com.iot.nero.dto.Result;
import com.iot.nero.parent_resources.entity.Resource;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/21
 * Time   下午12:09
 */
public interface IResourcesFacade {

        /**
         * 存储资源
         * @param file
         * @param uploaderId
         * @param fileName
         * @return
         */
        Resource addResource(byte[] file, Integer uploaderId, String fileName,String systemIdentification);

        /**
         * 通过资源ID获取资源
         * @param resourceId
         * @return
         */
        Resource getResourceById(Integer resourceId);

        /**
         * 通过资源UUID获取资源
         * @param uuId
         * @return
         */
        Resource getResourceByUuid(String uuId);

        /**
         * 通过HashCode获取资源
         * @param uuId
         * @return
         */
        Resource getResourceByHashCode(String uuId);
}
