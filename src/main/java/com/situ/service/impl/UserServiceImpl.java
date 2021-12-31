package com.situ.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.situ.dao.UserDAO;
import com.situ.model.User;
import com.situ.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO dao;

	@Override
	public boolean checkLogin(User user) {
		User dbUser = dao.findByUsername(user.getUsername());

		System.out.println(user.getUsername());

		if (dbUser == null) {
			return false;
		}

		// 假如说：在数据库中新增用户的时候，密码是：username{password}的md5格式
		String encrypt = user.getUsername() + "{" + user.getPassword() + "}";
		System.out.println(user.getPassword());
		String md5Str = DigestUtils.md5DigestAsHex(encrypt.getBytes());

		if (md5Str.equals(dbUser.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

}
