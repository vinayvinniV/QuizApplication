package org.jsp.quiz.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.jsp.quiz.ExceptionClasess.NoUserFoundException;
import org.jsp.quiz.dao.UserDao;
import org.jsp.quiz.dto.UserDto;
import org.jsp.quiz.responseStructure.ResponseStructure;
import org.jsp.quiz.service.UserService;
import org.jsp.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.Builder;

@Builder
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public ResponseEntity<?> saveUser(User user) {
		user=dao.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
	             .httpStatus(HttpStatus.OK.value())
	             .message("User Saved Successfully")
	             .body(user)
	             .build()) ; 	
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User> user=dao.findAllUsers();
		
		if(user.isEmpty())
		{
			throw NoUserFoundException.builder().message("No User Found Exception").build();
		}
		
		return  ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
	             .httpStatus(HttpStatus.OK.value())
	             .message("All Users Found Successfully")
	             .body(user)
	             .build()) ; 
	}

	@Override
	public ResponseEntity<ResponseStructure<User>> findUserByEmailAndPassword() {
		Optional<User> optional=dao.findStudentByEmailAndPassword(userdto.getEmail(),userdto.getPassword());
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder()
	             .httpStatus(HttpStatus.OK.value())
	             .message("All Users Found Successfully")
	             .body(optional)
	             .build());
	}

}
