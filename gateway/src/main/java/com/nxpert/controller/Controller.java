package com.nxpert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nxpert.entity.Course;
import com.nxpert.entity.Partner;
import com.nxpert.feignservice.FeignCourseServiceProxy;
import com.nxpert.feignservice.FeignPartnerServiceProxy;
import com.nxpert.repository.UserRepository;

@RestController
public class Controller {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FeignPartnerServiceProxy feignPartnerServiceProxy;
	
	@Autowired
	FeignCourseServiceProxy feignCourseServiceProxy;
	
//	public static final String PARTNER_SERVICE_URL = "http://PARTNER-SERVICE";
//	public static final String COURSE_SERVICE_URL = "http://COURSE-SERVICE";
	
	@GetMapping("/partner")
	public List<Partner> allPartnerList() throws Exception {
		return feignPartnerServiceProxy.retrievePartnerList();
	}
	
	@PostMapping("/partner")
	public Partner savePartner(@RequestBody Partner partner) throws Exception {
		return feignPartnerServiceProxy.savePartner(partner);
	}
	
	@GetMapping("/course")
	public List<Course> allCourseList() throws Exception {
		return feignCourseServiceProxy.retrieveCourseList();
	}
	
	@PostMapping("/course")
	public Course saveCourse(@RequestBody Course course) throws Exception {
		return feignCourseServiceProxy.saveCourse(course);
	}
	
	/*@GetMapping("/user/all")
	public List<User> all() {
		List<User> userInfos = userRepository.findAll();
		return userInfos;
	}
	
	@GetMapping("/user/{id}")
	public User byId(@PathVariable("id") Long id) {
		Optional<User>  user = userRepository.findById(id);
		return user.get();
	}*/
	
	
	
	
	/*@GetMapping("/partners")
	public Partner[]  allPartner() throws Exception {
		System.err.println(PARTNER_SERVICE_URL + "/partner");
		Partner[]  allPartner = restTemplate.getForObject(PARTNER_SERVICE_URL + "/partner",Partner[].class);	
		return allPartner;
	}*/
	
	/*@GetMapping("/courses")
	public Course[] allCourse() throws Exception {
		System.err.println(COURSE_SERVICE_URL + "/course");
		Course[]  allCourse = restTemplate.getForObject(COURSE_SERVICE_URL + "/course",Course[].class);
		
		return allCourse;
	}*/
}
