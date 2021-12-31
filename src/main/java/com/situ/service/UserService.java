package com.situ.service;

import com.situ.model.User;

public interface UserService {
	/**
	 * 检查是否登录成功
	 * 
	 * @return
	 */
	public boolean checkLogin(User user);
}
