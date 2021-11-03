package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.UserModel;
import com.user.serviceImplementation.UserServiceImplementation;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImplementation userImpl;

	@PostMapping("/registration")
	public String registration(@RequestBody UserModel user) {
          String message=userImpl.registration(user);
		   return message;
	}
	
	@PutMapping("/update")
	public String update(@RequestBody UserModel user) {
		String message=userImpl.update(user);
		return message;
	}
	
	@GetMapping("/getById/{id}")
    public UserModel getById(@PathVariable Long id) {
		UserModel user= userImpl.getById(id);
		return user;
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable Long id) {
		String message=userImpl.deleteById(id);
		return message;
	}
	
	@GetMapping("/searchByNameAndEmail")
	public List<UserModel> searchByNameAndEmail(@RequestBody UserModel user) {
		List<UserModel> model=userImpl.searchByNameAndEmail(user);
		return model;
	}
}
