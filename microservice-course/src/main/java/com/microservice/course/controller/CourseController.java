package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.persistence.ICourseRepository;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)//retornamos un codigo 201 (que seria creado)
    @PostMapping("/save")
    public void saveCourse(@RequestBody Course course) {

        courseService.save(course);

    }


    @GetMapping("/all")
    public ResponseEntity<?> findAllCourse() {

        return ResponseEntity.ok(courseService.findAll());

    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));

    }


    @GetMapping("/search-students/{idCourse}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse) {


        return ResponseEntity.ok(courseService.findStudentsByIdCourse(idCourse));

    }


}
