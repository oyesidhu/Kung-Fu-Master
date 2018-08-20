package org.kungfu.rankReqHist;

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

import org.kungfu.rank.Rank;
import org.kungfu.rankReq.Rank_Req;
import org.kungfu.student.Student;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Rank_req_std_hist {
	@Id
	@GeneratedValue
	int serial_num;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone="EST")
	Date dt_achieved;
	@ManyToOne()
	@JoinColumn(name ="std_num")
	//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@StdNum")
	public Student student;
	@ManyToOne()
	@JoinColumn(name ="rk_code")
	//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@RankNum")
	public Rank rank;
	@ManyToOne()
	@JoinColumn(name ="req_num")
	//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@ReqNum")
	public Rank_Req rank_req;
	
	//Getter and Setter
	public int getSerial_num() {
		return serial_num;
	}
	public void setSerial_num(int serial_num) {
		this.serial_num = serial_num;
	}
	
	public Date getDt_achieved() {
		return dt_achieved;
	}
	public void setDt_achieved(Date dt_achieved) {
		this.dt_achieved = dt_achieved;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Rank_Req getRank_req() {
		return rank_req;
	}
	public void setRank_req(Rank_Req rank_req) {
		this.rank_req = rank_req;
	}
}
