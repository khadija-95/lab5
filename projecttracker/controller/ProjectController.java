package com.example.projecttracker.controller;

import com.example.projecttracker.Api.ApiResponse;
import com.example.projecttracker.model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Project> getProjects(){
        return projects;
    }

    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project){
        projects.add(project);
        return new ApiResponse("project added successfully");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@PathVariable int index,@RequestBody Project project){
        projects.set(index,project);
        return new ApiResponse("project updated successfully");
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index){
        projects.remove(index);
        return new ApiResponse("project deleted successfully");
    }
    @GetMapping("/search")
    public ArrayList<Project> searchTask(@RequestBody String title){
        ArrayList<Project> result = new ArrayList<>();
        for(Project project: projects){
            if(project.getTitle().equals(title)){
                result.add(project);
            }
        }

        return result;
    }
    @GetMapping("/company/{companyName}")

    public ArrayList<Project> getProjectsByCompany(@PathVariable String companyName){
        ArrayList<Project> result=new ArrayList<>();
        for(Project project : projects){
            if(project.getCompanyName().equals(companyName)){
                result.add(project);
            }
        }
        return result;

    }
}
