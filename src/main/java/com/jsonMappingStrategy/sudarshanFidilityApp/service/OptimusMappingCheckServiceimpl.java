package com.jsonMappingStrategy.sudarshanFidilityApp.service;

import com.jsonMappingStrategy.sudarshanFidilityApp.service.mapper.OptimusConfigurationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OptimusMappingCheckServiceimpl {

    @Autowired
    private OptimusConfigurationMapper optimusConfigurationMapper;

    public void mapData() {
        Map<String, Map<String, List<Map<String, Object>>>> parsedMap = optimusConfigurationMapper.getData();
        // client db mapping


        // config_attribute



    }

}
