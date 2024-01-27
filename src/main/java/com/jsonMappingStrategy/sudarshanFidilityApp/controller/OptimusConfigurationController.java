package com.jsonMappingStrategy.sudarshanFidilityApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jsonMappingStrategy.sudarshanFidilityApp.service.mapper.OptimusConfigurationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/optimius-config")
public class OptimusConfigurationController {



    @Autowired
    private OptimusConfigurationMapper optimusConfigurationMapper;


    @GetMapping
    public ResponseEntity<?> testController() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> updateOptimusSaveMapping(String requestModel) {
        try {

            optimusConfigurationMapper.map(requestModel);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
