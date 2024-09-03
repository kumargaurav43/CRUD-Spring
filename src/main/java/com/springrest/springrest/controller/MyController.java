package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;


@RestController
public class MyController {
	
	@Autowired
	private CourseService courseSerivice;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to our first spring boot course application";
	}
	
//	get the all courses
	
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseSerivice.getCourses();
	}
	
//	get or access the single course using this id
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseSerivice.getCourse(Long.parseLong(courseId));
	}
	
//	adding a new course
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseSerivice.addCourse(course);
	}
	
//	update the data
	
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@RequestBody Course course) {
//	    course.setId(Long.parseLong(courseId));
	    return this.courseSerivice.updateCourse(course);
	}
	
//	delete the data
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseSerivice.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
