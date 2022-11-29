package dto;

import lombok.Data;
import model.JobPosition;
import java.sql.Time;

@Data
public class TimeSheetDTO {

    private int id;

    private String jobType;

    private Time startingTime;

    private Time finishingTime;

    private int pauseTime;

    private String projectsName;

    private JobPositionDTO jobPositionDTO;
}