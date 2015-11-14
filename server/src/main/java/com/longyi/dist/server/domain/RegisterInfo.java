package com.longyi.dist.server.domain;

import org.springframework.data.annotation.Id;


/**
 * Created by chenglongwei on 10/23/15.
 */
public class RegisterInfo {
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

class Oid_0 {
    private String rid_0;

    public String getRid_0() {
        return rid_0;
    }

    public void setRid_0(String rid_0) {
        this.rid_0 = rid_0;
    }
}

class Oid_2 {
    private String rid_0;

    public String getRid_0() {
        return rid_0;
    }

    public void setRid_0(String rid_0) {
        this.rid_0 = rid_0;
    }
}

class Oid_3 {
    private String rid_0;
    private String rid_1;
    private String rid_2;
    private String rid_3;

    public String getRid_0() {
        return rid_0;
    }

    public void setRid_0(String rid_0) {
        this.rid_0 = rid_0;
    }

    public String getRid_1() {
        return rid_1;
    }

    public void setRid_1(String rid_1) {
        this.rid_1 = rid_1;
    }

    public String getRid_2() {
        return rid_2;
    }

    public void setRid_2(String rid_2) {
        this.rid_2 = rid_2;
    }

    public String getRid_3() {
        return rid_3;
    }

    public void setRid_3(String rid_3) {
        this.rid_3 = rid_3;
    }
}

class Oid_4 {
    private String rid_0;

    public String getRid_0() {
        return rid_0;
    }

    public void setRid_0(String rid_0) {
        this.rid_0 = rid_0;
    }
}

class Oid_5 {
    private String rid_0;

    public String getRid_0() {
        return rid_0;
    }

    public void setRid_0(String rid_0) {
        this.rid_0 = rid_0;
    }
}