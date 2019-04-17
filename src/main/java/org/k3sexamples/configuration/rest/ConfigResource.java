package org.k3sexamples.configuration.rest;
import org.k3sexamples.configuration.model.ConfigParam;
import org.k3sexamples.configuration.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
@RequestMapping(value = "/configuration")
public class ConfigResource {

    @Autowired
    protected ConfigService service;

    @Autowired
    public ConfigResource(ConfigService service){
        this.service = service;
    }

    @RequestMapping(value = "/configParameters", produces = { "application/json" }, method= {RequestMethod.GET})
    public Collection<ConfigParam> getConfigParams(){
        return service.getAllConfigurationParameters();
    }

    @RequestMapping(value = "/setConfigParam", consumes = { "application/json" }, method= {RequestMethod.POST})
    public void setConfigParam(@RequestBody ConfigParam configParam){
        service.setConfigParam(configParam);
    }

}
