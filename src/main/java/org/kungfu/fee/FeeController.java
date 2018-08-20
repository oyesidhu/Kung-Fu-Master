package org.kungfu.fee;

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
public class FeeController {

	@Autowired
	public FeeService feeService;

	// 1. Get all rank records
	@RequestMapping("/fee")
	public List<Fee> getAllRanks() {
		return feeService.getAllFees();
	}

	// 2.Add new Rank
	@RequestMapping(value = "/fee", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addRank(@RequestBody Fee fee) {
		System.out.println("Fee Num recieved = " + fee.fee_num);
		System.out.println("Fee desc recieved = " + fee.fee_description);
		System.out.println("Fee value recieved = " + fee.fee_value);
		System.out.println("Fee date recieved = " + fee.fee_date);
		// System.out.println("Student id recieved = " +
		// fee.getStudent().std_num);
		System.out.println("Calling add topic call\n");
		feeService.addFees(fee);
	}

	// 3. get one fee record by feeId
	@RequestMapping(value = "/fee/{id}", method = RequestMethod.GET)
	public Fee getOneFee(@PathVariable int id) {
		return feeService.getOneFee(id);
	}

	// 4. get one fee record by userId
	@RequestMapping(value = "/fee/stud/{id}", method = RequestMethod.GET)
	public List<Fee> getAllStudFee(@PathVariable int id) {
		System.out.println("ID recieved = " + id);
		return feeService.getAllStudFee(id);
	}

}
