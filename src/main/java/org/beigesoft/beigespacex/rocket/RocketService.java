package org.beigesoft.beigespacex.rocket;

import java.util.Date;

import org.beigesoft.beigespacex.stat.Statst;
import org.beigesoft.beigespacex.stat.StatstRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RocketService {

	private RestTemplate restTmpl;

	private RocketRepository rktRepo;

	private StatstRepository statRepo;
	
	private ObjectMapper jsnMpr;

	@Value("${rocketsUri}")
	private String rktUri;
	
	public RocketService(RestTemplateBuilder pRstBld, RocketRepository pRktRepo,
							StatstRepository pStatRepo, ObjectMapper pJsnMpr) {
		this.restTmpl = pRstBld.build();
		this.rktRepo = pRktRepo;
		this.statRepo = pStatRepo;
		this.jsnMpr = pJsnMpr;
	}

	public void fetchAll() throws JsonMappingException, JsonProcessingException {
//		RocketJson[] rockets = this.restTmpl.getForObject(ROCKETS_REST_URI, RocketJson[].class);
		String jsnRsp = this.restTmpl.getForObject(this.rktUri, String.class);
		this.statRepo.save(new Statst(new Date(), this.rktUri, jsnRsp));
		RocketJson[] rockets = this.jsnMpr.readValue(jsnRsp, RocketJson[].class);
	    for (RocketJson rk : rockets) {
	    	this.rktRepo.save(new Rocket(rk.getRocket_id(), rk.getRocket_name()));
		}	    
	}
}
