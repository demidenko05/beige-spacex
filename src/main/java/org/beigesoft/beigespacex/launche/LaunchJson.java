package org.beigesoft.beigespacex.launche;

import org.beigesoft.beigespacex.rocket.RocketJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LaunchJson {

	private Integer flight_number;
	
	private String mission_name;

	private Integer launch_year;

	private RocketJson rocket;

	private LinksJson links;

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

	public RocketJson getRocket() {
		return rocket;
	}

	public void setRocket(RocketJson rocket) {
		this.rocket = rocket;
	}

	public LinksJson getLinks() {
		return links;
	}

	public void setLinks(LinksJson links) {
		this.links = links;
	}
}
