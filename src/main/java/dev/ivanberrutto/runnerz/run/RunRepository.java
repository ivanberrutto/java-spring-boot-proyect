package dev.ivanberrutto.runnerz.run;

import jakarta.annotation.PostConstruct;
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
}
