package pl.wiesiek.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class Lab6EurekaDiscovery {

	public static void main(String[] args) {
		SpringApplication.run(Lab6EurekaDiscovery.class, args);
	}

}


