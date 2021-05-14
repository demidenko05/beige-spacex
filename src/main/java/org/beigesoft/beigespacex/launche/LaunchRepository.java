package org.beigesoft.beigespacex.launche;

import java.util.List;

import org.beigesoft.beigespacex.rocket.Rocket;
import org.springframework.data.repository.CrudRepository;

public interface LaunchRepository extends CrudRepository<Launch, Integer> {

	List<Launch> findByRocket(Rocket pRkt);
}
