package com.temporary.workforce.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumberDTO {

    private int id;

    private String phoneNumber;

    private ProjectDTO project;
}
