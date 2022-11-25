package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Data
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
