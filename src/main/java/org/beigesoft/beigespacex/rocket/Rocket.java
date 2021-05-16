package org.beigesoft.beigespacex.rocket;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Rocket {

	@Id
	private String rocket_id;

	//@NotEmpty
	private String rocket_name;

	public Rocket() {
	}

	public Rocket(String rocket_id) {
		this.rocket_id = rocket_id;
	}

	public Rocket(String rocket_id, String rocket_name) {
		this.rocket_id = rocket_id;
		this.rocket_name = rocket_name;
	}

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
