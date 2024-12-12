package org.jsp.quiz.ExceptionClasess;

import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.Builder;
@Builder
public class NoUserFoundException extends RuntimeException {
	
	private String message;
	
	
	public NoUserFoundException()
	{
		
	}
	
	public NoUserFoundException(String message)
	{
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	

	
	

}
