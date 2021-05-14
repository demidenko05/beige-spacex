package org.beigesoft.beigespacex.rocket;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.validation.constraints.NotEmpty;

import org.beigesoft.beigespacex.launche.Launch;

@Entity
public class Rocket {
	
	@Id
	private String iid;

	//@NotEmpty
	private String nme;

	@OneToMany
	private List<Launch> launches;

	public Rocket() {
	}

	public Rocket(String iid) {
		this.iid = iid;
	}

	public Rocket(RocketJson pSrc) {
		this.iid = pSrc.getRocket_id();
		this.setNme(pSrc.getRocket_name());
	}

	public List<Launch> getLaunches() {
		return launches;
	}

	public void setLaunches(List<Launch> launches) {
		this.launches = launches;
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
