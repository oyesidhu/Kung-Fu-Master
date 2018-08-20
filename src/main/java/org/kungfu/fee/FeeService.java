package org.kungfu.fee;

import java.util.ArrayList;
import java.util.List;

import org.kungfu.student.Student;
import org.kungfu.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeService {

	@Autowired
	public FeeRepository feeRepository;

	// 1. Service to get all rank information
	public List<Fee> getAllFees() {
		List<Fee> fee = new ArrayList<Fee>();
		feeRepository.findAll().forEach(fee::add);
		return fee;
	}
	
	//2. Add new rank information
	public void addFees(Fee fee){
		feeRepository.save(fee);
	}
	
	//3. get one fee record
	public Fee getOneFee(int id){
		return feeRepository.findOne(id);
	}
	
	//4. get all fee record for a student
	public List<Fee> getAllStudFee(int std_num){
		List<Fee> fee = new ArrayList<Fee>();
		feeRepository.findStudentFee(std_num).forEach(fee::add);
		//System.out.println("obj" + list.fee_description);
		 return fee;
	}
}
