package com.longyi.dist.client.controller;

import com.longyi.dist.client.Util.HttpUtil;
import com.longyi.dist.client.domain.Refrig;
import com.longyi.dist.client.domain.Temperature;
import com.longyi.dist.client.repository.BootstrapRepository;
import com.longyi.dist.client.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * Created by chenglongwei on 10/26/15.
 */
@RestController
@RequestMapping("api/do/send")
public class TemperatureController {
    @Autowired
    private TemperatureRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Temperature> send() {
        Temperature temperature = new Temperature();
        temperature.setEndpointClientName(BootstrapController.ep);
        temperature.setTemperatue(new Random().nextInt(100));
        temperature.setTimestamp(System.currentTimeMillis());

        List<Temperature> list = HttpUtil.httpSendData(
                "http://localhost:8080/server-1.0/api/temperature", temperature);
        repository.save(list);

        return list;
    }
}
