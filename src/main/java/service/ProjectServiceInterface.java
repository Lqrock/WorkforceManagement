package service;

import dto.ProjectDTO;
import exception.BusinessException;
import model.Project;

import java.util.Optional;

public interface ProjectServiceInterface {

    void createProject(ProjectDTO projectDTO);

    ProjectDTO updateProject(ProjectDTO projectDTO) throws BusinessException;

    void deleteProject(int projectId) throws BusinessException;

    ProjectDTO getProjectDTO(int projectId) throws BusinessException;

    Optional<Project> getProject(int projectId) throws BusinessException;

}
