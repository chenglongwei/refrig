package com.longyi.dist.server.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by chenglongwei on 11/14/15.
 */
public class Bacteria {
    @Id
    private String id;
    private String endpointClientName;
    private int bacteria;
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

    public int getBacteria() {
        return bacteria;
    }

    public void setBacteria(int bacteria) {
        this.bacteria = bacteria;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
