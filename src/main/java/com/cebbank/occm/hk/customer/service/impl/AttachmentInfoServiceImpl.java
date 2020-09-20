package com.cebbank.occm.hk.customer.service.impl;

import com.cebbank.occm.hk.customer.domain.AttachmentInfo;
import com.cebbank.occm.hk.customer.mapper.AttachmentInfoDao;
import com.cebbank.occm.hk.customer.service.AttachmentInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hut
 * @date 2020/9/20 2:00 下午
 */
@Service
@Slf4j
public class AttachmentInfoServiceImpl implements AttachmentInfoService {
    @Autowired
    private AttachmentInfoDao attachmentInfoDao;
    @Override
    public void saveAttachmentInfo(AttachmentInfo attachmentInfo) {
        attachmentInfoDao.saveAttachmentInfo(attachmentInfo);
    }

    @Override
    public void deleteAttachmentInfo(String customAttacmentNo) {
        attachmentInfoDao.deleteAttachmentInfo(customAttacmentNo);
    }
}
