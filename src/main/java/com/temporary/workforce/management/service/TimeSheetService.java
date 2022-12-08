package com.temporary.workforce.management.service;

import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.repository.TimeSheetRepository;
import com.temporary.workforce.management.dto.TimeSheetDTO;
import com.temporary.workforce.management.model.JobPosition;
import com.temporary.workforce.management.model.TimeSheet;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeSheetService implements TimeSheetServiceInterface{

    @Autowired
    TimeSheetRepository timeSheetRepository;

    Logger logger = LoggerFactory.getLogger(TimeSheetService.class);

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public void createTimeSheet(TimeSheetDTO timeSheetDTO) {
        logger.info("Creating time sheet");
        TimeSheet timeSheet = modelMapper.map(timeSheetDTO, TimeSheet.class);
        timeSheetRepository.save(timeSheet);
        logger.info("Time sheet created");
    }

    @Override
    public TimeSheetDTO updateTimeSheet(TimeSheetDTO timeSheetDTO) throws BusinessException {
        logger.info("Updating time sheet");
        Optional<TimeSheet> existingTimeSheetOpt = timeSheetRepository.findById(timeSheetDTO.getId());
        throwExceptionIfTimeSheetNotFound(existingTimeSheetOpt, timeSheetDTO.getId());
        TimeSheet existingTimeSheet = existingTimeSheetOpt.get();
        existingTimeSheet = modelMapper.map(timeSheetDTO, TimeSheet.class);
        timeSheetRepository.save(existingTimeSheet);
        logger.info("TimeSheet updated");
        return modelMapper.map(existingTimeSheet, TimeSheetDTO.class);

//        existingTimeSheet.setJobType(timeSheetDTO.getJobType());
//        existingTimeSheet.setStartingTime(timeSheetDTO.getStartingTime());
//        existingTimeSheet.setFinishingTime(timeSheetDTO.getFinishingTime());
//        existingTimeSheet.setPauseTime(timeSheetDTO.getPauseTime());
//        existingTimeSheet.setProjectsName(timeSheetDTO.getProjectsName());
//        if(timeSheetDTO.getJobPositionDTO() != null){
//        existingTimeSheet.setJobPosition(modelMapper.map(timeSheetDTO.getJobPositionDTO(), JobPosition.class));
//        }

    }

    @Override
    public void deleteTimeSheet(int timeSheetId) throws BusinessException {
        logger.info("Deleting time sheet");
        Optional<TimeSheet> timeSheet = timeSheetRepository.findById(timeSheetId);
        throwExceptionIfTimeSheetNotFound(timeSheet, timeSheetId);
        timeSheetRepository.deleteById(timeSheetId);
        logger.info("Deleted time sheet");
    }

    @Override
    public TimeSheetDTO getTimeSheetDTO(int timeSheetId) throws BusinessException {
        logger.info("Retrieving timeSheetDTO");
        Optional<TimeSheet> timeSheet = timeSheetRepository.findById(timeSheetId);
        throwExceptionIfTimeSheetNotFound(timeSheet, timeSheetId);
        return modelMapper.map(timeSheet, TimeSheetDTO.class);
    }

    @Override
    public Optional<TimeSheet> getTimeSheet(int timeSheetId) throws BusinessException {
        logger.info("Retrieving time sheet");
        Optional<TimeSheet> timeSheet = timeSheetRepository.findById(timeSheetId);
        throwExceptionIfTimeSheetNotFound(timeSheet, timeSheetId);
        return timeSheet;
    }

    void throwExceptionIfTimeSheetNotFound(Optional<TimeSheet> timeSheet, int timeSheetId) throws BusinessException {
        if(timeSheet.isEmpty()){
            throw new BusinessException("Time sheet with id " + timeSheetId + " not found");
        }
    }


}
