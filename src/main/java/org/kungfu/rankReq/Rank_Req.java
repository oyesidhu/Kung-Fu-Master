package org.kungfu.rankReq;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import org.kungfu.rank.Rank;
import org.kungfu.student.Student;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Rank_Req {
	
	@Id
	@GeneratedValue
	@Column(unique=true)
	int req_num;
	String req_description;
	@ManyToOne()
	@JoinColumn(name ="rk_code")
	//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@ReqNum")
	public Rank rank;
	
	
	//Getter and Setter
	public int getReq_num() {
		return req_num;
	}
	public void setReq_num(int req_num) {
		this.req_num = req_num;
	}
	public String getReq_description() {
		return req_description;
	}
	public void setReq_description(String req_description) {
		this.req_description = req_description;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
}
