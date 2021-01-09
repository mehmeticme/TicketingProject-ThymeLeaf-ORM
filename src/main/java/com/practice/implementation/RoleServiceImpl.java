package com.practice.implementation;

import com.practice.dto.RoleDTO;
import com.practice.entity.Role;
import com.practice.mapper.RoleMapper;
import com.practice.repository.RoleRepository;
import com.practice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {


    RoleRepository roleRepository;
    RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> listAllRoles() {

        List<Role> list = roleRepository.findAll();
        return list.stream().map(obj -> {return roleMapper.convertToDto(obj);}).collect(Collectors.toList());

    }

    @Override
    public RoleDTO findById(Long id) {
        Role role = roleRepository.findById(id).get();
        return roleMapper.convertToDto(role);

    }


}
