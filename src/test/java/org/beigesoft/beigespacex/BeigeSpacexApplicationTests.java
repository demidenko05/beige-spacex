package org.beigesoft.beigespacex;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.beigesoft.beigespacex.launche.FlirckImgRepo;
import org.beigesoft.beigespacex.launche.FlirckrImg;
import org.beigesoft.beigespacex.launche.Launch;
import org.beigesoft.beigespacex.launche.LaunchRepository;
import org.beigesoft.beigespacex.launche.Links;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeigeSpacexApplicationTests {

	@Autowired
	private LaunchRepository launRepo;

	@Autowired
	private FlirckImgRepo fimgRepo;

	@Test
	void testSharedMany() {
		Launch laun1 = new Launch();
		laun1.setFlight_number(9999991);
		laun1.setLinks(new Links());
		FlirckrImg imgShr = new FlirckrImg("Image shared");
		FlirckrImg imgl1 = new FlirckrImg("Image laun1");
		laun1.addFlirckImg(imgShr);
		laun1.addFlirckImg(imgl1);
		launRepo.save(laun1);
		Launch laun2 = new Launch();
		laun2.setFlight_number(9999992);
		laun2.setLinks(new Links());
		FlirckrImg imgl2 = new FlirckrImg("Image laun2");
		laun2.addFlirckImg(imgShr);
		laun2.addFlirckImg(imgl2);
		launRepo.save(laun2);
		laun1.clearFlirckImgs();
		launRepo.delete(laun1);
		List<FlirckrImg> fimgs = fimgRepo.findAbandoned();
		assertThat(fimgs).hasSize(1);
		launRepo.delete(laun2);
		fimgs = fimgRepo.findAbandoned();
		assertThat(fimgs).hasSize(3);
		for (FlirckrImg fimg : fimgs) {
			fimgRepo.delete(fimg);
		}
	}

}
