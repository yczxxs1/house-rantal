package com.netflix.houserental.common.result;

public class ResultUtil {
	
	public static <T> ResultVo<T> success(T data){
		ResultVo<T> result=new ResultVo<T>();
		result.setData(data);
		result.setMessage(ResultCode.SUCCESS.getMessage());
		result.setStatus(ResultCode.SUCCESS.getCode());
		return result;
		
	}
	
	
	public static ResultVo<String> success(){
		ResultVo<String> result=new ResultVo<String>();
		result.setData(ResultCode.SUCCESS.getMessage());
		result.setStatus(ResultCode.SUCCESS.getCode());
		return result;
		
	}
	

}
