package com.rev.etl.faker.configurations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class ServiceConfiguration extends Configuration {

    @JsonProperty
    private String application_name;

    public String getApplication_name() {
        return application_name;
    }

    public void setApplication_name(String application_name) {
        this.application_name = application_name;
    }

    public ServiceConfiguration(String application_name) {
        this.application_name = application_name;
    }

    public ServiceConfiguration() {
    }
}
