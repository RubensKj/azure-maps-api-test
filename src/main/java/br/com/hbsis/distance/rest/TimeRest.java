package br.com.hbsis.distance.rest;

import br.com.hbsis.distance.services.TimeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TimeRest {

    private final TimeService timeService;

    public TimeRest(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/time")
    public LocalDateTime getTime() {
        return this.timeService.getLocalDateTimeNow();
    }

}
