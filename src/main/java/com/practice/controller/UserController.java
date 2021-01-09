package com.practice.controller;

import com.practice.dto.UserDTO;
import com.practice.service.RoleService;
import com.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {


    RoleService roleService;
    UserService userService;

    @Autowired
    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    @GetMapping("/create")
    public String createUser(Model model) {

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.listAllRoles());
        model.addAttribute("users",userService.listAllUsers());

        return "user/userCreate";


    }

    @PostMapping("/create")
    public String insertUser(UserDTO user, Model model){

        userService.save(user);

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.listAllRoles());
        model.addAttribute("users",userService.listAllUsers());

        return "user/userCreate";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username")String username, Model model){
        model.addAttribute("user",userService.findByUserName(username));
        model.addAttribute("roles",roleService.listAllRoles());
        model.addAttribute("users",userService.listAllUsers());
        return "/user/userUpdate";
    }


    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username")String username,UserDTO user, Model model){


        userService.update(user);

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.listAllRoles());
        model.addAttribute("users",userService.listAllUsers());


        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username")String username,Model model){

        userService.delete(username);

        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.listAllRoles());
        model.addAttribute("users",userService.listAllUsers());


        return "/user/userCreate";
    }


}
