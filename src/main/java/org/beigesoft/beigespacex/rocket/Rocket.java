package org.beigesoft.beigespacex.rocket;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rocket {

	@Id
	private String iid;

	//@NotEmpty
	private String nme;

	public Rocket() {
	}

	public Rocket(String rocket_id) {
		this.iid = rocket_id;
	}

	public Rocket(String rocket_id, String rocket_name) {
		this.iid = rocket_id;
		this.nme = rocket_name;
	}

	public String getIid() {
		return iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getNme() {
		return nme;
	}

	public void setNme(String nme) {
		this.nme = nme;
	}
}
