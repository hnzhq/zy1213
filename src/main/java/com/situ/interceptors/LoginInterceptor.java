package com.situ.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.situ.model.User;

/**
 * 身份认证拦截
 * 
 * @date 2021/12/22
 */
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * 在到达Controller之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("##current_login_user##");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		} else {
			return true;
		}
	}

}
