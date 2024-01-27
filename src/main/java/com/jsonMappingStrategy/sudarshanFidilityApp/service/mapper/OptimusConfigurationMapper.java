package com.jsonMappingStrategy.sudarshanFidilityApp.service.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Getter
@Component
public class OptimusConfigurationMapper {

    private Map<String, Map<String, List<Map<String, Object>>>> data;
    public  Map<String, Map<String, List<Map<String, Object>>>> map(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readValue(json, JsonNode.class);
        JsonNode rootNode = node.get("db");
        return mapper.readValue(rootNode.toString(), new TypeReference<Map<String, Map<String, List<Map<String, Object>>>>>() {
        });
    }

}
