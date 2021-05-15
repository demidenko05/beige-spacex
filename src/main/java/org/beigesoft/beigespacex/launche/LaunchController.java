package org.beigesoft.beigespacex.launche;

import java.util.Date;
import java.util.Map;

import org.beigesoft.beigespacex.rocket.Rocket;
import org.beigesoft.beigespacex.stat.Statst;
import org.beigesoft.beigespacex.stat.StatstRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LaunchController {

	private LaunchRepository launRepo;

	private RestTemplate restTmpl;

	private StatstRepository statRepo;
	
	private ObjectMapper jsnMpr;
	
	public LaunchController(LaunchRepository pLauRepo, RestTemplateBuilder pRstBld,
							StatstRepository pStatRepo, ObjectMapper pJsnMpr) {
		this.launRepo = pLauRepo;
		this.restTmpl = pRstBld.build();
		this.statRepo = pStatRepo;
		this.jsnMpr = pJsnMpr;
	}

	@GetMapping("/launchesJson/{rktId}")
	public String fetch(@PathVariable("rktId") String pRctId, Map<String, Object> pMdl) throws JsonMappingException, JsonProcessingException {
		String req = "https://api.spacexdata.com/v3/launches?rocket_id=" + pRctId;
		String jsnRsp = this.restTmpl.getForObject(req, String.class);
		this.statRepo.save(new Statst(new Date(), req, jsnRsp));
		LaunchJson[] launchs = this.jsnMpr.readValue(jsnRsp, LaunchJson[].class);
		Rocket rkt = new Rocket(pRctId);
	    for (LaunchJson lnch : launchs) {
	    	if (lnch.getLinks().getFlickr_images() != null
    			&& lnch.getLinks().getFlickr_images().size() > 0) {
	    		for (String pth : lnch.getLinks().getFlickr_images()) {
	    			lnch.getLinks().getFlicImgs().add(new FlirckrImg(pth));
	    		}
	    	}
	    	this.launRepo.save(new Launch(lnch, rkt));
		}	    
		pMdl.put("launchs", this.launRepo.findByRocket(rkt));
		return "launchs";
	}

	@GetMapping("/launches")
	public String listAll(Map<String, Object> pMdl) {
		pMdl.put("launchs", this.launRepo.findAll());
		return "launchs";
	}
}
