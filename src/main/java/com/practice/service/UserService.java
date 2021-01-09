package com.practice.service;
import com.practice.dto.UserDTO;

import java.util.List;


public interface UserService {

    List<UserDTO> listAllUsers();
    UserDTO findByUserName(String username);
    void save(UserDTO dto);
    void update(UserDTO dto);
    void delete(String username);
    List<UserDTO> findAllManagers();
    List<UserDTO> listAllByRole(String role);
}
