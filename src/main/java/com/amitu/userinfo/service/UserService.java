package com.amitu.userinfo.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amitu.userinfo.dto.UserDTO;
import com.amitu.userinfo.entity.User;
import com.amitu.userinfo.mapper.UserMapper;
import com.amitu.userinfo.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repo;

	public UserService(UserRepository repo) {
		this.repo = repo;
	}

	public UserDTO addUser(UserDTO userDTO) {
		User savedUser = repo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);

	}

	public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
		Optional<User> fetchedUser = repo.findById(userId);
		if (fetchedUser.isPresent())
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()), HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<UserDTO> deleteUserById(Integer userId) {
		Optional<User> fetchedUser = repo.findById(userId);
		if (fetchedUser.isPresent()) {
			repo.deleteById(userId);
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
