package com.practice.implementation;

import com.practice.dto.UserDTO;
import com.practice.entity.User;
import com.practice.mapper.UserMapper;
import com.practice.repository.UserRepository;
import com.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {

        List<User> list = userRepository.findAll(Sort.by("firstName"));
        return list.stream().map(obj -> {return userMapper.userToUserDto(obj);}).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {

        User user = userRepository.findUserByUsername(username);

        return userMapper.userToUserDto(user);
    }

    @Override
    public void save(UserDTO dto) {
        User userToSave = userMapper.userDtoToUserEntity(dto);
        userRepository.save(userToSave);

    }

    @Override
    public void update(UserDTO dto) {

        User user = userRepository.findUserByUsername(dto.getUsername());
        User convertedUser = userMapper.userDtoToUserEntity(dto);
        convertedUser.setId(user.getId());
        userRepository.save(convertedUser);

    }

    @Override
    public void delete(String username) {

        User user =userRepository.findUserByUsername(username);
        user.setIsDeleted(true);
        userRepository.save(user);

    }

    @Override
    public List<UserDTO> findAllManagers() {

        List<User> managersList = userRepository.findAllManagers();
        return managersList.stream().map(obj->{return userMapper.userToUserDto(obj);}).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> listAllByRole(String role) {
        List<User> users = userRepository.findAllByRoleDescriptionIgnoreCase(role);
        return users.stream().map(obj -> {return userMapper.userToUserDto(obj);}).collect(Collectors.toList());
    }
}
