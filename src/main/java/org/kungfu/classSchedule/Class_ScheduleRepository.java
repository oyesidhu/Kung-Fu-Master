package org.kungfu.classSchedule;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Class_ScheduleRepository  extends CrudRepository<Class_Schedule, Integer>{

	@Query("select s from Class_Schedule s join s.classs c where c.cls_code=?1")
	List<Class_Schedule> getClassScheduleByClass(int id);
}
