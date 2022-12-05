package service;

import exception.BusinessException;
import dto.TimeSheetDTO;
import model.TimeSheet;

import java.util.Optional;

public interface TimeSheetServiceInterface {

    void createTimeSheet(TimeSheetDTO timeSheetDTO);

    TimeSheetDTO updateTimeSheet(TimeSheetDTO timeSheetDTO) throws BusinessException;

    void deleteTimeSheet(int timeSheetId) throws BusinessException;

    TimeSheetDTO getTimeSheetDTO(int timeSheetId) throws BusinessException;

    Optional<TimeSheet> getTimeSheet(int timeSheetId) throws BusinessException;

}
