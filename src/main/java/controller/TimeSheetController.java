package controller;

import dto.TimeSheetDTO;
import exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.TimeSheetService;

@Controller
@RequestMapping("/timesheet")
public class TimeSheetController {

    @Autowired
    TimeSheetService timeSheetService;

    @PostMapping("/create")
    public ResponseEntity createTimeSheet(@RequestBody TimeSheetDTO timeSheetDTO){
        timeSheetService.createTimeSheet(timeSheetDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateTimeSheet(@RequestBody TimeSheetDTO timeSheetDTO) throws BusinessException {
        timeSheetService.updateTimeSheet(timeSheetDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteTimeSheet(@RequestParam int timeSheetId) throws BusinessException{
        timeSheetService.deleteTimeSheet(timeSheetId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity getTimeSheet(@RequestParam int timeSheetId) throws BusinessException{
        timeSheetService.getTimeSheet(timeSheetId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getDTO")
    public ResponseEntity getTimeSheetDTO(@RequestParam int timeSheetId) throws BusinessException{
        timeSheetService.getTimeSheetDTO(timeSheetId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/hi")
    public void work(){
        System.out.println("Hi\n\n\nHi\n\n\nHi");
    }
}
