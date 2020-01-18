package com.mohan.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mohan.rest.webservices.restfulwebservices.dao.UserDaoService;
import com.mohan.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.mohan.rest.webservices.restfulwebservices.object.User;
import com.mohan.rest.webservices.restfulwebservices.object.UserRepository;

@RestController
public class UserServiceJPAController {

	@Autowired
	private UserDaoService userService = new UserDaoService();
	
	@Autowired
	private UserRepository userRepository ;

	// Fetch users
	@GetMapping(path = "/jpa/users")
	List<User> getAllUsers() {
		return userRepository.findAll();

//HATEOAS concept...
	}

	// fetch user with ID
	@GetMapping(path = "/jpa/users/{id}")
	User getUserDetailsWithID(@PathVariable Integer id) {
		
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id=" + id);
		}
		return user;
	}

	// fetch user with ID
	@GetMapping(path = "/jpa/delete-user/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}

	// Add user
	@PostMapping(path = "/jpa/addUser")
	ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		
		
		
		  User usr = userRepository.save(user);
		  
		  URI location = ServletUriComponentsBuilder
		  .fromCurrentRequest().path("/{id}") .buildAndExpand(usr.getId()).toUri();
		  
		 
		// Fetching user details using HATEOAS concept.
		// 'all-users', SERVER_PATH + "/users"
		// getAllUsers

		/*
		 * EntityModel<User> resource = new EntityModel<User>(usr);
		 * 
		 * ControllerLinkBuilder linkTo =
		 * linkTo(methodOn(this.getClass()).getAllUsers());
		 * resource.add(linkTo.withRel("all-users"));
		 */

		return ResponseEntity.created(location).build();
		// return resource;
	}

}
