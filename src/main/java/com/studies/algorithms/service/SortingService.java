package com.studies.algorithms.service;

import com.studies.algorithms.metrics.MetricsSorting;
import com.studies.algorithms.metrics.ResultSorting;
import com.studies.utils.CsvUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingService {

    public void generateFile(List<ResultSorting> resultList){
        MetricsSorting metric =  handleResultListToMetricsMaps(resultList);

        List<String[]> timeData = metric.getMetricTimeData();
        List<String[]> exchanges = metric.getMetricExchangesData();

        CsvUtils.generateCsvFile(timeData, "sorting-algorithms-time");
        CsvUtils.generateCsvFile(exchanges, "sorting-algorithms-exchanges");
    }


    public MetricsSorting handleResultListToMetricsMaps(List<ResultSorting> metrics) {
        long arraySize = 10L;
        Map<String, List<Long>> metricsTime = new HashMap<>();
        Map<String, List<Long>> metricsExchanges = new HashMap<>();

        while (arraySize <= 10000000){
            long finalArraySize = arraySize;
            metrics.stream()
                    .filter(result -> result.getArraySize() == finalArraySize)
                    .toList()
                    .forEach(item -> {
                        String algorithmName = item.getAlgorithmName();

                        List<Long> exchangeList = metricsExchanges.get(algorithmName);
                        if(exchangeList == null){
                            exchangeList = new ArrayList<>();
                        }
                        exchangeList.add(item.getExchanges());
                        metricsExchanges.put(algorithmName, exchangeList);

                        List<Long> timeList = metricsTime.get(algorithmName);
                        if(timeList == null){
                            timeList = new ArrayList<>();
                        }
                        timeList.add(item.getTime());
                        metricsTime.put(algorithmName, timeList);
                    });
            arraySize = arraySize * 10;
        }
        return new MetricsSorting(metricsTime, metricsExchanges);
    }
}
