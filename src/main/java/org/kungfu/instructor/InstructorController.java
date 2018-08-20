package org.kungfu.instructor;

import java.util.List;

import org.kungfu.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {

	@Autowired
	public InstructorService instructorService;
	
	// 1. Get all rank records
		@RequestMapping("/instructor")
		public List<Instructor> getAllRanks() {
			return instructorService.getAllInstructor();
		}
		
	//2.Add new Rank
		@RequestMapping(value = "/instructor", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
		public void addRank(@RequestBody Instructor instructor) {
			System.out.println("Fee Num recieved = " +instructor.ins_name);
			System.out.println("Calling add topic call\n");
			instructorService.addInstructor(instructor);
		}
	
	
}
