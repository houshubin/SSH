package cn.hou.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hou.entity.Student;
import cn.hou.service.StudentService;

@Controller
public class StudentController {
	@Resource
	StudentService studentService;
	
	//测试
	@RequestMapping("/student/test.action")
	public String student1(){
		return "student/Test";
	}
	//显示所有信息
	@RequestMapping("/student/studentlist.action")
	public String studentlist(Model model) throws Exception{
		List<Student> list=studentService.selectAll();
		model.addAttribute("student", list);
		return "student/JStudentList";
	}
	
	//新增信息
	@RequestMapping("/student/toinsert.action")
	public String toinsert(){
		
		return "student/insert";
	}
	@RequestMapping("/student/insert.action")
	public String insert(Student student){
		studentService.insert(student);
		return "redirect:/student/studentlist.action";
	}
	//修改
	@RequestMapping("/student/toupdate.action")
	public String toupdate(Integer id,Model model){
		Student student=studentService.selectsingle(id);
		model.addAttribute("student", student);
		return "student/update";
	}
	@RequestMapping("/student/update.action")
	public String update(Student student){
		
		studentService.update(student);
		
		return "redirect:/student/studentlist.action";
	}
	//删除单条
	@RequestMapping("/student/todelete.action")
	public String deleteById(Integer id){
		Student student=studentService.selectsingle(id);
		studentService.deleteById(student);
		return "redirect:/student/studentlist.action";
	}
	//批量删除
	@RequestMapping("/student/deleteAll.action")
	public String delete(Integer [] ids){
		for(Integer id:ids){
			Student student=studentService.selectsingle(id);
			studentService.deleteById(student);
			}
		return "redirect:/student/studentlist.action";
	}
	//按姓名查询
	@RequestMapping("/student/selectName.action")
	public String selectName(String name,Model model){
		List<Student> list=studentService.selectName(name);
		model.addAttribute("student",list);
		return "student/JStudentList";
	}
	
}
