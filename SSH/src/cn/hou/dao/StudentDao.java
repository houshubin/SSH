package cn.hou.dao;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.el.Expression;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import cn.hou.entity.Student;

@Repository
public class StudentDao {
	
	Student student;
	public static ApplicationContext ctx=null;
	public static SessionFactory sessionFactory=null;
	public static Session session=null;
	public static Transaction transaction=null;
	public static void methodopen(){
		 ctx= new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		 sessionFactory=ctx.getBean(SessionFactory.class);
		
		 session=sessionFactory.openSession();
		
		 transaction=session.beginTransaction();
	}
	public static void methodclose(){
		transaction.commit();
		session.close();
	}
	 
	//查询所有
	public List selectAll() {
		methodopen();
//		List all=null;
//		String hql="from student";
//		Query q=session.createQuery(hql);
//		List list=q.list();
//		if(list.size()>0){
//			all=list;
//		}
		List<Student>all=session.createCriteria(Student.class).list();
		methodclose();
		return all;	
	}
	//查询单条信息
	public Student selectsingle(Integer id){
		methodopen();
		student=(Student) session.get(Student.class,id);
		methodclose();
		return student;
	}
	//添加
	public void insert(Student student)  {
		   methodopen();
		   session.save(student);
		   methodclose();
		   
		}
	//修改
	public void update(Student student){
		 methodopen();
		session.update(student);
		methodclose();
		
	}
	//删除
	public void deleteById(Student student){
		 methodopen();
		session.delete(student);
		methodclose();
		
	}
	//批量删除
	public void deleteAll(Integer [] ids){
		methodopen();
		for(Integer id=0;id<ids.length;id++){
			Student student=new StudentDao().selectsingle(id);
			session.delete(student);
		}
		methodclose();
	} 
	//按姓名查询
	public List<Student> selectName(String name){
		methodopen();
		name="%"+name+"%";
		Criteria criteria =session.createCriteria(Student.class);
		Criterion criterion = org.hibernate.criterion.Expression.like("name", name);
		criteria.add(criterion);
		List<Student> list=criteria.list();
		methodclose();
		return list;
	}
		
}
