package com.practice.service;

import com.practice.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> listAllProjects();
    ProjectDTO findByProjectCode(String projectCode);
    void update(ProjectDTO dto);
    void delete(String projectCode);
    void save(ProjectDTO projectDTO);
    void complete(String projectCode);
}
