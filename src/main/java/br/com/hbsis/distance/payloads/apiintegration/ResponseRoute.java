package br.com.hbsis.distance.payloads.apiintegration;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ResponseRoute {

    private List<Routes> routes;
}
