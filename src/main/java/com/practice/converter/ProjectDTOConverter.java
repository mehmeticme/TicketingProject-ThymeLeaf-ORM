package com.practice.converter;

import com.practice.dto.ProjectDTO;
import com.practice.dto.RoleDTO;
import com.practice.service.ProjectService;
import com.practice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProjectDTOConverter  implements Converter<String,ProjectDTO> {


    ProjectService projectService;


    @Autowired
    public ProjectDTOConverter(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String source) {
        return projectService.findByProjectCode(source);
    }
}
