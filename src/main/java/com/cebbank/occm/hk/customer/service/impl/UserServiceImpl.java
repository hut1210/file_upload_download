package com.cebbank.occm.hk.customer.service.impl;

import com.cebbank.occm.hk.customer.mapper.UserDao;
import com.cebbank.occm.hk.customer.pojo.User;
import com.cebbank.occm.hk.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-07-21 13:46:03
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User query(String username, String password) {
        return userDao.query(username,password);
    }
}