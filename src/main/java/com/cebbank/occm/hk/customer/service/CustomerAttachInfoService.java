package com.cebbank.occm.hk.customer.service;

import com.cebbank.occm.hk.customer.domain.CustomerAttachInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author hut
 * @date 2020/9/20 12:31 下午
 */
public interface CustomerAttachInfoService {
    /**
     * Description: queryList 
     * Date: 2020/9/20 2:37 下午
     * @param customerAttachInfo
     * @return java.util.List<cn.hxh.files.domain.CustomerAttachInfo>
    */
    List<CustomerAttachInfo> queryList(CustomerAttachInfo customerAttachInfo);
    /**
     * Description: saveCustomerAttach 
     * Date: 2020/9/20 2:37 下午
     * @param file
     * @param customerAttachInfo
     * @return void
    */
    List<String> saveCustomerAttach(MultipartFile[] file, CustomerAttachInfo customerAttachInfo);
    /**
     * Description: updateCustomerAttach
     * Date: 2020/9/20 2:50 下午
     * @param file
     * @param customerAttachInfo
     * @return void
    */
    List<String> updateCustomerAttach(MultipartFile[] file, CustomerAttachInfo customerAttachInfo);
}
