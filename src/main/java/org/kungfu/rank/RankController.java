package org.kungfu.rank;

import java.util.List;

import org.kungfu.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController {

	@Autowired
	public RankService rankService;
	
	// 1. Get all rank records
		@RequestMapping("/rank")
		public List<Rank> getAllRanks() {
			return rankService.getAllRanks();
		}
		
	//2.Add new Rank
		@RequestMapping(value = "/rank", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
		public void addRank(@RequestBody Rank rank) {
			System.out.println("Rank Name recieved = " + rank.rk_name);
			System.out.println("Rank number recieved = " + rank.rk_code);
			System.out.println("Rank color recieved = " + rank.rk_belt_color);
			System.out.println("Calling add topic call\n");
			rankService.addRank(rank);
		}
	
	
}
