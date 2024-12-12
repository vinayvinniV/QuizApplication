package org.jsp.quiz.serviceImpl;

import java.awt.desktop.QuitResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.quiz.ExceptionClasess.NoIdQuestionFoundException;
import org.jsp.quiz.ExceptionClasess.NoQuestionFoundException;
import org.jsp.quiz.dao.QuestionDao;
import org.jsp.quiz.dto.QuestionDto;
import org.jsp.quiz.dto.QuizResponse;
import org.jsp.quiz.entity.Question;
import org.jsp.quiz.responseStructure.ResponseStructure;
import org.jsp.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.Builder;
@Service
@Builder
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionDao dao;

	
	@Override
	public ResponseEntity<?> saveQuestion(Question question) {
		
	 question=dao.saveQuestion(question);
	 
	 return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
             .httpStatus(HttpStatus.OK.value())
             .message("All Questions Found Successfully")
             .body(question)
             .build()) ; 		
	}
	
	

	@Override
	public ResponseEntity<?> findAllQusetions() {
//	List<Question> questions=dao.findAllQusetions();
		
		List<Question> questions=dao.findAllActiveQusetions();
		
		List<QuestionDto> dtolist=new ArrayList<>();
		
		for(Question q:questions) 
			dtolist.add(new QuestionDto(q.getTitle(),q.getA(),q.getB(),q.getC(),q.getD()));
		
		
		if(dtolist.isEmpty())
		{
			throw NoQuestionFoundException.builder().message("No Question Found In The Database").build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
				                                                           .httpStatus(HttpStatus.OK.value())
				                                                           .message("All Questions Found Successfully")
				                                                           .body(dtolist)
				                                                           .build()) ; 
	}



	@Override
	public ResponseEntity<?> findQuestionById(int id) {
		Optional<Question> optional=dao.findQuestionById(id);
		if(optional.isEmpty())
		{
			throw NoIdQuestionFoundException.builder().message("No Question Found In The Database").build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
                .httpStatus(HttpStatus.OK.value())
                .message("Question Found By Id Successfully")
                .body(optional.get())
                .build()) ; 
	}



	@Override
	public ResponseEntity<?> submitQuiz(List<QuizResponse> quizResponses) {
		int c=0;
		for(QuizResponse qr:quizResponses)
		{
			Optional<Question> q=dao.findQuestionById(qr.getId());
			
//			if(q.isEmpty())
//			{
//				throw NoIdQuestionFoundException.builder().message("Invalid Question Id Unable To Find").build();
//			}
			
			Question question=q.get();
			if(question.getAns().equalsIgnoreCase(qr.getAns()))
			{
				c++;
			}
			
		}
		
		
		return  ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
                .httpStatus(HttpStatus.OK.value())
                .message("Question Found By Id Successfully")
                .body("Your score :"+ c)
                .build()) ; 
	}



	@Override
	public ResponseEntity<?> takeQuiz() {
		List<Question> qu=dao.takeQuiz();
		return  ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
                .httpStatus(HttpStatus.OK.value())
                .message("Question Found By Id Successfully")
                .body(qu.get(0))
                
                .build()) ; 
	}
	
	
	
	

}
