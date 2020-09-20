package com.cebbank.occm.hk.customer.controller;

import com.cebbank.occm.hk.customer.domain.CustomerAttachInfo;
import com.cebbank.occm.hk.customer.service.CustomerAttachInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hut
 * @date 2020/9/20 12:14 下午
 */
@Controller
@RequestMapping("/customer/attach")
public class CustomerAttachInfoController {

    @Autowired
    private CustomerAttachInfoService customerAttachInfoService;

    @PostMapping("/queryList")
    @ResponseBody
    public List<CustomerAttachInfo> queryList(@RequestBody CustomerAttachInfo customerAttachInfo){
        //1.从session获取登录信息，获取到登录用户ID
        //模拟用户Id
        Long userId = 3L;
        customerAttachInfo.setUserId(userId);
        return customerAttachInfoService.queryList(customerAttachInfo);
    }

    @PostMapping("/saveCustomerAttach")
    @ResponseBody
    public String saveCustomerAttach(@RequestParam("file") MultipartFile[] file, HttpServletRequest request, CustomerAttachInfo customerAttachInfo){

        //1.从session获取登录信息，获取到登录用户ID
        //模拟用户Id
        Long userId = 3L;
        customerAttachInfo.setUserId(userId);
        List<String> list = customerAttachInfoService.saveCustomerAttach(file,customerAttachInfo);

        return list.toString();
    }
    @PostMapping("/updateCustomerAttach")
    @ResponseBody
    public String updateCustomerAttach(@RequestParam("file") MultipartFile[] file, HttpServletRequest request, CustomerAttachInfo customerAttachInfo){

        //1.从session获取登录信息，获取到登录用户ID
        //模拟用户Id
        Long userId = 3L;
        customerAttachInfo.setUserId(userId);
        List<String> list =customerAttachInfoService.updateCustomerAttach(file,customerAttachInfo);

        return list.toString();
    }
}
