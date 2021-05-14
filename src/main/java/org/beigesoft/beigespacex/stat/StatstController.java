package org.beigesoft.beigespacex.stat;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatstController {

	private StatstRepository statRepo;
	
	public StatstController(StatstRepository pStatRepo) {
		this.statRepo = pStatRepo;
	}

	@GetMapping("/stats")
	public String listAll(Map<String, Object> pMdl) {
		pMdl.put("stats", this.statRepo.findAll());
		return "stats";
	}
}
