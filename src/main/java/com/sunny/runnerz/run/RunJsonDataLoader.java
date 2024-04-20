package com.sunny.runnerz.run;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
@Component
public class RunJsonDataLoader implements CommandLineRunner {
    RunRepository runRepository;
    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);
    private final ObjectMapper objectMapper;//neded to convert json to object and vice versa, deserialie to Run object.
    public RunJsonDataLoader(RunRepository runRepository, ObjectMapper objectMapper) {
        this.runRepository = runRepository;
        this.objectMapper = objectMapper;
    }
    @Override
    public void run(String... args) throws Exception {
        log.info("Preloading " + runRepository.count() + " runs");
        if(runRepository.count() == 1) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
                System.out.println("Inisde run function");
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                System.out.println("All runs values:"+ allRuns.runs());
                log.info("Reading {} runs from JSON data and saving to in-memory collection.", allRuns.runs().size());
                runRepository.saveAll(allRuns.runs());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not loading Runs from JSON data because the collection contains data.");
        }
    }
}