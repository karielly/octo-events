package com.octoevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class OctoEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OctoEventsApplication.class, args);
	}

}

