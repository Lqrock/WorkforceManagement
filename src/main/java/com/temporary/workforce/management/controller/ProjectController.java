package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.AccommodationDTO;
import com.temporary.workforce.management.dto.ProjectDTO;
import com.temporary.workforce.management.dto.VehicleDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDto) {
        projectService.createProject(projectDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ProjectDTO> updateProject(@RequestBody ProjectDTO projectDTO) throws BusinessException {
        projectService.updateProject(projectDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{projectId}")
//    public ResponseEntity deleteProject(@PathVariable int projectId) throws BusinessException {
//        projectService.deleteProject(projectId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @GetMapping("/get/{projectId}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable int projectId) throws BusinessException {
        return new ResponseEntity<>(projectService.getProjectDTO(projectId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public String showAllProjects(Model model) {
        List<ProjectDTO> projectDTOList = projectService.getAllProjects();
        model.addAttribute("projects", projectDTOList);
        return "show-all-projects";
    }

    @GetMapping("/delete/{projectId}")
    public String deleteProject(@PathVariable int projectId) throws BusinessException {
        projectService.deleteProject(projectId);
        return "redirect:/project/get-all";
    }

    @GetMapping("/register")
    public String showProjectForm(Model model) {
        ProjectDTO projectDTO = new ProjectDTO();
        model.addAttribute("project", projectDTO);
        return "create-project";
    }

    @PostMapping("/register")
    public String registerProject(Model model, @ModelAttribute("project") ProjectDTO projectDTO) {
        projectService.createProject(projectDTO);
        return "redirect:/project/get-all";
    }

}
