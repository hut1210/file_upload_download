package com.cebbank.occm.hk.customer.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author hut
 * @date 2020/9/20 12:15 下午
 */
@Data
public class CustomerAttachInfo {

    private String no;
    //文档名称
    private String docName;
    
    private Integer docImportance;

    private String docSource;

    private String preparationUnit;

    private Date preparationDate;

    private String remark;

    private Long userId;

    private Long customerId;
}
