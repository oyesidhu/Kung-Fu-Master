package org.kungfu.rankHist;

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
public class Rank_historyController {

	@Autowired
	public Rank_historyService rankHistService;

	// 1. Get all rank records
	@RequestMapping("/rankHist")
	public List<Rank_history> getAllRanks() {
		return rankHistService.getAllRankHist();
	}

	// 2.Add new Rank
	@RequestMapping(value = "/rankHist", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addRank(@RequestBody Rank_history rankHist) {
		System.out.println("Fee Num recieved = " + rankHist.dt_achieved);
		System.out.println("Calling add rank History call\n");
		rankHistService.addRankHist(rankHist);
	}

	// 3. Get all rank records per student
	@RequestMapping("/rankHist/stud/{id}")
	public List<Rank_history> getAllRanksByStud(@PathVariable int id) {
		return rankHistService.getAllRanksByStud(id);
	}
}
