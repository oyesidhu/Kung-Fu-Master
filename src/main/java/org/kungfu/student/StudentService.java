package org.kungfu.student;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.kungfu.rank.Rank;
import org.kungfu.rank.RankService;
import org.kungfu.rankHist.Rank_history;
import org.kungfu.rankHist.Rank_historyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private Rank_historyService rank_historyService;

	// 1. Service to get all Student records
	public List<Student> getAllStudents() {
		List<Student> student = new ArrayList<Student>();
		studentRepository.findAll().forEach(student::add);
		return student;
	}

	// 2.insert new record
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	// 3. update existing record (specifically used in updating rank of student)
	public void updateStudent(int id, Student student) {
		int found = 0;
		Student exStudent = studentRepository.findOne(id);

		if (exStudent.std_num == id) {
			System.out.println("Record found");
			found = 1;
			// Check for changes in rank, if yes, store the backup in
			// rank_history table
			if (exStudent.rank.getRk_code() != student.rank.getRk_code()) {
				System.out.println("Rank change detected");
				System.out.println("Storing exiting entry in rank_hist table before update");
				Rank_history rankHist = new Rank_history();
				rankHist.student = new Student();
				rankHist.student.std_num = id;
				rankHist.rank = new Rank();
				rankHist.rank.setRk_code(exStudent.rank.getRk_code());
				LocalDate dt = LocalDate.now(ZoneId.of("America/Montreal"));
				;
				rankHist.setDt_achieved(java.sql.Date.valueOf(dt));
				rank_historyService.addRankHist(rankHist);
				System.out.println("History table updated successfully");
			}
		}

		if (found == 1) {
			student.std_num = id;
			studentRepository.save(student);
			System.out.println("Table updated\n");
		}
	}

	// 4. get a particular student
	public Student getOneStudent(int id) {
		return studentRepository.findOne(id);
	}

	// 5. get all student by rank
	public List<Student> getByStudentRank(int id) {
		List<Student> student = new ArrayList<Student>();
		studentRepository.getByRank(id).forEach(student::add);
		return student;
	}

	// 6. get all student by belt
	public List<Student> getByStudentBelt(String id) {
		List<Student> student = new ArrayList<Student>();
		studentRepository.getStudentBelt(id).forEach(student::add);
		return student;
	}

	// 7. get all student by year
	public List<Student> getStudentByYear(int id) {
		List<Student> student = new ArrayList<Student>();
		studentRepository.getEnrollYear(id).forEach(student::add);
		return student;
	}

	// 8. get all student by >= year
	public List<Student> getStudentByYearGt(int id) {
		List<Student> student = new ArrayList<Student>();
		studentRepository.getEnrollYearGt(id).forEach(student::add);
		return student;
	}

	// 9. get all student by <= year
	public List<Student> getStudentByYearLt(int id) {
		List<Student> student = new ArrayList<Student>();
		studentRepository.getEnrollYearLt(id).forEach(student::add);
		return student;
	}
	
	//10. get all active student
	public List<Student> getStudentByStatus(String status) {
		List<Student> student = new ArrayList<Student>();
		studentRepository.getByStatus(status).forEach(student::add);
		return student;
	}
	
	//11. get all active ranks belt
	public List<String> getUniqueRankBelt(){
		List<String> ranks = new ArrayList<String>();
		studentRepository.getUniqueRankBelt().forEach(ranks::add);
		return ranks;
	}
	
	//11. get all active ranks
	public List<Integer> getUniqueRank(){
		List<Integer> ranks = new ArrayList<Integer>();
		studentRepository.getUniqueRank().forEach(ranks::add);
		return ranks;
	}

}
