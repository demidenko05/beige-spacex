package org.beigesoft.beigespacex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:spacex.properties")
public class BeigeSpacexApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeigeSpacexApplication.class, args);
	}
}
