package com.nxpert.feignservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nxpert.entity.Course;


@FeignClient(name="course-service")
public interface FeignCourseServiceProxy {

	@RequestMapping(method = RequestMethod.GET, value = "/course")
	public List<Course> retrieveCourseList();
	
	@RequestMapping(method = RequestMethod.POST, value = "/course")
	public Course saveCourse(@RequestBody Course course);
}