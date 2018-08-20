package org.kungfu.parent;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ParentRepository  extends CrudRepository<Parent,Integer>{

	@Query("select p from Parent p join p.student s where s.std_num=?1")
	public List<Parent> getStudentParent(int std_num);
}
