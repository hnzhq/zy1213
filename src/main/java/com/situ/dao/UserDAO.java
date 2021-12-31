package com.situ.dao;

import org.apache.ibatis.annotations.Mapper;

import com.situ.model.User;

@Mapper
public interface UserDAO {
    /**
     * 根据用户名查询唯一符合条件用户
     * 
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
