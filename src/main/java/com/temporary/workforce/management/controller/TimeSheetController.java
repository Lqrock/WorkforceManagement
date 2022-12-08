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
    public ResponseEntity createTimeSheet(@RequestBody TimeSheetDTO timeSheetDTO) throws BusinessException {
        timeSheetService.createTimeSheet(timeSheetDTO);
        return new ResponseEntity(timeSheetDTO + "\nCreated", HttpStatus.CREATED);
    }

    @RequestMapping("/update")
    public ResponseEntity updateTimeSheet(@RequestBody TimeSheetDTO timeSheetDTO) throws BusinessException {
        timeSheetService.updateTimeSheet(timeSheetDTO);
        return new ResponseEntity(timeSheetDTO + "\nUpdated", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteTimeSheet(@RequestParam int timeSheetId) throws BusinessException{
        timeSheetService.deleteTimeSheet(timeSheetId);
        return new ResponseEntity("\nDeleted", HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity getTimeSheet(@RequestParam int timeSheetId) throws BusinessException{
        timeSheetService.getTimeSheet(timeSheetId);
        return new ResponseEntity(timeSheetService.getTimeSheet(timeSheetId) + "\nRetrieved", HttpStatus.OK);
    }

    @GetMapping("/getdto")
    public ResponseEntity getTimeSheetDTO(@RequestParam int timeSheetId) throws BusinessException{
        timeSheetService.getTimeSheetDTO(timeSheetId);
        return new ResponseEntity(timeSheetService.getTimeSheetDTO(timeSheetId) + "\nRetrieved", HttpStatus.OK);
    }
}
