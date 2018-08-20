package org.kungfu.rankReq;

import java.util.List;

import org.kungfu.student.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Rank_ReqRepository  extends CrudRepository<Rank_Req, Integer>{
	
	@Query("select s from Rank_Req s join s.rank r where r.rk_code=?1")
	public List<Rank_Req> getRankReqByRank(int id);
}
