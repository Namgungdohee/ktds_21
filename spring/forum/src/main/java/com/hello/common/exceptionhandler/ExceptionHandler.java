package com.hello.common.exceptionhandler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice({"com.hello", "org.springframework"})
public class ExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException re) {
		logger.info("예외가 발생했습니다!! {}", re.getMessage());
		return "";
	}
}
