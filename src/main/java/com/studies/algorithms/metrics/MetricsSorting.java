package com.studies.algorithms.metrics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class MetricsSorting {

    private final String[] header = {"algorithm", "10", "100", "1000", "10000", "100000", "1000000"};
    private Map<String, List<Long>> metricTimes;
    private Map<String, List<Long>> metricExchanges;

    public List<String[]> getMetricTimeData() {
        List<String[]> result = new ArrayList<>();
        result.add(header);

        for (String key : this.metricTimes.keySet()) {
            List<String> line = new ArrayList<>();
            line.add(key);
            line.addAll(handleLongListToStringList(this.metricTimes.get(key)));

            result.add(line.toArray(new String[0]));
        }
        return result;
    }

    public List<String[]> getMetricExchangesData() {
        List<String[]> result = new ArrayList<>();
        result.add(header);

        for (String key : this.metricExchanges.keySet()) {
            List<String> line = new ArrayList<>();
            line.add(key);
            line.addAll(handleLongListToStringList(this.metricExchanges.get(key)));

            result.add(line.toArray(new String[0]));
        }
        return result;
    }

    private List<String> handleLongListToStringList(List<Long> list) {
        return list.stream().map(Object::toString).toList();
    }

}
