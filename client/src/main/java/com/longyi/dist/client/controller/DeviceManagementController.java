package com.longyi.dist.client.controller;

import com.longyi.dist.client.domain.*;
import com.longyi.dist.client.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chenglongwei on 11/14/15.
 */
@RestController
@RequestMapping("api/dm")
public class DeviceManagementController {
    @Autowired
    private TemperatureRepository temperatureRepository;
    @Autowired
    private BacteriaRepository bacteriaRepository;
    @Autowired
    private BootstrapRepository bootstrapRepository;
    @Autowired
    private CommandRepository commandRepository;
    @Autowired
    private AttributesRepository attributesRepository;

    @RequestMapping(value = "read/4/0", method = RequestMethod.GET)
    public Temperature readTemperature() {
        List<Temperature> list = temperatureRepository.findAll();
        if (list != null && list.size() >= 1) {
            return list.get(0);
        }

        return null;
    }

    @RequestMapping(value = "read/5/0", method = RequestMethod.GET)
    public Bacteria readBacteria() {
        List<Bacteria> list = bacteriaRepository.findAll();
        if (list != null && list.size() >= 1) {
            return list.get(0);
        }

        return null;
    }

    @RequestMapping(value = "discover/3", method = RequestMethod.GET)
    public Oid_3 discover() {
        List<Refrig> list = bootstrapRepository.findAll();
        if (list != null && list.size() >= 1) {
            return list.get(0).getOid_3();
        }

        return null;
    }

    @RequestMapping(value = "write/3/3", method = RequestMethod.PUT)
    public Refrig writeVersion(@RequestBody String newValue) {
        List<Refrig> list = bootstrapRepository.findAll();
        if (list != null && list.size() >= 1) {
            Refrig refrig = list.get(0);
            refrig.getOid_3().setRid_3(newValue);
            return bootstrapRepository.save(refrig);
        }

        return null;
    }

    @RequestMapping(value = "write/attributes/4", method = RequestMethod.POST)
    public Attributes writeTempAttributes(@RequestBody Attribute temperature) {
        List<Attributes> list = attributesRepository.findAll();
        Attributes attributes;
        if (list != null && list.size() >= 1) {
            attributes = list.get(0);
        } else {
            attributes = new Attributes();
        }
        attributes.setTemperature(temperature);
        return attributesRepository.save(attributes);
    }

    @RequestMapping(value = "write/attributes/5", method = RequestMethod.POST)
    public Attributes writeBacteriaAttributes(@RequestBody Attribute bacteria) {
        List<Attributes> list = attributesRepository.findAll();
        Attributes attributes;
        if (list != null && list.size() >= 1) {
            attributes = list.get(0);
        } else {
            attributes = new Attributes();
        }
        attributes.setBacteria(bacteria);
        return attributesRepository.save(attributes);
    }

    @RequestMapping(value = "execute/command/4", method = RequestMethod.GET)
    public Command setTemperature(@RequestParam(value = "newValue") String newValue) {
        List<Command> list = commandRepository.findAll();
        Command command;
        if (list != null && list.size() >= 1) {
            command = list.get(0);
        } else {
            command = new Command();
        }
        command.setTemperature(newValue);
        return commandRepository.save(command);
    }

    @RequestMapping(value = "execute/command/5", method = RequestMethod.GET)
    public Command setBacteria(@RequestParam(value = "newValue") String newValue) {
        List<Command> list = commandRepository.findAll();
        Command command;
        if (list != null && list.size() >= 1) {
            command = list.get(0);
        } else {
            command = new Command();
        }
        command.setBacteria(newValue);
        return commandRepository.save(command);
    }

    @RequestMapping(value = "create/2/0", method = RequestMethod.POST)
    public Refrig createAccessOwner(@RequestBody String newValue) {
        List<Refrig> list = bootstrapRepository.findAll();
        if (list != null && list.size() >= 1) {
            Refrig refrig = list.get(0);
            refrig.getOid_2().setRid_0(newValue);
            return bootstrapRepository.save(refrig);
        }

        return null;
    }

    @RequestMapping(value = "delete/2/0", method = RequestMethod.DELETE)
    public Refrig deleteAccessOwner() {
        List<Refrig> list = bootstrapRepository.findAll();
        if (list != null && list.size() >= 1) {
            Refrig refrig = list.get(0);
            refrig.getOid_2().setRid_0("");
            return bootstrapRepository.save(refrig);
        }

        return null;
    }

}
