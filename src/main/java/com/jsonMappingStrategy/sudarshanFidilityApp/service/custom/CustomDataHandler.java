package com.jsonMappingStrategy.sudarshanFidilityApp.service.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomDataHandler {

    void handleCustomCompare(Map<String, Map<String, List<Map<String, Object>>>> parsedMap){

        List<Map<String, Object>> sourceData = new ArrayList<>();
        Map<String, Object> categoryCode = new HashMap<>();
        categoryCode.put("client_org_config_attrib_category_cd", "ClientCONFIG");
        sourceData.add(categoryCode);

        for (Map.Entry<String, Map<String, List<Map<String, Object>>>> entry : parsedMap.entrySet()) {
            Map<String, List<Map<String, Object>>> node = entry.getValue();
            for (Map.Entry<String, List<Map<String, Object>>> secondLevelEntry : node.entrySet()) {
                List<Map<String, Object>> dataList = secondLevelEntry.getValue();

                for (Map<String, Object> item : dataList) {
                    for (Map.Entry<String, Object> itemEntry : item.entrySet()) {
                        Map<String, Object> sourceDataMap = new HashMap<>();
                        sourceDataMap.put("client_org_config_attrib_id", itemEntry.getKey());
                        sourceDataMap.put("client_org_config_attrib_value", itemEntry.getValue());
                        sourceDataMap.put("client_org_config_attrib_category_cd", "CLIENTCONFIG");
                        sourceData.add(sourceDataMap);
                    }
                }
            }
        }

        determineTrueChanges(sourceData);


    }


    private void determineTrueChanges(List<Map<String, Object>> sourceData) {



    }

}
