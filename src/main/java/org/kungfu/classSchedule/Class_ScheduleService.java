package org.kungfu.classSchedule;

import java.util.ArrayList;
import java.util.List;

import org.kungfu.student.Student;
import org.kungfu.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Class_ScheduleService {

	@Autowired
	public Class_ScheduleRepository classSRepository;

	// 1. Service to get all rank information
	public List<Class_Schedule> getAllClassSchedule() {
		List<Class_Schedule> classs = new ArrayList<Class_Schedule>();
		classSRepository.findAll().forEach(classs::add);
		return classs;
	}

	// 2. Add new rank information
	public void addClassSchedule(Class_Schedule classs) {
		classSRepository.save(classs);
	}

	// 3.. Service to get all schdule of one class
	public List<Class_Schedule> getAllClassSchedulbyClass(int id) {
		List<Class_Schedule> classs = new ArrayList<Class_Schedule>();
		classSRepository.getClassScheduleByClass(id).forEach(classs::add);
		return classs;
	}

}
