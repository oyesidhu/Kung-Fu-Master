package org.kungfu.student;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import org.kungfu.rank.Rank;
import org.kungfu.rank.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private RankService rankService;

	// 1. Get all student records
	@RequestMapping("/student")
	public List<Student> getAllStudets() {
		return studentService.getAllStudents();
	}

	// 2. Insert new student record
	@ManyToOne(cascade = CascadeType.PERSIST)
	@RequestMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addRank(@RequestBody Student student) {
		System.out.println("Student num recieved = " + student.std_num);
		System.out.println("Student Fname recieved = " + student.std_fname);
		System.out.println("Student Lname recieved = " + student.std_lname);
		System.out.println("Student phone recieved = " + student.std_phone);
		System.out.println("Student email recieved = " + student.std_email);
		System.out.println("Student dob recieved = " + student.std_dob);
		System.out.println("Student enroll date recieved = " + student.std_date_enroll);
		System.out.println("Student addr1 recieved = " + student.std_address_line1);
		System.out.println("Student addr2 recieved = " + student.std_address_line2);
		System.out.println("Student city recieved = " + student.std_address_city);
		System.out.println("Student prov recieved = " + student.std_address_prov);
		System.out.println("Student zipcode recieved = " + student.std_address_zipcode);
		// System.out.println("Student rank_code recieved = " + student.);

		System.out.println("Calling add topic call\n");
		// rankService.addRank(student.getRank());
		studentService.addStudent(student);
	}

	// 3. Update existing record(For Example : Update Rank information)
	@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
	public void updateStudent(@RequestBody Student student, @PathVariable int id) {
		System.out.println("ID as paramter recieved = " + id);
		System.out.println("Student num recieved = " + student.std_num);
		System.out.println("Student Fname recieved = " + student.std_fname);
		System.out.println("Student Lname recieved = " + student.std_lname);
		System.out.println("Student phone recieved = " + student.std_phone);
		System.out.println("Student email recieved = " + student.std_email);
		System.out.println("Student dob recieved = " + student.std_dob);
		System.out.println("Student enroll date recieved = " + student.std_date_enroll);
		System.out.println("Student addr1 recieved = " + student.std_address_line1);
		System.out.println("Student addr2 recieved = " + student.std_address_line2);
		System.out.println("Student city recieved = " + student.std_address_city);
		System.out.println("Student prov recieved = " + student.std_address_prov);
		System.out.println("Student zipcode recieved = " + student.std_address_zipcode);
		studentService.updateStudent(id, student);
	}

	// 4. Get a particular student
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public Student getOneStudent(@PathVariable int id) {
		System.out.println("id recieved = " + id);
		return studentService.getOneStudent(id);
	}

	// 5. Get student by rank
	@RequestMapping(value = "/student/rank/{id}", method = RequestMethod.GET)
	public List<Student> getByStudentRank(@PathVariable int id) {
		System.out.println("id recieved = " + id);
		return studentService.getByStudentRank(id);
	}

	// 6. Get Student by belt
	@RequestMapping(value = "/student/belt/{id}", method = RequestMethod.GET)
	public List<Student> getByStudentBelt(@PathVariable String id) {
		System.out.println("belt recieved = " + id);
		return studentService.getByStudentBelt(id);
	}

	// 7. Get Student by year
	@RequestMapping(value = "/student/year/{id}", method = RequestMethod.GET)
	public List<Student> getStudentByYear(@PathVariable int id) {
		System.out.println("year recieved = " + id);
		return studentService.getStudentByYear(id);
	}

	// 8. Get Student by >=year
	@RequestMapping(value = "/student/yearGt/{id}", method = RequestMethod.GET)
	public List<Student> getStudentByYearGt(@PathVariable int id) {
		System.out.println("year recieved = " + id);
		return studentService.getStudentByYearGt(id);
	}

	// 9. Get Student by belt
	@RequestMapping(value = "/student/yearLt/{id}", method = RequestMethod.GET)
	public List<Student> getStudentByYearLt(@PathVariable int id) {
		System.out.println("year recieved = " + id);
		return studentService.getStudentByYearLt(id);
	}

	// 10. Get combined table result (belt,year)
	@RequestMapping(value = "/student/combo/{belt}/{year}/{mode}", method = RequestMethod.GET)
	public List<Student> getStudentByCombo(@PathVariable String belt, @PathVariable int year,
			@PathVariable String mode) {
		System.out.println("belt = " + belt);
		System.out.println("year = " + year);
		System.out.println("mode = " + mode);

		List<Student> studByBelt = studentService.getByStudentBelt(belt);
		List<Student> studByYear = new ArrayList<>();
		List<Student> studByCombo = new ArrayList<>();
		if (mode.equals(">=")) {
			System.out.println("inside >= call");
			studByYear = studentService.getStudentByYearGt(year);
		} else if (mode.equals("<=")) {
			System.out.println("inside <= call");
			studByYear = studentService.getStudentByYearLt(year);
		} else {
			System.out.println("inside = call");
			studByYear = studentService.getStudentByYear(year);
		}

		for (int i = 0; i < studByBelt.size(); i++) {
			for (int j = 0; j < studByYear.size(); j++) {
				if (studByBelt.get(i).std_num == studByYear.get(j).std_num) {
					studByCombo.add(studByBelt.get(i));
				}
			}
		}

		return studByCombo;
	}

	// 11. Get all student by status
	@RequestMapping("/student/status/{id}")
	public List<Student> getStudentByStatus(@PathVariable String id) {
		return studentService.getStudentByStatus(id);
	}

	// 12.Get all active ranks belts
	@RequestMapping("/student/activeRankBelt")
	public List<String> getUniqueRankBelt() {
		return studentService.getUniqueRankBelt();
	}

	// 13.Get all active ranks
	@RequestMapping("/student/activeRank")
	public List<Integer> getUniqueRank() {
		return studentService.getUniqueRank();
	}
}
