package com.sunny.runnerz.run;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class RunController {
    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository=runRepository;
    }
    @GetMapping("/hello")
    String home(){
        return "Hello Runnerz!!";
    }

    @GetMapping("/api/runs")
    List<Run> findAll() {
        System.out.println(runRepository.findAll());
        return runRepository.findAll();
    }
    @GetMapping("/api/runs/{id}")
    Optional<Run> findById(@PathVariable int id) {

        Optional<Run> runById= runRepository.findById(id);
        if(!runById.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found");
        }
        return Optional.of(runById.get());
    }
}
