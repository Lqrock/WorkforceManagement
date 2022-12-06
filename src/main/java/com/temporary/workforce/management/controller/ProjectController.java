package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.ProjectDTO;
import com.temporary.workforce.management.service.ProjectService;
import com.temporary.workforce.management.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity createProject(@RequestBody ProjectDTO projectDto){
        projectService.createProject(projectDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateProject(@RequestBody ProjectDTO projectDTO) throws BusinessException {
        projectService.updateProject(projectDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteProject(@RequestParam int projectId) throws BusinessException{
        projectService.deleteProject(projectId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity getProject(@RequestParam int projectId) throws BusinessException{
        projectService.getProject(projectId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getDTO")
    public ResponseEntity getProjectDTO(@RequestParam int projectId) throws BusinessException {
        projectService.getProjectDTO(projectId);
        return new ResponseEntity(HttpStatus.OK);
    }


}
