package br.com.hbsis.distance.rest;

import br.com.hbsis.distance.payloads.UF;
import br.com.hbsis.distance.services.UfService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UfRest {

    private final UfService ufService;

    public UfRest(UfService ufService) {
        this.ufService = ufService;
    }

    @GetMapping("/uf")
    public List<UF> getAllUfs() {
        return this.ufService.getAllUfs();
    }
}
