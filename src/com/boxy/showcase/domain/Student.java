package com.boxy.showcase.domain;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.boxy.showcase.web.validation.ValidateGroupAdd;
import com.boxy.showcase.web.validation.ValidateGroupEdit;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String studentNumber;
	@NotEmpty(message="{student.studentName.notEmpty}", groups={ValidateGroupAdd.class, ValidateGroupEdit.class})
	private String studentName;
	@NotEmpty(message="{student.gender.notEmpty}", groups={ValidateGroupAdd.class})
	private String gender;
	private Date birthday;
	private String street;
	private String city;
	private String province;
	private String photoUrl;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer id, String studentNumber, String studentName,
			String gender, Date birthday, String street, String city,
			String province, String photoUrl) {
		super();
		this.id = id;
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.gender = gender;
		this.birthday = birthday;
		this.street = street;
		this.city = city;
		this.province = province;
		this.photoUrl = photoUrl;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentNumber=" + studentNumber
				+ ", studentName=" + studentName + ", gender=" + gender
				+ ", birthday=" + birthday + ", street=" + street + ", city="
				+ city + ", province=" + province + ", photoUrl=" + photoUrl
				+ "]";
	}
}
