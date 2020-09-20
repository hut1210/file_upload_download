package com.cebbank.occm.hk.customer.utils;

import com.cebbank.occm.hk.customer.domain.AttachmentInfo;
import com.cebbank.occm.hk.customer.domain.FileInfo;
import com.cebbank.occm.hk.customer.exception.FileException;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hut
 * @date 2020/9/20 12:01 下午
 */
public class UploadUtil {

    /**
     * Description: uploadCustomerAttachFile
     * Date: 2020/9/20 2:25 下午
     * @param multipartFile
     * @param path
     * @return cn.hxh.files.domain.AttachmentInfo
    */
    public static AttachmentInfo uploadCustomerAttachFile(MultipartFile multipartFile, String path) throws IOException {
        //文件大小
        long size = multipartFile.getSize();
        //判断文件大小
        if(!FileUtil.checkSize(size)){
            throw new FileException(multipartFile.getOriginalFilename()+"附件大小超过1M");
        }
        //旧文件名字
        String originalFilename = multipartFile.getOriginalFilename();
        //文件类型
        //String contentType = multipartFile.getContentType();
        //获取文件后缀名
        /*String[] split = contentType.split("/");
        String ext = "." + split[1];*/
        //获取下载路径url
        String s = ResourceUtils.getURL("classpath:").getPath() + "static/upload";
        String url = URLDecoder.decode(s);
        //封装AttachmentInfo
        AttachmentInfo attachmentInfo = new AttachmentInfo();
        String newFileName = originalFilename;
        attachmentInfo.setAttachName(newFileName);
        attachmentInfo.setAttachSize(size);

        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String catalogName = url + "/" + format;
        attachmentInfo.setAttachPath("/upload/" + format);

        path+="/$文件名称";
        path=catalogName;
        //创建文件夹目录
        FileUtil.createDir(path);
        //上传文件
        multipartFile.transferTo(new File(catalogName, newFileName));
        return attachmentInfo;
    }

    public static FileInfo uploadAttachFile(MultipartFile multipartFile, String path) throws IOException {
        //文件大小
        long size = multipartFile.getSize();
        //判断文件大小
        if(!FileUtil.checkSize(size)){
            throw new FileException(multipartFile.getOriginalFilename()+"附件大小超过1M");
        }
        //旧文件名字
        String originalFilename = multipartFile.getOriginalFilename();
        //文件类型
        //String contentType = multipartFile.getContentType();
        //获取文件后缀名
        /*String[] split = contentType.split("/");
        String ext = "." + split[1];*/
        //获取下载路径url
        String s = ResourceUtils.getURL("classpath:").getPath() + "static/upload";
        String url = URLDecoder.decode(s);

        String newFileName = originalFilename;

        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String catalogName = url + "/" + format;

        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(newFileName);
        fileInfo.setFileSize(size);
        fileInfo.setUploadPath("/upload/" + format);

        path+="/$文件名称";
        path=catalogName;
        //创建文件夹目录
        FileUtil.createDir(path);
        //上传文件
        multipartFile.transferTo(new File(catalogName, newFileName));
        return fileInfo;
    }
}
