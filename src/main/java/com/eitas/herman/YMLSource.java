package com.eitas.herman;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ramesh on 5/19/18.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "text")
public class YMLSource {

    private String name;

    private String match;

    public String getName() {
        return name;
    }

    public String getMatch() {
        return match;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMatch(String match) {
        this.match = match;
    }
}
