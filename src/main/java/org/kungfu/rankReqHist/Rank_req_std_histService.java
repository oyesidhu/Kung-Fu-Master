package org.kungfu.rankReqHist;

import java.util.ArrayList;
import java.util.List;

import org.kungfu.student.Student;
import org.kungfu.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rank_req_std_histService {

	@Autowired
	public Rank_req_std_histRepository RankReqHistRepository;

	// 1. Service to get all rank information
	public List<Rank_req_std_hist> getAllRankReqHist() {
		List<Rank_req_std_hist> rankReqHist = new ArrayList<Rank_req_std_hist>();
		RankReqHistRepository.findAll().forEach(rankReqHist::add);
		return rankReqHist;
	}

	// 2. Add new rank information
	public void addRankReqHist(Rank_req_std_hist rankReqHist) {
		RankReqHistRepository.save(rankReqHist);
	}

	// 2. Service to get all rank req information by student
	public List<Rank_req_std_hist> getStudentReqHist(int std_num) {
		List<Rank_req_std_hist> rankReqHist = new ArrayList<Rank_req_std_hist>();
		RankReqHistRepository.getStudentReqHist(std_num).forEach(rankReqHist::add);
		return rankReqHist;
	}

}
