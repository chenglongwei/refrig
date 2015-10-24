package com.longyi.dist.bsserver.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by chenglongwei on 10/23/15.
 */
public class Bootstrap {
    @Id
    private String id;
    private String ep;
    private ClientInfo clientInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEp() {
        return ep;
    }

    public void setEp(String ep) {
        this.ep = ep;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public Refrig toRefrig() {
        Refrig refrig = new Refrig();
        refrig.setEndpointClientName(ep);

        Oid_0 oid_0 = new Oid_0();
        oid_0.setRid_0(clientInfo.getReguri());
        refrig.setOid_0(oid_0);

        Oid_3 oid_3 = new Oid_3();
        oid_3.setRid_0(clientInfo.getManufacture());
        oid_3.setRid_1(clientInfo.getModelNumber());
        oid_3.setRid_2(clientInfo.getSerialNumber());
        oid_3.setRid_3(clientInfo.getFirmwareVersion());

        refrig.setOid_3(oid_3);

        return refrig;
    }
}

class ClientInfo {
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getReguri() {
        return reguri;
    }

    public void setReguri(String reguri) {
        this.reguri = reguri;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    private String manufacture;
    private String reguri;
    private String firmwareVersion;
    private String modelNumber;
    private String serialNumber;
}
