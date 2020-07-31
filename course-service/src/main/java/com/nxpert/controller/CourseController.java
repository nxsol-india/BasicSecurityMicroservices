/**
 * 
 */
package com.nxpert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nxpert.entity.Course;
import com.nxpert.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping("/course")
	public List<Course> all() {
		List<Course> userInfos = courseRepository.findAll();
		return userInfos;
	}
	
	@PostMapping("/course")
	public Course save(@RequestBody Course course) {
		return courseRepository.save(course);
	}
}
