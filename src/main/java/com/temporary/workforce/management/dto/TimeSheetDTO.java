package com.temporary.workforce.management.dto;

import lombok.Data;

import java.sql.Time;

@Data
public class TimeSheetDTO {

    private int id;

    private String jobType;

    private Time startingTime;

    private Time finishingTime;

    private int pauseTime;

    private String projectsName;

    private JobPositionDTO jobPosition;
}
