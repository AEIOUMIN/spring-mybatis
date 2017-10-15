package com.boxy.showcase.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boxy.showcase.domain.Student;
import com.boxy.showcase.service.StudentService;

@Controller
@RequestMapping("/json")
public class JsonController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/requestKeyValue")
	@ResponseBody
	public Student requestKeyValue(Integer id){
		Student result = studentService.find(id);
		
		return result;
	}
	
	@RequestMapping("/requestJson")
	@ResponseBody
	public Student requestJson(@RequestBody Student student){
		Student result = studentService.find(student.getId());
		
		return result;
	}
}
