package org.beigesoft.beigespacex.rocket;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.validation.constraints.NotEmpty;

@Entity
public class Rocket {
	
	@Id
	private String iid;

	//@NotEmpty
	private String nme;

	public Rocket() {
	}

	public Rocket(String iid) {
		this.iid = iid;
	}

	public Rocket(RocketJson pSrc) {
		this.iid = pSrc.getRocket_id();
		this.setNme(pSrc.getRocket_name());
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
