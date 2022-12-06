package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "email")
public class Email {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @JoinColumn(name = "project_id")
    private int projectId;
}
