package org.jsp.quiz.daoimpl;

import java.util.List;

import org.apache.catalina.User;
import org.jsp.quiz.dao.UserDao;
import org.jsp.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User saveUser(User user) {
		
		
		return repository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return repository.findAll();
	}

}
