package org.kungfu.student;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

		@Query("select s from Student s join s.rank r where r.rk_code=?1")
		public List<Student> getByRank(int id);
		
		public List<Student> getByStatus(String status);
		
		@Query("select s from Student s join s.rank r where r.rk_belt_color=?1")
		public List<Student> getStudentBelt(String rk_belt_color);
		
		@Query("select s from Student s where EXTRACT (year FROM std_date_enroll) =?1")
		public List<Student> getEnrollYear(int year);
		
		@Query("select s from Student s where EXTRACT (year FROM std_date_enroll) >=?1")
		public List<Student> getEnrollYearGt(int year);
		
		@Query("select s from Student s where EXTRACT (year FROM std_date_enroll) <=?1")
		public List<Student> getEnrollYearLt(int year);
		
		@Query("select distinct(r.rk_belt_color) from Student s join s.rank r")
		public List<String> getUniqueRankBelt();
		
		@Query("select distinct(r.rk_code) from Student s join s.rank r")
		public List<Integer> getUniqueRank();
	
}
