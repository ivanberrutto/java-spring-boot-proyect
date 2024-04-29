package dev.ivanberrutto.runnerz.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunController {

    @GetMapping("/Hello")
    String home(){
        return "hello fitters";

    }
}
