package com.situ.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.model.User;
import com.situ.service.UserService;

/**
 * 登录控制器
 * 
 * @author snow1k
 * @date 2021/12/22
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService us;

	@GetMapping(value = { "", "/" })
	public String login() {
		return "/login";
	}

	@PostMapping(value = { "", "/" })
	public String login(User user, Map<String, Object> map, HttpServletRequest request) {
		boolean passed = us.checkLogin(user);
		// System.out.println(user.getCaptcha());

		String sessionCode = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String checkCode = user.getCaptcha();
		// String isSuccess = "";
		if (checkCode != null && checkCode.equals(sessionCode)) {
			if (passed) {
				request.getSession().setAttribute("##current_login_user##", user);

				return "staff/list";
			} else {
				map.put("error", "用户名或密码错误");
				return "login";
			}
		} else {
			map.put("error", "验证错误");
			return "login";
		}

	}
}
