package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;

@Data
@Entity
@Table(name = "time_sheet")
public class TimeSheet {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "starting_time")
    private Time startingTime;

    @Column(name = "finishing_time")
    private Time finishingTime;

    @Column(name = "pause_time")
    private int pauseTime;

    @Column(name = "project_name")
    private String projectsName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;
}
