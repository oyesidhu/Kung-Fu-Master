package org.kungfu.rankReqHist;

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
public class Rank_req_std_histController {

	@Autowired
	public Rank_req_std_histService rankReqHistService;

	// 1. Get all rank records
	@RequestMapping("/rankReqHist")
	public List<Rank_req_std_hist> getAllRankReqHist() {
		return rankReqHistService.getAllRankReqHist();
	}

	// 2.Add new Rank
	@RequestMapping(value = "/rankReqHist", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addRankReqHist(@RequestBody Rank_req_std_hist rankReqHist) {
		System.out.println("RankReqHist Date recieved= " + rankReqHist.dt_achieved);
		System.out.println("RankReqHist Student recieved= " + rankReqHist.getStudent().std_num);
		System.out.println("RankReqHist Rank recieved= " + rankReqHist.getRank().getRk_code());
		System.out.println("RankReqHist RankReq recieved= " + rankReqHist.getRank_req().getReq_num());
		rankReqHistService.addRankReqHist(rankReqHist);
	}

	// 2. Get all rank req hist records of student
	@RequestMapping("/rankReqHist/stud/{id}")
	public List<Rank_req_std_hist> getStudentReqHist(@PathVariable int id) {
		return rankReqHistService.getStudentReqHist(id);
	}
}
