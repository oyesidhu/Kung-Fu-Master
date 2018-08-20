package org.kungfu.rank;

import java.util.ArrayList;
import java.util.List;

import org.kungfu.student.Student;
import org.kungfu.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankService {

	@Autowired
	public RankRepository rankRepository;

	// 1. Service to get all rank information
	public List<Rank> getAllRanks() {
		List<Rank> rank = new ArrayList<Rank>();
		rankRepository.findAll().forEach(rank::add);
		return rank;
	}
	
	//2. Add new rank information
	public void addRank(Rank rank){
		rankRepository.save(rank);
	}
	
}
