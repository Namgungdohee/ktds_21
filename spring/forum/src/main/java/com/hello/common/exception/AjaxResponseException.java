package com.hello.common.exception;

public class AjaxResponseException extends RuntimeException {
	
	private static final long serialVersionUID = - 1915517486526260958L;
	
	public AjaxResponseException(String msg) {
		super(msg);
	}

}
