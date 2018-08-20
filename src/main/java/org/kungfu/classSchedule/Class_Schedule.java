package org.kungfu.classSchedule;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.kungfu.classMain.Class;

@Entity
public class Class_Schedule {
	
	@Id
	@GeneratedValue
	int sch_num;
	String sch_dayweek;
	String start_time;
	String end_time;
	@ManyToOne()
	@JoinColumn(name ="cls_code")
	//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@clsNum")
	public Class classs;
	
	public int getSch_num() {
		return sch_num;
	}
	public void setSch_num(int sch_num) {
		this.sch_num = sch_num;
	}
	public String getSch_dayweek() {
		return sch_dayweek;
	}
	public void setSch_dayweek(String sch_dayweek) {
		this.sch_dayweek = sch_dayweek;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
}
