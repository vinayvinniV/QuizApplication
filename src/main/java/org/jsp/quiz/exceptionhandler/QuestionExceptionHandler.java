package org.jsp.quiz.exceptionhandler;

import org.jsp.quiz.ExceptionClasess.NoIdQuestionFoundException;
import org.jsp.quiz.ExceptionClasess.NoQuestionFoundException;
import org.jsp.quiz.ExceptionClasess.NoUserFoundException;
import org.jsp.quiz.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuestionExceptionHandler {
	
	@ExceptionHandler(NoQuestionFoundException.class)
	public ResponseEntity<?> noQuestionFoundException(NoQuestionFoundException e)
	{		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("No Question Found Exception").body("No Question Found In Database").build());
	}

	@ExceptionHandler(NoIdQuestionFoundException.class)
	public ResponseEntity<?>  noIdQuestionFoundException(NoIdQuestionFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("No Id found Exception").body("No Question By Id In Database").build());
	}
	
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<?> noUserFoundException(NoUserFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().httpStatus(HttpStatus.NOT_FOUND.value()).message("No User Found Exception").body("No User Found In Database").build());
	}
}
