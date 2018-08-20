package org.kungfu.classMain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.kungfu.instructor.Instructor;
import org.kungfu.student.Student;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Class {
	@Id
	@GeneratedValue
	int cls_code;
	String cls_description;
	String cls_level;
	@OneToOne()
	@JoinColumn(name ="ins_num")
	public Instructor instructor;
	
	//Getter and Setters
	public int getCls_code() {
		return cls_code;
	}
	public void setCls_code(int cls_code) {
		this.cls_code = cls_code;
	}
	public String getCls_description() {
		return cls_description;
	}
	public void setCls_description(String cls_description) {
		this.cls_description = cls_description;
	}
	public String getCls_level() {
		return cls_level;
	}
	public void setCls_level(String cls_level) {
		this.cls_level = cls_level;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
}
