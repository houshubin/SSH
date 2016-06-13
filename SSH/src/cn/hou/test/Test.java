package cn.hou.test;

import javax.sql.DataSource;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hou.entity.Student;



public class Test {

	/**
	 * @param args
	 */
	public static ApplicationContext ctx=null;
	public static void main(String[] args) {
		ctx=new ClassPathXmlApplicationContext("applicationcontext.xml");
		System.out.println(ctx);
		DataSource dataSource=ctx.getBean(DataSource.class);
		System.out.println(dataSource);
		SessionFactory sessionFactory=ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Student student=new Student(111,"小王2","20151015","三年级六班");
		session.save(student);
		transaction.commit();
		session.close();
	}

}
