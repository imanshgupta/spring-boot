package com.example.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User;
import com.example.demo.UserInterface;

@RestController
public class UserController {
	
	
	@Autowired
	private UserInterface userInterface;
	
	@GetMapping("/user")
	public java.util.List<User> getAllUser() {
	Iterable<User> user=userInterface.findAll();
		
	Iterator<User> uIterator=user.iterator();
	
	java.util.List<User> users=new ArrayList<>();
	
	user.forEach(x->users.add(x));
	
	return users;
	}
	
	@GetMapping("/user{id}")
	public User getUserById(@PathVariable("id") int id) {
		User user=null;
		try {
		Optional<User> optional=userInterface.findById(id);
		User u=optional.get();
		return u;
		}catch (Exception e) {
			System.out.println("NO DATA FOUND");
		}
		return user;
	}
	
	
	@PostMapping("/user")
	public User createuser(@RequestBody User user) {
		User user2=	userInterface.save(user);
		return user2;
	}
	
	@DeleteMapping("/user/{id}")
	@ResponseBody
	public String deleteuser(@PathVariable("id") int id) {
		try {
		 userInterface.deleteById(id);
		 return("USER DELETED");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("NO USER FOUND TO DELETE WITH SUCH ID");
			return("NO USER FOUND");
		}

		
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") int id,@RequestBody User user) {
		
		User user1=null;
		try {
		Optional<User> optional=userInterface.findById(id);
		User u=optional.get();
		u.setName(user.getName());
		u.setAddress(user.getAddress());
		
		userInterface.save(u);
		
		return u;
		}catch (Exception e) {
			System.out.println("NO DATA FOUND");
		}
		return user;
		
		
	}
	
	
	
}
