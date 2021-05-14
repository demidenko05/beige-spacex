package org.beigesoft.beigespacex.launche;

import org.beigesoft.beigespacex.rocket.Rocket;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Launch {

	@Id
	private Integer flight_number;
	
	private String mission_name;

	private Integer launch_year;

	@ManyToOne
	private Rocket rocket;

	private LinksJson links;

	public Launch() {
		
	}

	public Launch(LaunchJson pSrc, Rocket pRkt) {
		this.flight_number = pSrc.getFlight_number();
		this.mission_name = pSrc.getMission_name();
		this.launch_year = pSrc.getLaunch_year();
		this.rocket = pRkt;
		this.links = pSrc.getLinks();
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

	public LinksJson getLinks() {
		return links;
	}

	public void setLinks(LinksJson links) {
		this.links = links;
	}
}
