package org.beigesoft.beigespacex.launche;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.beigesoft.beigespacex.rocket.Rocket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Launch {

	@Id
	private Integer flight_number;
	
	private String mission_name;

	private Integer launch_year;

	@ManyToOne
	private Rocket rocket;

	private Links links;

	public void addFlirckImg (FlirckrImg pFlImg) {
		this.links.getFlicImgs().add(pFlImg);
		pFlImg.getLaunchs().add(this);
	}

	public void remFlirckImg (FlirckrImg pFlImg) {
		this.links.getFlicImgs().remove(pFlImg);
		pFlImg.getLaunchs().remove(this);
	}

	public void clearFlirckImgs () {
		for (FlirckrImg img : this.links.getFlicImgs()) {
			img.getLaunchs().remove(this);
		}
		this.links.getFlicImgs().clear();
	}

	public Integer getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(Integer flight_number) {
		this.flight_number = flight_number;
	}

	public String getMission_name() {
		return mission_name;
	}

	public void setMission_name(String mission_name) {
		this.mission_name = mission_name;
	}

	public Integer getLaunch_year() {
		return launch_year;
	}

	public void setLaunch_year(Integer launch_year) {
		this.launch_year = launch_year;
	}

	public Rocket getRocket() {
		return rocket;
	}

	public void setRocket(Rocket rocket) {
		this.rocket = rocket;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}
}
