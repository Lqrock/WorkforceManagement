package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.TimeSheetDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.TimeSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.temporary.workforce.management.service.TimeSheetService;

import java.util.Optional;

@Controller
@RequestMapping("/timesheet")
public class TimeSheetController {

    @Autowired
    TimeSheetService timeSheetService;

    @RequestMapping("/create")
    public ResponseEntity<TimeSheetDTO> createTimeSheet(@RequestBody TimeSheetDTO timeSheetDTO) {
        timeSheetService.createTimeSheet(timeSheetDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping("/update")
    public ResponseEntity<TimeSheetDTO> updateTimeSheet(@RequestBody TimeSheetDTO timeSheetDTO) throws BusinessException {
        return new ResponseEntity<>(timeSheetService.updateTimeSheet(timeSheetDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{timeSheetId}")
    public ResponseEntity<TimeSheetDTO> deleteTimeSheet(@PathVariable int timeSheetId) throws BusinessException{
        timeSheetService.deleteTimeSheet(timeSheetId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{timeSheetId}")
    public ResponseEntity<TimeSheetDTO> getTimeSheet(@PathVariable int timeSheetId) throws BusinessException{
        return new ResponseEntity<>(timeSheetService.getTimeSheetDTO(timeSheetId), HttpStatus.OK);
    }
}