package com.example.onlineLibraryManagementSystem.service;

import com.example.onlineLibraryManagementSystem.dto.UserDto;
import com.example.onlineLibraryManagementSystem.exception.InvalidCredentialsException;

public interface UserService {

	/**
	 * 
	 * This method is used to register User
	 * @param userDto
	 */
	public void addUser(UserDto userDto);

	/**
	 * This method is used to authenticate User
	 * @param loginDto
	 * @return boolean true if an authenticated User else false
	 * @throws InvalidCredentialsException 
	 */
	public boolean authenticateUser(String userName, String password) throws InvalidCredentialsException;
}
