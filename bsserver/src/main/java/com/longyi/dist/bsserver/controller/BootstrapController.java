package com.longyi.dist.bsserver.controller;

import com.longyi.dist.bsserver.domain.Bootstrap;
import com.longyi.dist.bsserver.domain.Refrig;
import com.longyi.dist.bsserver.repository.BootstrapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenglongwei on 10/5/15.
 */
@RestController
@RequestMapping("api/bs")
public class BootstrapController {

    @Autowired
    private BootstrapRepository bsServerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Bootstrap> bsList() {
        return bsServerRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Refrig bs(@RequestParam(value = "ep") String ep) {
        Bootstrap bootstrap = bsServerRepository.findByEp(ep);
        if(bootstrap != null) {
            return bootstrap.toRefrig();
        }
        return null;
    }
}
