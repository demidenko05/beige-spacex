package org.beigesoft.beigespacex.rocket;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class RocketController {

	private RocketService rctSrv;

	private RocketRepository rktRepo;

	@Value("${rocketsUri}")
	private String rktUri;
	
	public RocketController(RocketRepository pRktRepo, RocketService pRctSrv) {
		this.rktRepo = pRktRepo;
		this.rctSrv = pRctSrv;
	}

	@GetMapping("/rocketsJson")
	@Transactional
	public String fetch(Map<String, Object> pMdl) throws JsonMappingException, JsonProcessingException {
		this.rctSrv.fetchAll();
		pMdl.put("rkts", this.rktRepo.findAll());
		return "rockets";
	}

	@GetMapping("/rockets")
	@Transactional
	public String listAll(Map<String, Object> pMdl) {
		pMdl.put("rkts", this.rktRepo.findAll());
		return "rockets";
	}
}
