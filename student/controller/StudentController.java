package com.example.student.controller;

import com.example.student.Api.ApiResponse;
import com.example.student.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    ArrayList<Student> students = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @PostMapping("/add")
    public ApiResponse addStudents(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Students added successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateStudents(@PathVariable int index, @RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse("Students updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudents(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("Student deleted successfully");
    }

    @GetMapping("/classification")

    public ArrayList<String> classifyStudents() {

        ArrayList<String> classifications = new ArrayList<>();

        for (Student student : students) {
            String category;

            if (student.getGpa() >= 3.7) {
                category = "High Honors";
            } else if (student.getGpa() >= 3.5) {
                category = "Honors";
            } else if (student.getGpa() >= 3.0) {
                category = "Merit";
            } else {
                category = "Regular";
            }

            classifications.add(student.getName() + category);

        }

        return classifications;

    }


    @GetMapping("/above-average")

    public ArrayList<Student> getAboveAverageStudents() {
        double totalGpa = 0;

        for (Student student : students) {
            totalGpa += student.getGpa();
        }
        double averageGpa = totalGpa / students.size();

        ArrayList<Student> aboveAverageStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getGpa() > averageGpa) {
                aboveAverageStudents.add(student);
            }
        }
        return aboveAverageStudents;
    }
}