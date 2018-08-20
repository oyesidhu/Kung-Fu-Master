package org.kungfu.rank;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.kungfu.student.Student;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Rank {
	@Id
	int rk_code;
	String rk_name;
	String rk_belt_color;
	
	public Rank(){}
	
	public Rank(int code, String name, String color){
		this.rk_code=code;
		this.rk_name=name;
		this.rk_belt_color=color;
	} 
	
	public int getRk_code() {
		return rk_code;
	}
	public void setRk_code(int rk_code) {
		this.rk_code = rk_code;
	}
	public String getRk_name() {
		return rk_name;
	}
	public void setRk_name(String rk_name) {
		this.rk_name = rk_name;
	}
	public String getRk_belt_color() {
		return rk_belt_color;
	}
	public void setRk_belt_color(String rk_belt_color) {
		this.rk_belt_color = rk_belt_color;
	}

}
