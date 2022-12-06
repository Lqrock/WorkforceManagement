package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
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


