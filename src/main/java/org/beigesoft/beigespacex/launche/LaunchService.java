package org.beigesoft.beigespacex.launche;

import java.util.Date;

import org.beigesoft.beigespacex.rocket.Rocket;
import org.beigesoft.beigespacex.stat.Statst;
import org.beigesoft.beigespacex.stat.StatstRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LaunchService {

	private LaunchRepository launRepo;

	private RestTemplate restTmpl;

	private StatstRepository statRepo;
	
	private ObjectMapper jsnMpr;

	@Value("${launchesUri}")
	private String launUri;

	public LaunchService(LaunchRepository launRepo,  RestTemplateBuilder pRstBld, StatstRepository statRepo,
			ObjectMapper jsnMpr) {
		this.launRepo = launRepo;
		this.restTmpl = pRstBld.build();
		this.statRepo = statRepo;
		this.jsnMpr = jsnMpr;
	}

	public Rocket fetchLounches(String pRctId) throws JsonMappingException, JsonProcessingException {
		String req = this.launUri + "?rocket_id=" + pRctId;
		String jsnRsp = this.restTmpl.getForObject(req, String.class);
		this.statRepo.save(new Statst(new Date(), req, jsnRsp));
		LaunchJson[] launchs = this.jsnMpr.readValue(jsnRsp, LaunchJson[].class);
		Rocket rkt = new Rocket(pRctId);
	    for (LaunchJson lnch : launchs) {
	    	Launch lncha = new Launch(lnch.getFlight_number(), lnch.getMission_name(), lnch.getLaunch_year(), rkt);
	    	if (lnch.getLinks() != null) {
	    		lncha.setLinks(new Links(lnch.getLinks().getMission_patch(), lnch.getLinks().getMission_patch_small(),
	    				lnch.getLinks().getReddit_campaign(), lnch.getLinks().getArticle_link(),
	    				lnch.getLinks().getYoutube_id(), lnch.getLinks().getWikipedia()));
		    	if (lnch.getLinks().getFlickr_images() != null
	    			&& lnch.getLinks().getFlickr_images().size() > 0) {
		    		for (String pth : lnch.getLinks().getFlickr_images()) {
		    			lncha.getLinks().getFlicImgs().add(new FlirckrImg(pth));
		    		}
		    	}
	    	}
	    	this.launRepo.save(lncha);
	    }
	    return rkt;
	}

	public String getLaunUri() {
		return launUri;
	}

	public void setLaunUri(String launUri) {
		this.launUri = launUri;
	}
}
