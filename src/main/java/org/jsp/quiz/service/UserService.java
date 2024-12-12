package org.jsp.quiz.service;

import org.apache.catalina.User;
import org.jsp.quiz.responseStructure.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findAllUsers();

	ResponseEntity<ResponseStructure<User>> findUserByEmailAndPassword();

}
