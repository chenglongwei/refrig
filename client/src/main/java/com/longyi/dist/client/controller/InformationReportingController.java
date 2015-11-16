package com.longyi.dist.client.controller;

import com.longyi.dist.client.Util.HttpUtil;
import com.longyi.dist.client.domain.*;
import com.longyi.dist.client.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadFactory;

/**
 * Created by chenglongwei on 10/26/15.
 */
@RestController
@RequestMapping("api/report")
public class InformationReportingController {
    @Autowired
    private TemperatureRepository temperatureRepository;
    @Autowired
    private BacteriaRepository bacteriaRepository;
    @Autowired
    private AttributesRepository attributesRepository;

    @RequestMapping(value = "start", method = RequestMethod.GET)
    public void startWorking() {
        int count = 0;
        while (true) {
            count++;

            Temperature temperature = new Temperature();
            temperature.setEndpointClientName(BootstrapController.ep);
            temperature.setTemperature(new Random().nextInt(100));
            temperature.setTimestamp(System.currentTimeMillis());
            if (needsNotify(temperature)) {
                HttpUtil.httpSendData("http://localhost:8080/server-1.0/api/info/temperature", temperature);
            }
            temperatureRepository.save(temperature);

            Bacteria bacteria = new Bacteria();
            bacteria.setEndpointClientName(BootstrapController.ep);
            bacteria.setBacteria(new Random().nextInt(100));
            bacteria.setTimestamp(System.currentTimeMillis());
            if (needsNotify(bacteria)) {
                HttpUtil.httpSendData("http://localhost:8080/server-1.0/api/info/bacteria", bacteria);
            }
            bacteriaRepository.save(bacteria);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 10) {
                break;
            }
        }
    }

    @RequestMapping(value = "observe/4", method = RequestMethod.GET)
    public Attributes observeTemperature() {
        List<Attributes> list = attributesRepository.findAll();
        if (list != null && list.size() >= 1) {
            Attributes attributes = list.get(0);
            attributes.getTemperature().setCancel(false);
            return attributesRepository.save(attributes);
        }

        return null;
    }

    @RequestMapping(value = "observe/5", method = RequestMethod.GET)
    public Attributes observeBacteria() {
        List<Attributes> list = attributesRepository.findAll();
        if (list != null && list.size() >= 1) {
            Attributes attributes = list.get(0);
            attributes.getBacteria().setCancel(false);
            return attributesRepository.save(attributes);
        }

        return null;
    }

    @RequestMapping(value = "cancel/observe/4", method = RequestMethod.GET)
    public Attributes cancelObserveTemperature() {
        List<Attributes> list = attributesRepository.findAll();
        if (list != null && list.size() >= 1) {
            Attributes attributes = list.get(0);
            attributes.getTemperature().setCancel(true);
            return attributesRepository.save(attributes);
        }

        return null;
    }

    @RequestMapping(value = "cancel/observe/5", method = RequestMethod.GET)
    public Attributes cancelObserveBacteria() {
        List<Attributes> list = attributesRepository.findAll();
        if (list != null && list.size() >= 1) {
            Attributes attributes = list.get(0);
            attributes.getBacteria().setCancel(true);
            return attributesRepository.save(attributes);
        }

        return null;
    }

    private boolean needsNotify(Object obj) {
        List<Attributes> list = attributesRepository.findAll();
        if (list != null && list.size() >= 1) {
            if (obj instanceof Temperature) {
                Attribute attribute = list.get(0).getTemperature();
                Temperature temperature = (Temperature) obj;
                if (!attribute.isCancel() && temperature.getTemperature() > attribute.getGreaterThan()) {
                    return true;
                }
            } else if (obj instanceof Bacteria) {
                Attribute attribute = list.get(0).getTemperature();
                Bacteria bacteria = (Bacteria) obj;
                if (!attribute.isCancel() && bacteria.getBacteria() > attribute.getGreaterThan()) {
                    return true;
                }
            }
        }
        return false;
    }
}
