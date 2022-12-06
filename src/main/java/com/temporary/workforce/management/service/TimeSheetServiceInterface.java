package com.temporary.workforce.management.service;

import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.dto.TimeSheetDTO;
import com.temporary.workforce.management.model.TimeSheet;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TimeSheetServiceInterface {

    void createTimeSheet(TimeSheetDTO timeSheetDTO);

    TimeSheetDTO updateTimeSheet(TimeSheetDTO timeSheetDTO) throws BusinessException;

    void deleteTimeSheet(int timeSheetId) throws BusinessException;

    TimeSheetDTO getTimeSheetDTO(int timeSheetId) throws BusinessException;

    Optional<TimeSheet> getTimeSheet(int timeSheetId) throws BusinessException;

}
