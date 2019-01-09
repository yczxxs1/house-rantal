package com.netflix.houserental.common.result;

public enum ResultCode {
	SUCCESS(0, "成功！"), 
	BUSINESS(1, "业务异常！"), 
	DATABASE(10, "数据库错误!"), 
	VALIDATION(20, "验证错误!"), 
	ERROR(1000, "未知错误！");

	private int code;
	private String message;

	private ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
