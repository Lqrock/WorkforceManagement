package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;

@Data
@Table(name = "time_sheet")
public class TimeSheet {

    @Id
    @NotEmpty
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

    @Column(name = "job_position")
    private JobPosition jobPosition;
}
