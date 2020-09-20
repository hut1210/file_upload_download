package com.cebbank.occm.hk.customer.service;

import com.cebbank.occm.hk.customer.domain.AttachmentInfo;

/**
 * @author hut
 * @date 2020/9/20 1:59 下午
 */
public interface AttachmentInfoService {
    /**
     * Description: saveAttachmentInfo 
     * Date: 2020/9/20 2:41 下午
     * @param attachmentInfo
     * @return void
    */
    void saveAttachmentInfo(AttachmentInfo attachmentInfo);
    /**
     * Description: deleteAttachmentInfo
     * Date: 2020/9/20 3:46 下午
     * @param no
     * @return void
    */
    void deleteAttachmentInfo(String no);
}
