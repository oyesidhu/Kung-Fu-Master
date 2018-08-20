package org.kungfu.rankHist;

import java.util.ArrayList;
import java.util.List;

import org.kungfu.student.Student;
import org.kungfu.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rank_historyService {

	@Autowired
	public Rank_historyRepository rkRepository;

	// 1. Service to get all rank information
	public List<Rank_history> getAllRankHist() {
		List<Rank_history> rankHist = new ArrayList<Rank_history>();
		rkRepository.findAll().forEach(rankHist::add);
		return rankHist;
	}

	// 2. Add new rank information
	public void addRankHist(Rank_history rankHist) {
		rkRepository.save(rankHist);
	}

	// 3. Service to get all rank information for input student
	public List<Rank_history> getAllRanksByStud(int stud_num) {
		List<Rank_history> rankHist = new ArrayList<Rank_history>();
		rkRepository.findStudRankHist(stud_num).forEach(rankHist::add);
		return rankHist;
	}

}
