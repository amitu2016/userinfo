package com.amitu.userinfo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitu.userinfo.dto.UserDTO;
import com.amitu.userinfo.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		UserDTO savedUser = userService.addUser(userDTO);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("/fetchUserById/{userId}")
	public ResponseEntity<UserDTO> fetchUserDetailsById(@PathVariable Integer userId) {
		return userService.fetchUserDetailsById(userId);
	}
	
	@DeleteMapping("/deleteById/{userId}")
	public ResponseEntity<UserDTO> deleteUserDetailsById(@PathVariable Integer userId) {
		return userService.deleteUserById(userId);
	}

}
