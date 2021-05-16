package org.beigesoft.beigespacex.launche;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/*
 It seems to be bidirectional many-to-many (https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#associations-many-to-many):

select launch_flight_number, flic_imgs_pth from
(select flic_imgs_pth as pth, count(launch_flight_number) as cnt  from launch_flic_imgs group by flic_imgs_pth having count(launch_flight_number) > 1) as sharedpics
join launch_flic_imgs  on launch_flic_imgs.flic_imgs_pth = sharedpics.pth
order by flic_imgs_pth;

launch_flight_number  	flic_imgs_pth  
43	https://farm5.staticflickr.com/4162/34868729603_c75aa126b5_o.jpg
44	https://farm5.staticflickr.com/4162/34868729603_c75aa126b5_o.jpg
93	https://live.staticflickr.com/65535/49672551303_564ce21658_o.jpg
92	https://live.staticflickr.com/65535/49672551303_564ce21658_o.jpg
93	https://live.staticflickr.com/65535/49672551378_fabc17ef6f_o.jpg
92	https://live.staticflickr.com/65535/49672551378_fabc17ef6f_o.jpg
92	https://live.staticflickr.com/65535/49673373182_93a517e140_o.jpg
93	https://live.staticflickr.com/65535/49673373182_93a517e140_o.jpg
*/

@Entity
public class FlirckrImg {

	@Id
	private String pth;

	@ManyToMany(mappedBy = "links.flicImgs")
	private List<Launch> launchs  = new ArrayList<>(); 

	public FlirckrImg() {
	}

	public FlirckrImg(String pth) {
		this.pth = pth;
	}

	public String getPth() {
		return pth;
	}

	public void setPth(String pth) {
		this.pth = pth;
	}

	public List<Launch> getLaunchs() {
		return launchs;
	}

	public void setLaunchs(List<Launch> launchs) {
		this.launchs = launchs;
	}
}
