package com.longyi.dist.client.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by chenglongwei on 10/26/15.
 */
public class Temperature {
    @Id
    private String id;
    private String endpointClientName;
    private int temperature;
    private long timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndpointClientName() {
        return endpointClientName;
    }

    public void setEndpointClientName(String endpointClientName) {
        this.endpointClientName = endpointClientName;
    }

    public int getTemperatrue() {
        return temperature;
    }

    public void setTemperatrue(int temperature) {
        this.temperature = temperature;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
