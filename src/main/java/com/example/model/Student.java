package com.example.model;

import java.util.HashMap;

public class Student {
	
	private String studentID;
    private String studentName;
    private String studentAddress;
    private String studentMobile;
    private HashMap<String, Integer> marks = new HashMap<>();
    private String photoPath;
    
    public Student() {
    	
    };
    
	public Student(String studentID, String studentName, String studentAddress, String studentMobile,
			HashMap<String, Integer> marks, String photoPath) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentMobile = studentMobile;
		this.marks = marks;
		this.photoPath = photoPath;
	}

	public Student(String studentID, String studentName, String studentAddress, String studentMobile) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentMobile = studentMobile;
		this.marks = marks;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	public HashMap<String, Integer> getMarks() {
		return marks;
	}

	public void setMarks(HashMap<String, Integer> marks) {
		this.marks = marks;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", studentMobile=" + studentMobile + ", marks=" + marks + ", photoPath=" + photoPath
				+ ", getStudentID()=" + getStudentID() + ", getStudentName()=" + getStudentName()
				+ ", getStudentAddress()=" + getStudentAddress() + ", getStudentMobile()=" + getStudentMobile()
				+ ", getMarks()=" + getMarks() + ", getPhotoPath()=" + getPhotoPath() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
}
