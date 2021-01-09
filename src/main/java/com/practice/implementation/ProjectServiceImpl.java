package com.practice.implementation;

import com.practice.dto.ProjectDTO;
import com.practice.entity.Project;
import com.practice.entity.User;
import com.practice.enums.Status;
import com.practice.mapper.ProjectMapper;
import com.practice.mapper.UserMapper;
import com.practice.repository.ProjectRepository;
import com.practice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {



    ProjectRepository projectRepository;
    ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project> projects = projectRepository.findAll(Sort.by("projectCode"));
        return projects.stream().map(obj -> {return projectMapper.projectEntityToDto(obj);}).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO findByProjectCode(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);

        return projectMapper.projectEntityToDto(project);
    }

    @Override
    public void update(ProjectDTO dto) {

        Project project = projectRepository.findByProjectCode(dto.getProjectCode());
        Project convertedUser = projectMapper.projectDtoToEntity(dto);
        convertedUser.setId(project.getId());
        convertedUser.setProjectStatus(project.getProjectStatus());

        projectRepository.save(convertedUser);



    }

    @Override
    public void delete(String projectCode) {

        Project project = projectRepository.findByProjectCode(projectCode);
        project.setIsDeleted(true);
        projectRepository.save(project);

    }

    @Override
    public void save(ProjectDTO projectDTO) {
        projectDTO.setProjectStatus(Status.OPEN);
        Project project = projectMapper.projectDtoToEntity(projectDTO);
        projectRepository.save(project);
    }

    @Override
    public void complete(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);
    }
}
