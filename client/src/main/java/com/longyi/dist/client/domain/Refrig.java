package com.longyi.dist.client.domain;

import org.springframework.data.annotation.Id;


/**
 * Created by chenglongwei on 10/23/15.
 */
public class Refrig {
    @Id
    private String id;
    private String endpointClientName;
    private Oid_0 oid_0;
    private Oid_2 oid_2;
    private Oid_3 oid_3;
    private Oid_4 oid_4;
    private Oid_5 oid_5;

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

    public Oid_0 getOid_0() {
        return oid_0;
    }

    public void setOid_0(Oid_0 oid_0) {
        this.oid_0 = oid_0;
    }

    public Oid_2 getOid_2() {
        return oid_2;
    }

    public void setOid_2(Oid_2 oid_2) {
        this.oid_2 = oid_2;
    }

    public Oid_3 getOid_3() {
        return oid_3;
    }

    public void setOid_3(Oid_3 oid_3) {
        this.oid_3 = oid_3;
    }


    public Oid_4 getOid_4() {
        return oid_4;
    }

    public void setOid_4(Oid_4 oid_4) {
        this.oid_4 = oid_4;
    }

    public Oid_5 getOid_5() {
        return oid_5;
    }

    public void setOid_5(Oid_5 oid_5) {
        this.oid_5 = oid_5;
    }
}

