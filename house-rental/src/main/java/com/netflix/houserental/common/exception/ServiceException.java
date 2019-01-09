package com.netflix.houserental.common.exception;

/**
 * 业务异常
 */
public class ServiceException  extends RuntimeException{

	
	private static final long serialVersionUID = 8052319746429159251L;
	
	
	public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
