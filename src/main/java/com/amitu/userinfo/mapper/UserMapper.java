package com.amitu.userinfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.amitu.userinfo.dto.UserDTO;
import com.amitu.userinfo.entity.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User mapUserDTOToUser(UserDTO userDTO);

	UserDTO mapUserToUserDTO(User user);
}
