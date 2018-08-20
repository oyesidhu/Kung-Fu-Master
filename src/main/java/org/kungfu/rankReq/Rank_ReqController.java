package org.kungfu.rankReq;

import java.util.List;

import org.kungfu.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rank_ReqController {

	@Autowired
	public Rank_ReqService rankReqService;

	// 1. Get all rank records
	@RequestMapping("/rankReq")
	public List<Rank_Req> getAllRankReq() {
		return rankReqService.getAllRankReq();
	}

	// 2.Add new Rank
	@RequestMapping(value = "/rankReq", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addRank(@RequestBody Rank_Req rankReq) {
		System.out.println("Rank Req description = " + rankReq.req_description);
		rankReqService.addRankReq(rankReq);
	}

	// 3. Get all rank req for a rank
	@RequestMapping("/rankReq/{id}")
	public List<Rank_Req> getAllRankReq( @PathVariable int id) {
		return rankReqService.getRankReqByRank(id);
	}
}
