package com.boxy.showcase.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boxy.showcase.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void add(){
		Student s = new Student(null, "99", "bxy",
				"男", new Date(), "黄河路", "郑州", "河南", "");
		
		studentService.add(s);
		studentService.delete(1);
	}
	
	@Test
	public void find(){
		int i = 1;
		Student s = studentService.find(i);
		
		System.out.println(s);
	}
	
	@Test
	public void findByName(){
		Student s = studentService.findByName("张三01");
		
		System.out.println(s);
	}
	
	@Test
	public void findPage(){
		PagedList<Student> pagedList = studentService.findPage(1, 10);
		
		pagedList.getPages().forEach(u->System.out.println(u));
	}
	
	@Test
	public void findAll(){
		List<Student> s = studentService.findAll();
		
		s.forEach(u->System.out.println(u));
	}
}
