package org.beigesoft.beigespacex.rocket;

import java.util.Date;
import java.util.Map;

import org.beigesoft.beigespacex.stat.Statst;
import org.beigesoft.beigespacex.stat.StatstRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RocketController {
	
	public static String ROCKETS_REST_URI = "https://api.spacexdata.com/v3/rockets";

	private RestTemplate restTmpl;

	private RocketRepository rktRepo;

	private StatstRepository statRepo;
	
	private ObjectMapper jsnMpr;
	
	public RocketController(RestTemplateBuilder pRstBld, RocketRepository pRktRepo,
							StatstRepository pStatRepo, ObjectMapper pJsnMpr) {
		this.restTmpl = pRstBld.build();
		this.rktRepo = pRktRepo;
		this.statRepo = pStatRepo;
		this.jsnMpr = pJsnMpr;
	}

	@GetMapping("/rocketsJson")
	public String fetch(Map<String, Object> pMdl) throws JsonMappingException, JsonProcessingException {
//		RocketJson[] rockets = this.restTmpl.getForObject(ROCKETS_REST_URI, RocketJson[].class);
		String jsnRsp = this.restTmpl.getForObject(ROCKETS_REST_URI, String.class);
		this.statRepo.save(new Statst(new Date(), ROCKETS_REST_URI, jsnRsp));
		RocketJson[] rockets = this.jsnMpr.readValue(jsnRsp, RocketJson[].class);
	    for (RocketJson rk : rockets) {
	    	this.rktRepo.save(new Rocket(rk));
		}	    
		pMdl.put("rkts", this.rktRepo.findAll());
		return "rockets";
	}

	@GetMapping("/rockets")
	public String listAll(Map<String, Object> pMdl) {
		pMdl.put("rkts", this.rktRepo.findAll());
		return "rockets";
	}
}
