package org.beigesoft.beigespacex.launche;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;

@Embeddable
public class Links {

	private String mission_patch;

	private String mission_patch_small;

	private String reddit_campaign;

	private String article_link;

	private String youtube_id;

	private String wikipedia;

	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<FlirckrImg> flicImgs  = new ArrayList<>(); 

	public Links() {
	}

	public Links(String mission_patch, String mission_patch_small, String reddit_campaign, String article_link,
			String youtube_id, String wikipedia) {
		this.mission_patch = mission_patch;
		this.mission_patch_small = mission_patch_small;
		this.reddit_campaign = reddit_campaign;
		this.article_link = article_link;
		this.youtube_id = youtube_id;
		this.wikipedia = wikipedia;
	}

	public String getMission_patch() {
		return mission_patch;
	}

	public void setMission_patch(String mission_patch) {
		this.mission_patch = mission_patch;
	}

	public String getMission_patch_small() {
		return mission_patch_small;
	}

	public void setMission_patch_small(String mission_patch_small) {
		this.mission_patch_small = mission_patch_small;
	}

	public String getReddit_campaign() {
		return reddit_campaign;
	}

	public void setReddit_campaign(String reddit_campaign) {
		this.reddit_campaign = reddit_campaign;
	}

	public String getArticle_link() {
		return article_link;
	}

	public void setArticle_link(String article_link) {
		this.article_link = article_link;
	}

	public String getYoutube_id() {
		return youtube_id;
	}

	public void setYoutube_id(String youtube_id) {
		this.youtube_id = youtube_id;
	}

	public String getWikipedia() {
		return wikipedia;
	}

	public void setWikipedia(String wikipedia) {
		this.wikipedia = wikipedia;
	}

	public List<FlirckrImg> getFlicImgs() {
		return flicImgs;
	}

	public void setFlicImgs(List<FlirckrImg> flicImgs) {
		this.flicImgs = flicImgs;
	}
}
