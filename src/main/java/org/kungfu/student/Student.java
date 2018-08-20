package org.kungfu.student;

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

import org.kungfu.fee.Fee;
import org.kungfu.rank.Rank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int std_num;
	public String std_fname;
	public String std_lname;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone="EST")
	public Date std_dob;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone="EST")
	public Date std_date_enroll;
	public long std_phone;
	public String status;
	public String std_email;
	public String std_address_line1;
	public String std_address_line2;
	public String std_address_city;
	public String std_address_prov;
	public String std_address_zipcode;
	@ManyToOne() // to skip saving the rank object on every student submission
	@JoinColumn(name="rk_code")
	//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@stdNum")
	public Rank rank;

	//Getter and Setters
	
	
	public int getStd_num() {
		return std_num;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setStd_num(int std_num) {
		this.std_num = std_num;
	}
	public String getStd_fname() {
		return std_fname;
	}
	public void setStd_fname(String std_fname) {
		this.std_fname = std_fname;
	}
	public String getStd_lname() {
		return std_lname;
	}
	public void setStd_lname(String std_lname) {
		this.std_lname = std_lname;
	}
	public Date getStd_dob() {
		return std_dob;
	}
	public void setStd_dob(Date std_dob) {
		this.std_dob = std_dob;
	}
	public Date getStd_date_enroll() {
		return std_date_enroll;
	}
	public void setStd_date_enroll(Date std_date_enroll) {
		this.std_date_enroll = std_date_enroll;
	}
	public long getStd_phone() {
		return std_phone;
	}
	public void setStd_phone(long std_phone) {
		this.std_phone = std_phone;
	}
	public String getStd_email() {
		return std_email;
	}
	public void setStd_email(String std_email) {
		this.std_email = std_email;
	}
	public String getStd_address_line1() {
		return std_address_line1;
	}
	public void setStd_address_line1(String std_address_line1) {
		this.std_address_line1 = std_address_line1;
	}
	public String getStd_address_line2() {
		return std_address_line2;
	}
	public void setStd_address_line2(String std_address_line2) {
		this.std_address_line2 = std_address_line2;
	}
	public String getStd_address_city() {
		return std_address_city;
	}
	public void setStd_address_city(String std_address_city) {
		this.std_address_city = std_address_city;
	}
	public String getStd_address_prov() {
		return std_address_prov;
	}
	public void setStd_address_prov(String std_address_prov) {
		this.std_address_prov = std_address_prov;
	}
	public String getStd_address_zipcode() {
		return std_address_zipcode;
	}
	public void setStd_address_zipcode(String std_address_zipcode) {
		this.std_address_zipcode = std_address_zipcode;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
//	public Collection<Fee> getFee() {
//		return fee;
//	}
//	public void setFee(Collection<Fee> fee) {
//		this.fee = fee;
//	}
	
	
}
