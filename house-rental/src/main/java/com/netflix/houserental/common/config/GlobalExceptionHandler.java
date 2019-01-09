package com.netflix.houserental.common.config;

import com.netflix.houserental.common.exception.ServiceException;
import com.netflix.houserental.common.result.ResultVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//全局统一异常处理
@RestControllerAdvice
@SuppressWarnings("rawtypes")
public class GlobalExceptionHandler {


    @ExceptionHandler(value = ServiceException.class)
    public ResultVo serviceErrorHandler(HttpServletRequest request, HttpServletResponse response, ServiceException e) throws Exception {
        return new ResultVo(e.getMessage());
    }
	


	
	/*@ExceptionHandler(value = IllegalArgumentException.class)
	public void IllegalArgumentExceptionErrorHandler(HttpServletRequest req, HttpServletResponse response, IllegalArgumentException e) throws Exception {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}*/

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ResultVo> IllegalArgumentExceptionErrorHandler(HttpServletRequest req, HttpServletResponse response, IllegalArgumentException e) throws Exception {
        //HttpStatus status = HttpStatus.BAD_REQUEST;
        ResponseEntity<ResultVo> responseEntity = new ResponseEntity<ResultVo>(new ResultVo(e.getMessage()), HttpStatus.BAD_REQUEST);
        return responseEntity;
    }


}
