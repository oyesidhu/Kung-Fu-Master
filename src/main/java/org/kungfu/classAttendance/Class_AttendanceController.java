package org.kungfu.classAttendance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Class_AttendanceController {

	@Autowired
	public Class_AttendanceService classAttRepository;

	// 1. Get all rank records
	@RequestMapping("/classAttendance")
	public List<Class_Attendance> getAllRanks() {
		return classAttRepository.getAllClassAtt();
	}

	// 2.Add new Rank
	@RequestMapping(value = "/classAttendance", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addRank(@RequestBody Class_Attendance classAtt) {
		System.out.println("Attendence date recieved = " + classAtt.att_date);
		classAttRepository.addClassAtt(classAtt);
	}

	// 2. Get all records by stud
	@RequestMapping("/classAttendance/stud/{id}")
	public List<Class_Attendance> getAllClassAttByStud( @PathVariable int id) {
		return classAttRepository.getAllClassAttByStud(id);
	}

}
