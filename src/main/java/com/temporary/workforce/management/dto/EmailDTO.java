package com.temporary.workforce.management.dto;

import lombok.Data;

@Data
public class EmailDTO {

    private int id;

    private String emailAddress;

    private ProjectDTO project;
}
