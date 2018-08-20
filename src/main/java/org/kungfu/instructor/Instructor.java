package org.kungfu.instructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.kungfu.student.Student;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Instructor {
	@Id
	@GeneratedValue
	int ins_num;
	String ins_name;
	
	//All getter and setters
	
	public String getIns_name() {
		return ins_name;
	}
	public int getIns_num() {
		return ins_num;
	}
	public void setIns_num(int ins_num) {
		this.ins_num = ins_num;
	}
	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}
}
