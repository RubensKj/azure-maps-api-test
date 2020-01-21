package br.com.hbsis.distance.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TimeService {

    public LocalDateTime getLocalDateTimeNow() {
        return LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }
}
