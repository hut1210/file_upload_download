package com.cebbank.occm.hk.customer.domain;

import lombok.Data;

/**
 * @author hut
 * @date 2020/9/20 9:14 下午
 */
@Data
public class FileInfo {
    private String fileName;
    private Long fileSize;
    private String uploadPath;
}
