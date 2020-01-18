package com.mohan.rest.webservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mohan.rest.webservices.restfulwebservices.object.User;

@Component
public class UserDaoService {

	public static List<User> users = new ArrayList<User>();
	private static Integer userCount = 3;
	
	static {
		users.add(new User(1, "Mohan", new Date()));
		users.add(new User(2, "Mohan1", new Date()));
		users.add(new User(3, "Mohan2", new Date()));
	}
	
	//List all users
	public List<User> getAllUsers() {
		return users;
	}
	
	//add new user
	public User addNewUser(User user) {
		if(user != null && user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	//find user
	public User getUserwithId(Integer id) {
		for(User user:users) {
			if(id == user.getId()) {
				return user;
			} 
		}
		return null;
	}
	
	public User deleteUserById(Integer userId) {
		Iterator<User> userIterator = users.iterator();
		while (userIterator.hasNext()) {
			User user = (User) userIterator.next();
			if(user.getId() == userId) {
				userIterator.remove();
				return user;
			}
		}
		return null;
	}
	
}
