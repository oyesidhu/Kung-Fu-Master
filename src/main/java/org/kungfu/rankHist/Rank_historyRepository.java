package org.kungfu.rankHist;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Rank_historyRepository  extends CrudRepository<Rank_history, Integer>{

	@Query("select r from Rank_history r join r.student s where s.std_num=?1")
	public List<Rank_history> findStudRankHist(int std_num);
}
