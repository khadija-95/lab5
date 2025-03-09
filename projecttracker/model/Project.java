package com.example.projecttracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    private String ID;
    private String title;
    private String description;
    private String status;
    private String companyName;
}
