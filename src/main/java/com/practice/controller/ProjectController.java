package com.practice.controller;

import com.practice.dto.ProjectDTO;
import com.practice.enums.Status;
import com.practice.service.ProjectService;
import com.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    ProjectService projectService;
    UserService userService;

    @Autowired
    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }




    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("projects",projectService.listAllProjects());
        model.addAttribute("managers",userService.findAllManagers());

        return "/project/projectCreate";
    }


    @PostMapping("/create")
    public String insertProject(ProjectDTO project,Model model){

        project.setProjectStatus(Status.OPEN);
        projectService.save(project);


        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("projects",projectService.listAllProjects());
        model.addAttribute("managers",userService.findAllManagers());

        return "/project/projectCreate";

    }


    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode,Model model){
        projectService.delete(projectCode);

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("projects",projectService.listAllProjects());
        model.addAttribute("managers",userService.findAllManagers());
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode){

        projectService.complete(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String updateProject(@PathVariable("projectCode") String projectCode, Model model){

        model.addAttribute("project",projectService.findByProjectCode(projectCode));
        model.addAttribute("projects",projectService.listAllProjects());
        model.addAttribute("managers",userService.findAllManagers());

        return "/project/projectUpdate";
    }


    @PostMapping("/update")
    public String postProject(ProjectDTO project,Model model){

        projectService.update(project);

        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("projects",projectService.listAllProjects());
        model.addAttribute("managers",userService.findAllManagers());
        return "redirect:/project/create";
    }

    //
//    @GetMapping("/manager/complete")
//    public String getProjectByManager(Model model){
//
//        UserDTO manager = userService.findById("john@cybertek.com");
//
//        List<ProjectDTO> projects = getCountedListOfProjectDTO(manager);
//
//        model.addAttribute("projects",projects);
//
//
//        return "/manager/project-status";
//    }

    //    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager){
//
//        List<ProjectDTO> list = projectService
//                .findAll()
//                .stream()
//                .filter(x -> x.getAssignedManager().equals(manager))
//                .map(x -> {
//
//                    List<TaskDTO> taskList = taskService.findTaskByManager(manager);
//                    int completeCount = (int) taskList.stream().filter(t -> t.getProject().equals(x) && t.getTaskStatus() == Status.COMPLETE).count();
//                    int inCompleteCount = (int) taskList.stream().filter(t -> t.getProject().equals(x) && t.getTaskStatus() != Status.COMPLETE).count();
//
//                    x.setCompleteTaskCounts(completeCount);
//                    x.setUnfinishedTaskCounts(inCompleteCount);
//
//                    return x;
//
//                }).collect(Collectors.toList());
//
//        return list;
}
