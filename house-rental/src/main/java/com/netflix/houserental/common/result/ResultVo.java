package com.netflix.houserental.common.result;

public class ResultVo<T> {

	private int status;
	private String message;
	private T data;

	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	//业务异常返回结果
	public ResultVo(String message) {
		super();
		this.status = ResultCode.BUSINESS.getCode();
		this.message = message;
		data=null;
	}

	public ResultVo() {
		super();
	}

	//非业务异常
	public ResultVo(ResultCode resultCode) {
		super();
		this.status=resultCode.getCode();
		this.message=resultCode.getMessage();	
	}
	//成功返回
	public ResultVo(T data) {
		super();
		this.status=ResultCode.SUCCESS.getCode();
		this.message=ResultCode.SUCCESS.getMessage();
		this.data=data;
	}
	
}
