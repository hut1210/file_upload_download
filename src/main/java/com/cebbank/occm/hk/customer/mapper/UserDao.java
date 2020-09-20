package com.cebbank.occm.hk.customer.mapper;

import com.cebbank.occm.hk.customer.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-21 13:46:01
 */
@Mapper
@Repository
public interface UserDao {

    User query(String username, String password);
}