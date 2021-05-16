package org.beigesoft.beigespacex.launche;

import java.util.Map;

import org.beigesoft.beigespacex.rocket.Rocket;
import org.beigesoft.beigespacex.stat.StatstRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LaunchController {

	private LaunchRepository launRepo;
	
	private LaunchService launSrv;
	
	public LaunchController(LaunchRepository pLauRepo, RestTemplateBuilder pRstBld,
							StatstRepository pStatRepo, ObjectMapper pJsnMpr, LaunchService launSrv) {
		this.launRepo = pLauRepo;
		this.launSrv = launSrv;
	}

	@GetMapping("/launchesJson/{rktId}")
	public String fetch(@PathVariable("rktId") String pRctId, Map<String, Object> pMdl) throws JsonMappingException, JsonProcessingException {
		Rocket rkt = this.launSrv.fetchLounches(pRctId);
		pMdl.put("launchs", this.launRepo.findByRocket(rkt));
		pMdl.put("rkt", rkt);
		return "launchs";
	}

	@GetMapping("/launches")
	public String listAll(Map<String, Object> pMdl) {
		pMdl.put("launchs", this.launRepo.findAll());
		return "launchs";
	}
}
