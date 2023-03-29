package com.hello.common.exceptionhandler;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.common.exception.AjaxResponseException;

@ControllerAdvice({"com.hello", "org.springframework"})
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(AjaxResponseException.class)
	@ResponseBody
	public Map<String, Object> handleAjaxResponseException(AjaxResponseException are) {
		Map<String, Object> ajaxError = new HashMap<>();
		ajaxError.put("status", "fail");
		ajaxError.put("message",are.getMessage());
		return ajaxError;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException re, Model model) {
		logger.info("예외가 발생했습니다!! {}", re.getMessage());
		model.addAttribute("message", re.getMessage());
		return "errors/500";
	}

}
