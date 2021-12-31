package com.situ.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.situ.util.ExceptionUtil;

/**
 * 全局统一异常处理
 * 
 * @author snow1k
 * @date 2021/12/23
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 处理异常。@ExceptionHandler表示用于处理异常
	 * 
	 * @return
	 */
	@ExceptionHandler
	public ModelAndView handleException1(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("global/error");
		mav.addObject("title", exception.getMessage());
		mav.addObject("error", "异常了");
		mav.addObject("popup", true);
		// 异常堆栈信息
		mav.addObject("exception", ExceptionUtil.exceptionToString(exception));
		return mav;
	}

	@ExceptionHandler
	public ModelAndView handleException1(ArithmeticException exception) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("global/error");
		mav.addObject("title", exception.getMessage());
		mav.addObject("error", "异常了，数学运算异常");
		mav.addObject("popup", true);
		// 异常堆栈信息
		mav.addObject("exception", ExceptionUtil.exceptionToString(exception));
		return mav;
	}
}
