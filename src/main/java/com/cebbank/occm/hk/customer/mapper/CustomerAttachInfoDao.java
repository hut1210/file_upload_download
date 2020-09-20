package com.cebbank.occm.hk.customer.mapper;

import com.cebbank.occm.hk.customer.domain.CustomerAttachInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hut
 * @date 2020/9/20 12:44 下午
 */
@Mapper
@Repository
public interface CustomerAttachInfoDao {
    /**
     * Description: queryList 
     * Date: 2020/9/20 3:58 下午
     * @param customerAttachInfo
     * @return java.util.List<cn.hxh.files.domain.CustomerAttachInfo>
    */
    List<CustomerAttachInfo> queryList(CustomerAttachInfo customerAttachInfo);
    /**
     * Description: saveCustomerAttachInfo 
     * Date: 2020/9/20 3:58 下午
     * @param customerAttachInfo
     * @return void
    */
    void saveCustomerAttachInfo(CustomerAttachInfo customerAttachInfo);
    /**
     * Description: updateCustomerAttachInfo 
     * Date: 2020/9/20 3:58 下午
     * @param customerAttachInfo
     * @return void
    */
    void updateCustomerAttachInfo(CustomerAttachInfo customerAttachInfo);
}
