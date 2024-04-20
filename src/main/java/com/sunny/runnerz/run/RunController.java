package com.sunny.runnerz.run;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository=runRepository;
    }
    @GetMapping("/hello")
    String home(){
        return "Hello Runnerz!!";
    }

    @GetMapping("")
    List<Run> findAll() {
        System.out.println(runRepository.findAll());
        return runRepository.findAll();
    }
    @GetMapping("/{id}")
    Optional<Run> findById(@PathVariable int id) {

        Optional<Run> runById= runRepository.findById(id);
        if(!runById.isPresent()){
            throw new RunNotFoundException();
        }
        return Optional.of(runById.get());
    }
//post method
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@Valid @RequestBody Run run) {
        runRepository.create(run);
    }

//    //update method
//    @PutMapping("/update/{id}")
//    void update(@RequestBody Run run, @PathVariable int id){
//        runRepository.update(run, id);
//    }
//    //delete method
//    @DeleteMapping("/delete/{id}")
//    void delete(@PathVariable int id) {
//        runRepository.delete(id);
//    }
}

