package com.cebbank.occm.hk.customer.mapper;

import com.cebbank.occm.hk.customer.domain.AttachmentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hut
 * @date 2020/9/20 2:31 下午
 */
@Mapper
@Repository
public interface AttachmentInfoDao {
    /**
     * Description: saveAttachmentInfo 
     * Date: 2020/9/20 2:41 下午
     * @param attachmentInfo
     * @return void
    */
    void saveAttachmentInfo(AttachmentInfo attachmentInfo);

    /**
     * Description: deleteAttachmentInfo 
     * Date: 2020/9/20 3:47 下午
     * @param customAttachmentNo
     * @return void
    */
    void deleteAttachmentInfo(String customAttachmentNo);
}
