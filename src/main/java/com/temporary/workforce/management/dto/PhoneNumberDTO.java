package com.temporary.workforce.management.dto;

import lombok.Data;

@Data
public class PhoneNumberDTO {

    private int id;

    private String phoneNumber;

    private ProjectDTO project;
}
