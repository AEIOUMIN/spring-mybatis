package com.boxy.showcase.service.impl;

import org.springframework.stereotype.Service;

import com.boxy.showcase.domain.Student;
import com.boxy.showcase.service.StudentService;

@Service
public class StudentServiceImpl extends GenericServiceImpl<Student, Integer> implements StudentService{

}
