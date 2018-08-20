package org.kungfu.fee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FeeRepository  extends CrudRepository<Fee, Integer>{
	
	    @Query("select f from Fee f inner join f.studentFee s where s.std_num=?1")
		public List<Fee> findStudentFee(int std_num);
}
