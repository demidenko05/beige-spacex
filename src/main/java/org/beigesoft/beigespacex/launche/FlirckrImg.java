package org.beigesoft.beigespacex.launche;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FlirckrImg {

	@Id
	private String pth;

	public String getPth() {
		return pth;
	}

	public FlirckrImg(String pth) {
		this.pth = pth;
	}

	public void setPth(String pth) {
		this.pth = pth;
	}

	public FlirckrImg() {
	}

}
