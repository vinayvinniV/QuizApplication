package org.jsp.quiz.ExceptionClasess;

import lombok.Builder;

@Builder
public class NoIdQuestionFoundException extends RuntimeException{
	
	private String message;
	
	public NoIdQuestionFoundException()
	{
		
	}
	
	public NoIdQuestionFoundException(String message)
	{
		this.message=message;
	}
	
	
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	

}
