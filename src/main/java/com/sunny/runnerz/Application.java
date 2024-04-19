package com.sunny.runnerz;

import com.sunny.runnerz.run.Location;
import com.sunny.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {
	private static final Logger log= LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {


		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run=new Run(1, "Run 1", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 100, Location.outdoor);

			log.info("Run:"+run);
		};
	}

}
