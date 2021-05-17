package org.beigesoft.beigespacex.launche;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FlirckImgRepo extends CrudRepository<FlirckrImg, String> {

	@Query(value = "select fimg from FlirckrImg as fimg where fimg.launchs is empty")
	List<FlirckrImg> findAbandoned();
}
