package com.ktdsuniversity.admin.common.api.exceptions;

public class ApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7688028017417330995L;
	
	private String errorCode;
	
	public ApiException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
}
