package org.kungfu.rankReq;

import java.util.ArrayList;
import java.util.List;

import org.kungfu.student.Student;
import org.kungfu.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rank_ReqService {

	@Autowired
	public Rank_ReqRepository rankReqRepository;

	// 1. Service to get all rank information
	public List<Rank_Req> getAllRankReq() {
		List<Rank_Req> rankReq = new ArrayList<Rank_Req>();
		rankReqRepository.findAll().forEach(rankReq::add);
		return rankReq;
	}

	// 2. Add new rank information
	public void addRankReq(Rank_Req rankReq) {
		rankReqRepository.save(rankReq);
	}

	// 1. Service to get all rank information
	public List<Rank_Req> getRankReqByRank(int id) {
			List<Rank_Req> rankReq = new ArrayList<Rank_Req>();
			rankReqRepository.getRankReqByRank(id).forEach(rankReq::add);
			return rankReq;
		}
}
