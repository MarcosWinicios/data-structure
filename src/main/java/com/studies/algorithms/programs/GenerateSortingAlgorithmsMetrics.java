package com.studies.algorithms.programs;

import com.studies.algorithms.metrics.ResultSorting;
import com.studies.algorithms.repository.SortingRepository;
import com.studies.algorithms.service.SortingService;
import com.studies.config.ConnectionDatabase;

import java.util.List;

public class GenerateSortingAlgorithmsMetrics {

    public static void main(String[] args) {
        ConnectionDatabase.getInstance();

        String groupId = "2197d215-020c-486d-88d8-1d88f1d65844";

        SortingRepository repository = new SortingRepository();

        List<ResultSorting> metrics =  repository.findByGroupId(groupId);

        SortingService metricService = new SortingService();
        metricService.generateFile(metrics);
    }
}
