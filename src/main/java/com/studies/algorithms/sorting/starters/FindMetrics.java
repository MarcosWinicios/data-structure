package com.studies.algorithms.sorting.starters;

import com.studies.algorithms.sorting.model.Result;
import com.studies.algorithms.sorting.service.MetricService;
import com.studies.algorithms.sorting.service.ResultService;
import com.studies.config.ConnectionDatabase;

import java.util.List;

public class FindMetrics {

    public static void main(String[] args) {
        ConnectionDatabase.getInstance();

        String groupId = "2cb9a8f1-4c65-41d7-8a1a-46f2ff425350";

        ResultService service = new ResultService();

        List<Result> metrics =  service.findByGroupId(groupId);

        MetricService metricService = new MetricService();
        metricService.generateFile(metrics);
    }
}
