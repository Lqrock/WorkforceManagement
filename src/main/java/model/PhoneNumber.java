package model;

import javax.persistence.JoinColumn;

public class PhoneNumber {
    private String phoneNumber;

    @JoinColumn(name = "project_id")
    private int projectId;
}
