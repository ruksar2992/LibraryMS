package com.example.onlineLibraryManagementSystem.serviceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.onlineLibraryManagementSystem.dao.UserDao;
import com.example.onlineLibraryManagementSystem.dto.UserDto;
import com.example.onlineLibraryManagementSystem.exception.InvalidCredentialsException;
import com.example.onlineLibraryManagementSystem.model.User;
import com.example.onlineLibraryManagementSystem.service.UserService;



@Service
public class UserServiceImpl implements UserService {
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	UserDao userDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addUser(@RequestBody UserDto userDto) {
		logger.info("implementation of user registration");
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		userDao.save(user);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws InvalidCredentialsException
	 */
	@Override
	public boolean authenticateUser(String userName, String password) throws InvalidCredentialsException {
		logger.info("implementaion of authenticating the user");
		User user = userDao.findByUserNameAndPassword(userName, password);
		if (user != null)
			return true;
		throw new InvalidCredentialsException("invalid credentials !! please try again with valid credentials");
	}

}
