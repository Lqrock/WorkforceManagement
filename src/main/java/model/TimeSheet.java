package model;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Time;
import java.time.LocalTime;

@Table(name = "time_sheet")
public class TimeSheet {

    @Column(name = "type")
    private String type; // could also be enum of (active, day off, not working)

    @Column(name = "starting_time")
    private Time startingTime;

    @Column(name = "finishing_time")
    private Time finishingTime;

    @Column(name = "pause_time")
    private int pauseTime;

    @Column(name = "project_name")
    private String projectsName;

    @Column(name = "job_position")
    private String jobPosition;
}
