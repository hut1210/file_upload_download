package com.cebbank.occm.hk.customer.utils;

import java.io.File;

/**
 * @author hut
 * @date 2020/9/20 2:11 下午
 */
public class FileUtil {
    private static Long limitFileSize = 10L;
    public static boolean checkSize(Long fileSize) {
        if (limitFileSize < fileSize) {
            return false;
        }
        return true;
    }
    public static void createDir(String path){
        File file=new File(path);
        if(!file.exists()&&!file.isDirectory()){
            //如果文件夹不存在，创建文件夹
            file.mkdirs();
        }
    }
}
