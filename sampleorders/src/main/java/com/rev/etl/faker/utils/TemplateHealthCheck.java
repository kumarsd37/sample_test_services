package com.rev.etl.faker.utils;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
    private final static String saying = "TEST";

    @Override
    protected Result check() throws Exception {

        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}