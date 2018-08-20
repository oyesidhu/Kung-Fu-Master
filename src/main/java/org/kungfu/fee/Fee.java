package org.kungfu.fee;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.kungfu.student.Student;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Fee {
	@Id
	@GeneratedValue
	int fee_num;
	String fee_description;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone="EST")
	Date fee_date;
	int fee_value;

	@ManyToOne()
	@JoinColumn(name ="std_num")
	public Student studentFee;
	//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@feeNum")

	public int getFee_num() {
		return fee_num;
	}
//	public int getStd_num() {
//		return std_num;
//	}
//	public void setStd_num(int std_num) {
//		this.std_num = std_num;
//	}
	public Student getStudentFee() {
		return studentFee;
	}
	public void setStudentFee(Student studentFee) {
		this.studentFee = studentFee;
	}
	public void setFee_num(int fee_num) {
		this.fee_num = fee_num;
	}
	public String getFee_description() {
		return fee_description;
	}
	public void setFee_description(String fee_description) {
		this.fee_description = fee_description;
	}
	public Date getFee_date() {
		return fee_date;
	}
	public void setFee_date(Date fee_date) {
		this.fee_date = fee_date;
	}
	public int getFee_value() {
		return fee_value;
	}
	public void setFee_value(int fee_value) {
		this.fee_value = fee_value;
	}
	public Student getStudent() {
		return studentFee;
	}
	public void setStudent(Student student) {
		this.studentFee = student;
	}
	
}
