package org.kungfu.classSchedule;


import java.util.List;

import org.kungfu.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Class_ScheduleController {

	@Autowired
	public Class_ScheduleService classSchService;

	// 1. Get all rank records
	@RequestMapping("/classSchedule")
	public List<Class_Schedule> getAllClassSchedule() {
		return classSchService.getAllClassSchedule();
	}

	// 2.Add new Rank
	@RequestMapping(value = "/classSchedule", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addClassSchedule(@RequestBody Class_Schedule classSch) {
		System.out.println("Class Day recieved = " + classSch.sch_dayweek);
		System.out.println("Class Start recieved = " + classSch.start_time);
		System.out.println("Class End recieved = " + classSch.end_time);
		System.out.println("Class End recieved = " + classSch.getClass());
		classSchService.addClassSchedule(classSch);
	}

	// 3. Get all class schedule of one class
	@RequestMapping("/classSchedule/{id}")
	public List<Class_Schedule> getAllClassSchedule(@PathVariable int id) {
		return classSchService.getAllClassSchedulbyClass(id);
	}

}
