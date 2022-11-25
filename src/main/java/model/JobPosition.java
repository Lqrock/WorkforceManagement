package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Data
@Table(name = "job_position")
public class JobPosition {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "job_position")
    private JobPositionEnum jobPosition;

    @JoinColumn(name = "project_id")
    private int projectId;
}

enum JobPositionEnum{
    WORKER,
    CLEANER
}
