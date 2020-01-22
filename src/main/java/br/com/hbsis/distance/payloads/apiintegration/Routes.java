package br.com.hbsis.distance.payloads.apiintegration;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor
@Getter
public class Routes implements Comparator<Routes> {

    private Summary summary;

    @Override
    public int compare(Routes o1, Routes o2) {
        return Integer.compare(o1.getSummary().getLengthInMeters(), o2.getSummary().getLengthInMeters());
    }
}
