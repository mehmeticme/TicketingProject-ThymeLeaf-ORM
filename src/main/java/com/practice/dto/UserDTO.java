package com.practice.dto;

import com.practice.entity.Role;
import com.practice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean enabled;
    private String phone;
    private RoleDTO role;
    private Gender gender;
}
