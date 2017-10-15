package com.boxy.showcase.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.boxy.showcase.domain.Student;
import com.boxy.showcase.service.PagedList;
import com.boxy.showcase.service.StudentService;
import com.boxy.showcase.web.validation.ValidateGroupAdd;
import com.boxy.showcase.web.validation.ValidateGroupEdit;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@ModelAttribute("provinces")
	public Map<String, String> getProvinces(){
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("101", "北京");
		result.put("102", "上海");
		result.put("103", "广州");
		result.put("104", "深圳");
		
		return result;
	}
	
	// /student/index/1
	// /student/index?pageIndex=1
	// RESTful风格URL
	@RequestMapping("/index/{id}")
	public ModelAndView index(@PathVariable("id") Integer id) throws Exception {
		// id 表示第几页
		id = id == null ? 1 : id;
		int pageSize = 10;
		PagedList<Student> pagedList = studentService.findPage(id, pageSize);

		ModelAndView mav = new ModelAndView();

		mav.addObject("model", pagedList);
		// /WEB-INF/views/student/index.jsp
		mav.setViewName("student/index");

		return mav;
	}

	// 新增
	// /student/create
	// controller->model->view
	// 
	@RequestMapping("/create")
	public String create(Model model) throws Exception {
		model.addAttribute("student", new Student());
		return "student/create";
	}

	//
	// 新增保存
	//
	@RequestMapping("/save")
	public String save(
			@Validated(value = ValidateGroupAdd.class) 
			@ModelAttribute("student")Student student,
			BindingResult result,
			HttpServletRequest request,
			MultipartFile photo
			) throws Exception {
		// 数据验证
		if (result.hasErrors()) {
			return "student/create";
		}
		
		// 上传头像
		if(photo != null){
			String originalFileName = photo.getOriginalFilename();
			String path = request.getServletContext().getRealPath("/resources/upload/");
			
			String fileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf("."));
			
			File file = new File(path+fileName);
			
			photo.transferTo(file);
			
			student.setPhotoUrl(fileName);
		}
		
		studentService.add(student);

		return "redirect:/student/index/1";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model)  throws Exception {
		Student student = studentService.find(id);
		
		/*if(student == null){
			throw new Exception("没有对应的数据");
		}*/
		
		model.addAttribute("model", student);
		return "student/edit";
	}

	@RequestMapping("/update")
	public String udpate (
			@Validated(value = ValidateGroupEdit.class) 
			@ModelAttribute("student") 
			Student student,
			BindingResult result) throws Exception {
		// 数据验证
		if (result.hasErrors()) {
			return "student/edit/"+student.getId();
		}
		studentService.update(student);
		return "redirect:/student/index/1";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) throws Exception {
		studentService.delete(id);
		return "redirect:/student/index/1";
	}

	@RequestMapping("/batDelete")
	public String delete(String[] ids) {
		studentService.delete(ids);

		return "redirect:/student/index/1";
	}

	@RequestMapping("/details/{id}")
	public void details(@PathVariable("id") Integer id,
			HttpServletRequest request, HttpServletResponse response)  throws Exception {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset='utf-8'");
		try {
			// {"id":23, "studentName":"bxy"}
			response.getWriter().write(
					"{\"id\":" + id + ",\"studentName\":" + "\"bxy\"" + "}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
