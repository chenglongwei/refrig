package com.longyi.dist.server.controller;

import com.longyi.dist.server.domain.Temperature;
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
@RequestMapping("api/temperature")
public class TemperatureController {
    @Autowired
    private TemperatureRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public List<Temperature> temperature(@RequestBody Temperature temperature) {
        repository.save(temperature);
        List<Temperature> list = repository.findAll();
        if (list.size() <= 3) {
            return list;
        }
        return list.subList(list.size() - 3, list.size());
    }
}
