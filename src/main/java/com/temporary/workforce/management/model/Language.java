package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "language")
    private LanguageEnum language;

    @JoinColumn(name = "employee_id")
    private int employeeIdd;
}
