package com.sunny.runnerz;

import com.sunny.runnerz.run.Location;
import com.sunny.runnerz.run.Run;
import com.sunny.runnerz.run.RunRepository;
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


//	this function runs when the application starts. @Bean is a spring annotation which is used to create beans.
//	@Bean
//	CommandLineRunner runner(RunRepository runRepository) {
//		return args -> {
//			Run run=new Run(2, "Run in the evening", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 100, Location.outdoor);
//			runRepository.create(run);
//
//			log.info("Run:"+run);
//		};
//	}

}
