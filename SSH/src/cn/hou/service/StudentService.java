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
	//��ѯ����
	public List<Student> selectAll() {
		List list=studentDao.selectAll();
		return list;
	}
	//��ѯ����
	public Student selectsingle(Integer id){
		Student student=studentDao.selectsingle(id);
		return student;
	}
	//���
	public void insert(Student student) {
		studentDao.insert(student);
	}
	//�޸�
	public void update(Student student){
		studentDao.update(student);
	}
	//ɾ��
	public void deleteById(Student student){
			studentDao.deleteById(student);
	}
	//����ɾ��
	
	public void deleteAll(Integer [] ids){
		studentDao.deleteAll(ids);
	}
	//�����ֲ�ѯ
	public List<Student> selectName(String name){
		List<Student> list=studentDao.selectName(name);
		return list;
	}
}
