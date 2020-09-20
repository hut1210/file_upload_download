package com.cebbank.occm.hk.customer.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author hut
 * @date 2020/9/20 1:50 下午
 */
@Data
public class AttachmentInfo {
    private String attachNo;
    private String attachName;
    private Long attachSize;
    private String attachPath;
    private String customerAttachInfoNo;
    private Date uploadTime;
}
