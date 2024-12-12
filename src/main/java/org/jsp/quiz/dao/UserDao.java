package org.jsp.quiz.dao;

import java.util.List;

import org.apache.catalina.User;

public interface UserDao {

	User saveUser(User user);

	List<User> findAllUsers();

}
