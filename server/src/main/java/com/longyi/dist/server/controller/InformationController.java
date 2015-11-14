package com.longyi.dist.server.controller;

import com.google.gson.Gson;
import com.longyi.dist.server.Util.HttpUtil;
import com.longyi.dist.server.domain.Attributes;
import com.longyi.dist.server.domain.Bacteria;
import com.longyi.dist.server.domain.Temperature;
import com.longyi.dist.server.repository.BacteriaRepository;
import com.longyi.dist.server.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chenglongwei on 10/26/15.
 */
@RestController
@RequestMapping("api/info")
public class InformationController {
    public static final String CLIENT_URL_PREFIX = "http://localhost:8080/client-1.0/api/report/";
    @Autowired
    private TemperatureRepository temperatureRepository;
    @Autowired
    private BacteriaRepository bacteriaRepository;

    @RequestMapping(value = "temperature", method = RequestMethod.POST)
    public List<Temperature> temperature(@RequestBody Temperature temperature) {
        temperatureRepository.save(temperature);
        List<Temperature> list = temperatureRepository.findAll();
        if (list.size() <= 3) {
            return list;
        }
        return list.subList(list.size() - 3, list.size());
    }

    @RequestMapping(value = "bacteria", method = RequestMethod.POST)
    public List<Bacteria> bacteria(@RequestBody Bacteria bacteria) {
        bacteriaRepository.save(bacteria);
        List<Bacteria> list = bacteriaRepository.findAll();
        if (list.size() <= 3) {
            return list;
        }
        return list.subList(list.size() - 3, list.size());
    }

    @RequestMapping(value = "observe/4", method = RequestMethod.GET)
    public Attributes observeTemperature() {
        String res = HttpUtil.httpGet(CLIENT_URL_PREFIX + "observe/4");
        return new Gson().fromJson(res, Attributes.class);
    }

    @RequestMapping(value = "observe/5", method = RequestMethod.GET)
    public Attributes observerBacteria() {
        String res = HttpUtil.httpGet(CLIENT_URL_PREFIX + "observe/5");
        return new Gson().fromJson(res, Attributes.class);
    }

    @RequestMapping(value = "cancel/observe/4", method = RequestMethod.GET)
    public Attributes cancelObserverTemperature() {
        String res = HttpUtil.httpGet(CLIENT_URL_PREFIX + "cancel/observe/4");
        return new Gson().fromJson(res, Attributes.class);
    }

    @RequestMapping(value = "cancel/observe/5", method = RequestMethod.GET)
    public Attributes cancelObserverBacteria() {
        String res = HttpUtil.httpGet(CLIENT_URL_PREFIX + "cancel/observe/5");
        return new Gson().fromJson(res, Attributes.class);
    }
}
