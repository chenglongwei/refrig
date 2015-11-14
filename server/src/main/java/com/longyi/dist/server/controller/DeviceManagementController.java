package com.longyi.dist.server.controller;

import com.google.gson.Gson;
import com.longyi.dist.server.Util.HttpUtil;
import com.longyi.dist.server.domain.*;
import com.longyi.dist.server.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenglongwei on 11/14/15.
 */
@RestController
@RequestMapping("api/do/dm")
public class DeviceManagementController {
    public static final String CLIENT_URL_PREFIX = "http://localhost:8080/client-1.0/api/dm/";
    @Autowired
    private RegisterRepository registerRepository;

    @RequestMapping(value = "read/4/0", method = RequestMethod.GET)
    public Temperature readTemperature() {
        String res = HttpUtil.httpGet(CLIENT_URL_PREFIX + "read/4/0");
        return new Gson().fromJson(res, Temperature.class);
    }

    @RequestMapping(value = "read/5/0", method = RequestMethod.GET)
    public Bacteria readBacteria() {
        String res = HttpUtil.httpGet(CLIENT_URL_PREFIX + "read/5/0");
        return new Gson().fromJson(res, Bacteria.class);
    }

    @RequestMapping(value = "discover/3", method = RequestMethod.GET)
    public String discover() {
        return HttpUtil.httpGet(CLIENT_URL_PREFIX + "discover/3");
    }

    @RequestMapping(value = "write/3/3", method = RequestMethod.GET)
    public RegisterInfo writeVersion(@RequestParam(value = "newValue") String newValue) {
        String res = HttpUtil.httpPut(CLIENT_URL_PREFIX + "write/3/3", newValue);
        RegisterInfo update = new Gson().fromJson(res, RegisterInfo.class);
        RegisterInfo legacy = registerRepository.findByEndpointClientName(update.getEndpointClientName());
        registerRepository.delete(legacy);
        registerRepository.save(update);
        return update;
    }

    @RequestMapping(value = "write/attributes/4", method = RequestMethod.GET)
    public Attributes writeTempAttributes(
            @RequestParam(value = "minimumPeriod") long minimumPeriod,
            @RequestParam(value = "maximumPeriod") long maximumPeriod,
            @RequestParam(value = "greaterThan") int greaterThan,
            @RequestParam(value = "cancel") boolean cancel) {

        Attribute attribute = new Attribute();
        attribute.setMinimumPeriod(minimumPeriod);
        attribute.setMaximumPeriod(maximumPeriod);
        attribute.setGreaterThan(greaterThan);
        attribute.setCancel(cancel);

        String res = HttpUtil.httpPost(CLIENT_URL_PREFIX + "write/attributes/4", attribute);
        return new Gson().fromJson(res, Attributes.class);
    }

    @RequestMapping(value = "write/attributes/5", method = RequestMethod.GET)
    public Attributes writeBacteriaAttributes(
            @RequestParam(value = "minimumPeriod") long minimumPeriod,
            @RequestParam(value = "maximumPeriod") long maximumPeriod,
            @RequestParam(value = "greaterThan") int greaterThan,
            @RequestParam(value = "cancel") boolean cancel) {

        Attribute attribute = new Attribute();
        attribute.setMinimumPeriod(minimumPeriod);
        attribute.setMaximumPeriod(maximumPeriod);
        attribute.setGreaterThan(greaterThan);
        attribute.setCancel(cancel);

        String res = HttpUtil.httpPost(CLIENT_URL_PREFIX + "write/attributes/5", attribute);
        return new Gson().fromJson(res, Attributes.class);
    }

    @RequestMapping(value = "execute/command/4", method = RequestMethod.GET)
    public Command setTemperature(@RequestParam(value = "newValue") String newValue) {
        String res = HttpUtil.httpGet(CLIENT_URL_PREFIX + "execute/command/4?newValue=" + newValue);
        return new Gson().fromJson(res, Command.class);
    }

    @RequestMapping(value = "execute/command/5", method = RequestMethod.GET)
    public Command setBacteria(@RequestParam(value = "newValue") String newValue) {
        String res = HttpUtil.httpGet(CLIENT_URL_PREFIX + "execute/command/5?newValue=" + newValue);
        return new Gson().fromJson(res, Command.class);
    }

    @RequestMapping(value = "create/2/0", method = RequestMethod.GET)
    public RegisterInfo createAccessOwner(@RequestParam(value = "newValue") String newValue) {
        String res = HttpUtil.httpPost(CLIENT_URL_PREFIX + "create/2/0", newValue);
        RegisterInfo update = new Gson().fromJson(res, RegisterInfo.class);
        RegisterInfo legacy = registerRepository.findByEndpointClientName(update.getEndpointClientName());
        registerRepository.delete(legacy);
        registerRepository.save(update);
        return update;
    }

    @RequestMapping(value = "delete/2/0", method = RequestMethod.GET)
    public RegisterInfo deleteAccessOwner() {
        String res = HttpUtil.httpDelete(CLIENT_URL_PREFIX + "delete/2/0");
        RegisterInfo update = new Gson().fromJson(res, RegisterInfo.class);
        RegisterInfo legacy = registerRepository.findByEndpointClientName(update.getEndpointClientName());
        registerRepository.delete(legacy);
        registerRepository.save(update);
        return update;
    }
}
