package br.com.hbsis.distance.rest;

import br.com.hbsis.distance.payloads.UF;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UfRest {

    @GetMapping("/uf")
    public List<UF> getAllUfs() {
        return Arrays.asList(UF.values());
    }
}
