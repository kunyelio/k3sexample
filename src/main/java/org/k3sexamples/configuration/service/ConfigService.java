package org.k3sexamples.configuration.service;


import org.k3sexamples.configuration.dao.ConfigRepository;
import org.k3sexamples.configuration.dao.entities.ConfigParamEntity;
import org.k3sexamples.configuration.model.ConfigParam;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ConfigService {
    protected ConfigRepository configRepository;

    @Autowired
    public ConfigService(ConfigRepository configRepository){
        this.configRepository = configRepository;
    }

    public Collection<ConfigParam> getAllConfigurationParameters(){
        return configRepository.findAll().stream().map(this::transformToConfigParam).collect(Collectors.toList());
    }

    public void setConfigParam(ConfigParam configParam){
        configRepository.save(transformToConfigParamEntity(configParam));
    }

    private ConfigParamEntity transformToConfigParamEntity(ConfigParam configParam){
        ConfigParamEntity configParamEntity = new ConfigParamEntity();
        configParamEntity.setConfigKey(configParam.getConfigKey());
        configParamEntity.setConfigValue(configParam.getConfigValue());
        return configParamEntity;
    }

    private ConfigParam transformToConfigParam(ConfigParamEntity configParamEntity){
        ConfigParam configParam = new ConfigParam();
        configParam.setConfigKey(configParamEntity.getConfigKey());
        configParam.setConfigValue(configParamEntity.getConfigValue());
        return configParam;
    }
}
