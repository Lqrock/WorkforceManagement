package service;

import dto.ProjectDTO;
import exception.BusinessException;
import model.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

public class ProjectService implements ProjectServiceInterface{

    @Autowired
    ProjectRepository projectRepository;

    Logger logger = LoggerFactory.getLogger(ProjectService.class);

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public void createProject(ProjectDTO projectDTO) {
        logger.info("Creating project " + projectDTO.getId());
        Project project = modelMapper.map(projectDTO, Project.class);
        projectRepository.save(project);
        logger.info("Project created successfully");
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) throws BusinessException {
        logger.info("Updating project");
        Optional<Project> existingProjectOpt = projectRepository.findById(projectDTO.getId());
        throwExceptionIfProjectNotFound(existingProjectOpt, projectDTO.getId());
        Project existingProject = existingProjectOpt.get();

        existingProject.setName(projectDTO.getName());
        existingProject.setCode(projectDTO.getCode());
        existingProject.setAddress(projectDTO.getAddress());
        existingProject.setStartingDate(projectDTO.getStartingDate());
        existingProject.setFinishingDate(projectDTO.getFinishingDate());
        existingProject.setMaximumEmployeesNumber(projectDTO.getMaximumEmployeesNumber());
        existingProject.setEmployee(modelMapper.map(projectDTO.getEmployeeDTO(), Employee.class));

        List<PhoneNumbers> phoneNumbers = projectDTO.getPhoneNumber().stream().map(a -> modelMapper.map(a, PhoneNumbers.class)).toList();
        phoneNumbers.forEach(phoneNumber -> phoneNumber.setProjectId(existingProject.getId()));
        existingProject.setPhoneNumber(phoneNumbers);

        List<Email> emails = projectDTO.getEmails().stream().map(a -> modelMapper.map(a, Email.class)).toList();
        emails.forEach(email -> email.setProjectId(existingProject.getId()));
        existingProject.setEmails(emails);

        List<JobPosition> jobPositions = projectDTO.getJobPositions().stream().map(a -> modelMapper.map(a, JobPosition.class)).toList();
        jobPositions.forEach(jobPosition -> jobPosition.setProjectId(existingProject.getId()));
        existingProject.setJobPositions(jobPositions);

        projectRepository.save(existingProject);
        logger.info("Project updated");
        return modelMapper.map(existingProject, ProjectDTO.class);
    }

    @Override
    public void deleteProject(int projectId) throws BusinessException {
        logger.info("Deleting project");
        Optional<Project> project = projectRepository.findById(projectId);
        throwExceptionIfProjectNotFound(project, projectId);
        projectRepository.deleteById(projectId);
        logger.info("Project deleted successfully");
    }

    @Override
    public ProjectDTO getProjectDTO(int projectId) throws BusinessException {
        logger.info("Retrieving projectDTO");
        Optional<Project> project = projectRepository.findById(projectId);
        throwExceptionIfProjectNotFound(project, projectId);
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public Optional<Project> getProject(int projectId) throws BusinessException {
        logger.info("Retrieving project");
        Optional<Project> project = projectRepository.findById(projectId);
        throwExceptionIfProjectNotFound(project, projectId);
        return project;
    }

    void throwExceptionIfProjectNotFound(Optional<Project> project, int projectId) throws BusinessException{
        if(project.isEmpty()){
            throw new BusinessException("Project with id " + projectId + " not found");
        }
    }



}
