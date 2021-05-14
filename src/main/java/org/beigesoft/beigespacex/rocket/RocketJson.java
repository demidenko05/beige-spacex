package org.beigesoft.beigespacex.rocket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RocketJson {

	private String rocket_id;

	private String rocket_name;

	@Override
	public String toString() {
		return "Rocket{" +
				"ID='" + this.rocket_id + '\'' +
				", Name=" + this.rocket_name +
				'}';
	}

	public String getRocket_id() {
		return rocket_id;
	}

	public void setRocket_id(String rocket_id) {
		this.rocket_id = rocket_id;
	}

	public String getRocket_name() {
		return rocket_name;
	}

	public void setRocket_name(String rocket_name) {
		this.rocket_name = rocket_name;
	}
}
