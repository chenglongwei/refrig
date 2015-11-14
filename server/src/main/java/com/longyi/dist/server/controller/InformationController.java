package com.longyi.dist.server.controller;

import com.google.gson.Gson;
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
    @Autowired
    private TemperatureRepository temperatureRepository;
    @Autowired
    private BacteriaRepository bacteriaRepository;

    @RequestMapping(value = "temperature", method = RequestMethod.POST)
    public List<Temperature> temperature(@RequestBody Temperature temperature) {
        //log
        System.out.println("temperature: \n" + new Gson().toJson(temperature, Temperature.class));

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
}
