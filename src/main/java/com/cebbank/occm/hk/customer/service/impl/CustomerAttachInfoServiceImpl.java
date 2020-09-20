package com.cebbank.occm.hk.customer.service.impl;

import com.cebbank.occm.hk.customer.domain.AttachmentInfo;
import com.cebbank.occm.hk.customer.domain.CustomerAttachInfo;
import com.cebbank.occm.hk.customer.mapper.CustomerAttachInfoDao;
import com.cebbank.occm.hk.customer.service.AttachmentInfoService;
import com.cebbank.occm.hk.customer.service.CustomerAttachInfoService;
import com.cebbank.occm.hk.customer.utils.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hut
 * @date 2020/9/20 12:42 下午
 */
@Service
@Slf4j
public class CustomerAttachInfoServiceImpl implements CustomerAttachInfoService {
    @Autowired
    private CustomerAttachInfoDao customerAttachInfoDao;
    @Autowired
    private AttachmentInfoService attachmentInfoService;
    @Override
    public List<CustomerAttachInfo> queryList(CustomerAttachInfo customerAttachInfo) {
        return customerAttachInfoDao.queryList(customerAttachInfo);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List<String> saveCustomerAttach(MultipartFile[] file, CustomerAttachInfo customerAttachInfo){
        String no = "3";
        //1.获取资料信息编号
        customerAttachInfo.setNo(no);
        //1.保存客户资料基本信息
        customerAttachInfoDao.saveCustomerAttachInfo(customerAttachInfo);
        //2.保存附件。
        List<String> errorMsgList = saveAttachment(file,customerAttachInfo);
        return errorMsgList;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List<String> updateCustomerAttach(MultipartFile[] file, CustomerAttachInfo customerAttachInfo) {
        //1.修改客户资料基本信息
        customerAttachInfoDao.updateCustomerAttachInfo(customerAttachInfo);
        //删除关联的附件信息
        attachmentInfoService.deleteAttachmentInfo(customerAttachInfo.getNo());
        //2.保存附件。
        List<String> errorMsgList= saveAttachment(file,customerAttachInfo);
        return errorMsgList;
    }

    private List<String> saveAttachment(MultipartFile[] file, CustomerAttachInfo customerAttachInfo) {
        String path="?OCCM/HK/customer/"+customerAttachInfo.getCustomerId()+"/"+customerAttachInfo.getDocName();
        List<String> errorMsgList = new ArrayList<>();
        for (MultipartFile multipartFile : file){
            try {
                //上传文件，返回附件信息
                AttachmentInfo attachmentInfo = UploadUtil.uploadCustomerAttachFile(multipartFile,path);
                //封装附件信息编号 TODO 动态获取编号
                attachmentInfo.setAttachNo("1");
                //封装客户资料信息编号
                attachmentInfo.setCustomerAttachInfoNo(customerAttachInfo.getNo());
                attachmentInfo.setUploadTime(new Date());
                //保存附件信息
                attachmentInfoService.saveAttachmentInfo(attachmentInfo);
            }catch (Exception e){
                String errorMsg = "上传"+multipartFile.getOriginalFilename()+"附件失败"+e.getMessage();
                e.printStackTrace();
                log.error("上传"+multipartFile.getOriginalFilename()+"附件失败",e.getMessage());
                errorMsgList.add(errorMsg);
            }
        }
        return errorMsgList;
    }
}
