package com.temporary.workforce.management.dto;

import lombok.Data;

import java.util.List;

@Data
public class JobPositionDTO {

    private int id;

    private String title;

    private List<ProjectDTO> projects;
}
