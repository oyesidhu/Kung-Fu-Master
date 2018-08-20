package org.kungfu.classAttendance;

import java.util.ArrayList;
import java.util.List;

import org.kungfu.student.Student;
import org.kungfu.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Class_AttendanceService {

	@Autowired
	public Class_AttendanceRepository classAttRepository;

	// 1. Service to get all rank information
	public List<Class_Attendance> getAllClassAtt() {
		List<Class_Attendance> classAtt = new ArrayList<Class_Attendance>();
		classAttRepository.findAll().forEach(classAtt::add);
		return classAtt;
	}
	
	//2. Add new rank information
	public void addClassAtt(Class_Attendance classAtt){
		classAttRepository.save(classAtt);
	}
	

	// 3. Service to get class Att by stud
	public List<Class_Attendance> getAllClassAttByStud(int id) {
		List<Class_Attendance> classAtt = new ArrayList<Class_Attendance>();
		classAttRepository.getCustAttStud(id).forEach(classAtt::add);
		return classAtt;
	}
}
