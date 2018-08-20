package org.kungfu.parent;

import java.util.ArrayList;
import java.util.List;

import org.kungfu.student.Student;
import org.kungfu.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService {

	@Autowired
	public ParentRepository parentRepository;

	// 1. Service to get all parent information
	public List<Parent> getAllParent() {
		List<Parent> parent = new ArrayList<Parent>();
		parentRepository.findAll().forEach(parent::add);
		return parent;
	}
	
	//2. Add new parent information
	public void addParent(Parent parent){
		parentRepository.save(parent);
	}
	
	// 2. Service to get all parent information of a student
	public List<Parent> getStudentParent(int std_num) {
		List<Parent> parent = new ArrayList<Parent>();
		parentRepository.getStudentParent(std_num).forEach(parent::add);
		return parent;
	}
	
}
