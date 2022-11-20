package model;

import javax.persistence.JoinColumn;

public class Email {
    private String email;

    @JoinColumn(name = "project_id")
    private int projectId;
}
