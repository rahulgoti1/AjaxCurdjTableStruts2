package com.action;

import java.io.IOException;
import java.util.List;

import com.dao.CrudDao;
import com.model.Student;
import com.opensymphony.xwork2.Action;

public class JtableAction {
	
	private CrudDao dao = new CrudDao();

	private List<Student> records;
	private String result;
	private String message;
	private Student record;

	private int studentId;	
	private String name;
	private String department;
	private String emailId;

	public String list() {
		try {
			// Fetch Data from Student Table
			records = dao.getAllStudents();
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public String create() throws IOException {
		record = new Student();
		
		record.setStudentId(studentId);
		record.setName(name);
		record.setDepartment(department);
		record.setEmailId(emailId);
	
		try {
			// Create new record
			dao.addStudent(record);
			result = "OK";

		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;	
	}

	public String update() throws IOException {
		Student student = new Student();
		
		student.setStudentId(studentId);
		student.setName(name);
		student.setDepartment(department);
		student.setEmailId(emailId);
		
		try {
			// Update existing record
			dao.updateStudent(student);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public String delete() throws IOException {
		// Delete record
		try {
			dao.deleteStudent(studentId);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Student getRecord() {
		return record;
	}

	public void setRecord(Student record) {
		this.record = record;
	}

	public List<Student> getRecords() {
		return records;
	}

	public String getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public void setRecords(List<Student> records) {
		this.records = records;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}