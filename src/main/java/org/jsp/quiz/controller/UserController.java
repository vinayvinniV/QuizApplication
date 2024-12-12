package org.jsp.quiz.controller;

import org.apache.catalina.User;
import org.jsp.quiz.dto.UserDto;
import org.jsp.quiz.responseStructure.ResponseStructure;
import org.jsp.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllUsers()
	{
		return service.findAllUsers();
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<User>> findUserByEmailAndPassword(@RequestBody UserDto userdto)
	{
		return service.findUserByEmailAndPassword();
	}

}
