package com.cebbank.occm.hk.customer.service;

import com.cebbank.occm.hk.customer.pojo.User;


public interface UserService {

    User query(String username, String password);
}