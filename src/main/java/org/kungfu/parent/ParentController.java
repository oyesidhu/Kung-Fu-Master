package org.kungfu.parent;

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
public class ParentController {

	@Autowired
	public ParentService parentService;

	// 1. Get all parent records
	@RequestMapping("/parent")
	public List<Parent> getAllParent() {
		return parentService.getAllParent();
	}

	// 2.Add new parent
	@RequestMapping(value = "/parent", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addRank(@RequestBody Parent parent) {
		System.out.println("Parent Fname recieved = " + parent.prt_fname);
		System.out.println("Parent Lname recieved = " + parent.prt_lname);
		System.out.println("Student num recieved = " + parent.getStudent().std_num);
		System.out.println("Parent num recieved = " + parent.getStudentParent().std_num);
		System.out.println("phone =" + parent.prt_phone);
		if(parent.getStudentParent().std_num==0){
			parent.setStudentParent(null);
		}
		System.out.println("Setting the correct values");
		System.out.println("Calling add parent call\n");
		parentService.addParent(parent);
	}

	// 2. Get all parent records of student
	@RequestMapping("/parent/stud/{id}")
	public List<Parent> getStudentParent(@PathVariable int id) {
		return parentService.getStudentParent(id);
	}

}
