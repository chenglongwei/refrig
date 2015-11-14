package com.longyi.dist.server.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by chenglongwei on 11/14/15.
 */
public class Attributes {
    @Id
    private String id;
    private Attribute temperature;
    private Attribute bacteria;

    public Attribute getTemperature() {
        return temperature;
    }

    public void setTemperature(Attribute temperature) {
        this.temperature = temperature;
    }

    public Attribute getBacteria() {
        return bacteria;
    }

    public void setBacteria(Attribute bacteria) {
        this.bacteria = bacteria;
    }
}
