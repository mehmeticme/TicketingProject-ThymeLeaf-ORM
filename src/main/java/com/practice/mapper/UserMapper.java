package com.practice.mapper;

import com.practice.dto.UserDTO;
import com.practice.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    ModelMapper modelMapper;

    public UserDTO userToUserDto(User entity){
        return modelMapper.map(entity,UserDTO.class);
    }

    public User userDtoToUserEntity(UserDTO userDTO){return modelMapper.map(userDTO,User.class);}
}
