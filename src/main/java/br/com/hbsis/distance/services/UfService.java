package br.com.hbsis.distance.services;

import br.com.hbsis.distance.payloads.UF;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UfService {

    public List<UF> getAllUfs() {
        return Arrays.asList(UF.values());
    }
}
