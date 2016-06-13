package cn.hou.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(schema="open_jpa",name="dao.student")
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="age")
	private Integer age;
	@Column(name="name")
	private String name;
	@Column(name="number")
	private String number;
	@Column(name="grade")
	private String grade;
	public Student() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public Student(Integer age, String name, String number, String grade) {
		super();
		this.age = age;
		this.name = name;
		this.number = number;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", number=" + number
				+ ", grade=" + grade + "]";
	}
	
}
