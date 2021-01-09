package com.practice.mapper;

import com.practice.dto.ProjectDTO;
import com.practice.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    ModelMapper modelMapper;

    @Autowired
    public ProjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public ProjectDTO projectEntityToDto(Project project){
        return  modelMapper.map(project,ProjectDTO.class);
    }

    public Project projectDtoToEntity(ProjectDTO dto){
        return modelMapper.map(dto,Project.class);
    }

}
