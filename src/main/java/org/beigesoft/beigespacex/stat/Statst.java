package org.beigesoft.beigespacex.stat;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Statst {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iid;

	private Date dat;

	@NotEmpty
	private String reqUri;

	@Lob
	@NotEmpty
	private String reqBod;

	public Statst() {
		
	}

	public Statst(Date dat, @NotEmpty String reqUri, @NotEmpty String reqBod) {
		this.dat = dat;
		this.reqUri = reqUri;
		this.reqBod = reqBod;
	}

	public Date getDat() {
		return dat;
	}

	public void setDat(Date dat) {
		this.dat = dat;
	}

	public Long getIid() {
		return iid;
	}

	public void setIid(Long iid) {
		this.iid = iid;
	}

	public String getReqUri() {
		return reqUri;
	}

	public void setReqUri(String reqUri) {
		this.reqUri = reqUri;
	}

	public String getReqBod() {
		return reqBod;
	}

	public void setReqBod(String reqBod) {
		this.reqBod = reqBod;
	}
}
