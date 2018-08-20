package org.kungfu.classAttendance;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Class_AttendanceRepository  extends CrudRepository<Class_Attendance, Integer>{

		@Query("select s from Class_Attendance s join s.studentFee f where f.std_num=?1")
		public List<Class_Attendance> getCustAttStud(int id);
}
