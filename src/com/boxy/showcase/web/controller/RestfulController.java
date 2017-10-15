package com.boxy.showcase.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boxy.showcase.domain.JsonResult;
import com.boxy.showcase.domain.Student;
import com.boxy.showcase.service.StudentService;

@RestController
@RequestMapping("/rest")
public class RestfulController {
	@Autowired
	private StudentService studentService;
	
	// 查找    /rest/12
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Student details(@PathVariable("id")Integer id){
		System.out.println(id);
		
		Student result = studentService.find(id);
		
		return result;
	}
	
	// 删除  /rest/12
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public JsonResult delete(@PathVariable("id")Integer id){
		JsonResult result = new JsonResult(true, "删除成功！");
		try {
			studentService.delete(id);
		} catch(Exception ex){
			result = new JsonResult(false, "删除失败！");
		}
		return result;
	}
}
