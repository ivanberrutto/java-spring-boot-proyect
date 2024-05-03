package dev.ivanberrutto.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dev.ivanberrutto.runnerz.run.Location.INDOOR;


@Repository
public class RunRepository {
    private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("select * from run")
                .query(Run.class)
                .list();
    }

    /*
    private List<Run> runs = new ArrayList<>();

    Optional<Run> findById(int id) {
        return runs.stream().filter(run -> run.id()==id).findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }
    void update(@RequestBody Run run, Integer id) {
        Optional <Run> existingRun = findById(id);
        existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id()==id);
    }

    List<Run> findAll(){
        return runs;
    }
    @PostConstruct
    public void init(){
        Run examplerun = new Run(1,
            "A Round in the Apple",
            LocalDateTime.now(),
            LocalDateTime.now().plusHours(1),
            2,
            INDOOR);

        runs.add(examplerun);

    }

     */
}
