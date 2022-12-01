package com.bookstore.dao;

import com.bookstore.pojo.User;

// Using interface we are registering all the method of User Model

public interface I_User 
{
	public void register(User user);
	public User login(String userEmail,String userPassword);
	
	// future methods
	public void updateProfile(int userId,User user);
	public void changePassword(String userEmail,String currentPassword,
			String newPassword);
}
