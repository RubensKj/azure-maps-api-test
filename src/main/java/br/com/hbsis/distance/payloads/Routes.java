package br.com.hbsis.distance.payloads;

import java.util.Comparator;

public class Routes implements Comparator<Routes> {

    private Summary summary;

    public Routes() {
    }

    public Summary getSummary() {
        return summary;
    }

    @Override
    public int compare(Routes o1, Routes o2) {
        return Integer.compare(o1.getSummary().getLengthInMeters(), o2.getSummary().getLengthInMeters());
    }
}
