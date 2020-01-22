package br.com.hbsis.distance.payloads.apiintegration;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
public class ResponseSearch {

    private Set<Result> results;
}
