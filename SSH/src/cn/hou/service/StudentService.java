package cn.hou.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import cn.hou.dao.StudentDao;
import cn.hou.entity.Student;

@Service
public class StudentService {
	@Resource
	StudentDao studentDao;
	//private static Map<Integer,Student> stu=new HashMap<Integer, Student>();
	//查询所有
	public List<Student> selectAll() {
		List list=studentDao.selectAll();
		return list;
	}
	//查询单条
	public Student selectsingle(Integer id){
		Student student=studentDao.selectsingle(id);
		return student;
	}
	//添加
	public void insert(Student student) {
		studentDao.insert(student);
	}
	//修改
	public void update(Student student){
		studentDao.update(student);
	}
	//删除
	public void deleteById(Student student){
			studentDao.deleteById(student);
	}
	//批量删除
	
	public void deleteAll(Integer [] ids){
		studentDao.deleteAll(ids);
	}
	//按名字查询
	public List<Student> selectName(String name){
		List<Student> list=studentDao.selectName(name);
		return list;
	}
}
