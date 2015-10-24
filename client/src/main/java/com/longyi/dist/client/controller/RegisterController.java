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
@RequestMapping("api/do/register")
public class RegisterController {
    @Autowired
    private BootstrapRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public Refrig register() {
        List<Refrig> list = repository.findAll();
        if (list != null && list.size() >= 1) {
            Refrig refrig = list.get(0);
            return HttpUtil.httpRegister(refrig.getOid_0().getRid_0(), refrig);
        }

        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Refrig getRefrigInfo() {
        List<Refrig> list = repository.findAll();
        if (list != null && list.size() >= 1) {
            return list.get(0);
        }

        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Refrig update(@RequestBody Refrig refrig) {
        if (refrig != null) {
            repository.deleteAll();
            repository.save(refrig);
            return HttpUtil.httpUpdateRegister(refrig.getOid_0().getRid_0(), refrig);
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Refrig delete() {
        List<Refrig> list = repository.findAll();
        if (list != null && list.size() >= 1) {
            Refrig refrig = list.get(0);
            return HttpUtil.httpDeRegister(refrig.getOid_0().getRid_0() + "?ep=" + BootstrapController.ep);
        }

        return null;
    }
}
