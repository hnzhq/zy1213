package com.situ.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;

@Controller
public class CaptchaController {
	@Autowired
	private DefaultKaptcha captchaProducer;

	private String yanzhengma;

	/**
	 * 验证码请求
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/captcha")
	public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		// 获取验证码
		// String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		// String code = (String) session.getAttribute("Kaptcha_Code");

		// 清除浏览器的缓存
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");

		// 生成验证码图片
		response.setContentType("image/jpeg");
		// 浏览器记忆功能-----当前过浏览器和服务器交互成功以后下载的图片和资源会进行缓存一次。下次刷新的时候就不会在到服务器去下载。
		// 获取KAPTCHA验证的随机文本
		String capText = captchaProducer.createText();

		// 将生成好的图片放入会话中
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		// 创建所生成文本对应的验证码图片
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		// 写入到输出流
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();// 关闭
		}
		return null;
	}

}
