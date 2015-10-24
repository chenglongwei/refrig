package com.longyi.dist.server.controller;

import com.longyi.dist.server.domain.RegisterInfo;
import com.longyi.dist.server.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenglongwei on 10/5/15.
 */
@RestController
@RequestMapping("api/rd")
public class RegisterController {
    @Autowired
    private RegisterRepository registerRepository;

    @RequestMapping(method = RequestMethod.POST)
    public RegisterInfo register(@RequestBody RegisterInfo registerInfo) {
        RegisterInfo pre = registerRepository.findByEndpointClientName(registerInfo.getEndpointClientName());
        if(pre != null) {
            registerRepository.delete(pre);
        }
        return registerRepository.save(registerInfo);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<RegisterInfo> getAll() {
        return registerRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public RegisterInfo update(@RequestBody RegisterInfo registerInfo) {
        RegisterInfo update = registerRepository.findByEndpointClientName(registerInfo.getEndpointClientName());
        if(update != null) {
            update.setEndpointClientName(registerInfo.getEndpointClientName());
            update.setOid_0(registerInfo.getOid_0());
            update.setOid_3(registerInfo.getOid_3());

            return registerRepository.save(update);
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public RegisterInfo delete(@RequestParam(value = "ep") String ep) {
        RegisterInfo info = registerRepository.findByEndpointClientName(ep);
        registerRepository.delete(info);
        return info;
    }
}
