package com.longyi.dist.client.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by chenglongwei on 11/14/15.
 * Used by the server to execution command to control temperature and bacteria.
 */
public class Command {
    @Id
    private String id;
    private String temperature;
    private String bacteria;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getBacteria() {
        return bacteria;
    }

    public void setBacteria(String bacteria) {
        this.bacteria = bacteria;
    }
}
