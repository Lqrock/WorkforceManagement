package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Data
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
