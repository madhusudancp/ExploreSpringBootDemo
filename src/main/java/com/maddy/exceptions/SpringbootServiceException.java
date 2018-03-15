package com.maddy.exceptions;

import com.maddy.webtos.ExceptionDto;

public class SpringbootServiceException  extends RuntimeException {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		public SpringbootServiceException() {
	        super();
	    }
	    public SpringbootServiceException(String message, Throwable cause) {
	        super(message, cause);
	    }
	    public SpringbootServiceException(ExceptionDto exceptionDto) {
	        super(exceptionDto.getErrorMessage());
	        this.exceptionDto=exceptionDto;
	    }
	   private ExceptionDto exceptionDto;

	public ExceptionDto getExceptionDto() {
		return exceptionDto;
	}
	public void setExceptionDto(ExceptionDto exceptionDto) {
		this.exceptionDto = exceptionDto;
	}
	   
	    
}
