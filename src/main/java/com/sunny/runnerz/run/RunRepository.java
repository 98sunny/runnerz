package com.sunny.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private static final Logger logger = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;
    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("select * from run")
//                above query is run and return list of Run objects which is mapped to the Run class into the list.
                .query(Run.class)
                .list();
    }
    public Optional<Run> findById(int id){
        System.out.println("id is" + id);
        System.out.println(
        jdbcClient.sql("select * from Run where id=:id")
//                this is how we pass the parameter to the query.
                .param("id",id)
//                query is run and return optional object of the Run class.
                .query(Run.class)
//                returns the optional object of the Run class.
                .optional()

        );
        return jdbcClient.sql("select * from Run where id=:id")
//                this is how we pass the parameter to the query.
                .param("id",id)
//                query is run and return optional object of the Run class.
                .query(Run.class)
//                returns the optional object of the Run class.
                .optional();

    }
    public void create(Run run) {
        var updated=jdbcClient.sql("insert into Run (id, title, started_on, completed_on, miles, location) values (?,?,?,?,?,?)")
                .params(List.of(run.id(), run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location().toString()))
                .update();
        Assert.state(updated == 1, "Failed to insert run" + run.title());
//                (updated=1,"Failed to insert run"+run.title());
    }
    public void delete(int id) {
        var updated = jdbcClient.sql("delete from Run where id=:id")
                .params("id",id)
                .update();
        Assert.state(updated == 1, "Failed to delete run with id" + id);
//                (updated=1,"Failed to delete run with id"+id);
    }
    public int count(){
        return jdbcClient.sql("select count(*) from Run")
                .query()
                .listOfRows().size();
    }
    public void saveAll(List<Run> runs){
        runs.stream().forEach(this::create);
    }

    public List<Run> findByLocation(Location location) {
        return jdbcClient.sql("select * from Run where location=:location")
                .param("location", location)
                .query(Run.class)
                .list();
    }



}
