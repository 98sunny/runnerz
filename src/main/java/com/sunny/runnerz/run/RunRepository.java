package com.sunny.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs=new ArrayList<>();


    List<Run> findAll(){
        System.out.println("Value of runs:"+runs);
        return runs;
    }

//   A container object which may or may not contain a non-null value. If a value is present, isPresent() returns true.
//   If no value is present, the object is considered empty and isPresent() returns false.
    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    //    PostConstruct does some initialization work before the instance is ready to be used.
    @PostConstruct
    public void init() {
        runs.add(new Run(1, "Run 1", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 100, Location.outdoor));
        runs.add(new Run(2, "Run 2", LocalDateTime.now(), LocalDateTime.now().plusDays(1), 100, Location.indoor));
    }

}
