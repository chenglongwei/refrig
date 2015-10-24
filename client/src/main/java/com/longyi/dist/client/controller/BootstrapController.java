package com.longyi.dist.client.controller;

import com.longyi.dist.client.Util.HttpUtil;
import com.longyi.dist.client.domain.Refrig;
import com.longyi.dist.client.repository.BootstrapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenglongwei on 10/5/15.
 */
@RestController
@RequestMapping("api/do/bs")
public class BootstrapController {
    public static final String ep = "uuid:00000000-0000-0000-000000000001";

    @Autowired
    private BootstrapRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Refrig getRefrigInfo() {
        List<Refrig> list = repository.findAll();
        if(list != null && list.size() >= 1) {
            return list.get(0);
        }

        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Refrig bootstrap() {
        Refrig refrig =  HttpUtil.httpBootStrap(
                "http://localhost:8080/bsserver-1.0/api/bs?ep=" + ep);
        if(refrig != null) {
            repository.deleteAll();
            repository.save(refrig);
        }
        return refrig;
    }
}
