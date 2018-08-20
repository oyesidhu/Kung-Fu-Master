package org.kungfu.rankReqHist;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Rank_req_std_histRepository  extends CrudRepository<Rank_req_std_hist, Integer>{

	@Query("select r from Rank_req_std_hist r join r.student s where s.std_num=?1")
	public List<Rank_req_std_hist> getStudentReqHist(int std_num);
}
