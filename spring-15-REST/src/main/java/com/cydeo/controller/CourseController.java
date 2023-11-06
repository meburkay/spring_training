package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Sum of Controller and ResponseBody. By this we are saying that this Controller is created for RestAPI no view.
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    //@ResponseBody
    public List<CourseDTO> getAllCourses(){

        //return all courses
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category) {

        return courseService.getCoursesByCategory(category);

    }

    //We use here @RequestBody annotation. It uses for capturing the data and put it into the object. When posting to create a course the user send data at jason format and its name is body. Here we say take that body jason data and put it into CourseDTO by mapping. Spring did it with jackson library at the background automatically.
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    //Here we give one id number as a @PathVariable to find which course will be update and as a second argument we give a jason body the consist the data that will be updated.
    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") long courseId,@RequestBody CourseDTO course){
        courseService.updateCourse(courseId,course);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") long courseId){
        courseService.deleteCourseById(courseId);

    }


}
