package com.jsonMappingStrategy.sudarshanFidilityApp.service.custom;

import com.jsonMappingStrategy.sudarshanFidilityApp.model.TableAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomDataHandler {

    void handleCustomCompare(Map<String, Map<String, List<Map<String, Object>>>> parsedMap){

        List<Map<String, Object>> sourceData = new ArrayList<>();
        List<TableAttribute> tableAttribute = getTableAttributes();

        for (Map.Entry<String, Map<String, List<Map<String, Object>>>> entry : parsedMap.entrySet()) {
            Map<String, List<Map<String, Object>>> node = entry.getValue();
            for (Map.Entry<String, List<Map<String, Object>>> secondLevelEntry : node.entrySet()) {
                List<Map<String, Object>> dataList = secondLevelEntry.getValue();

                for (Map<String, Object> item : dataList) {
                    for (Map.Entry<String, Object> itemEntry : item.entrySet()) {
                        Map<String, Object> sourceDataMap = new HashMap<>();
                        for (TableAttribute attribute : getTableAttributes()) {
                            if(attribute.getTableAttributeName().contains("id")) {
                                sourceDataMap.put(attribute.getTableAttributeName(), itemEntry.getKey());
                            }
                            if(attribute.getTableAttributeName().contains("val")) {
                                sourceDataMap.put(attribute.getTableAttributeName(), itemEntry.getValue());
                            }

                        }
                        sourceDataMap.put("client_org_config_attrib_category_cd", "CLIENTCONFIG");
                        sourceData.add(sourceDataMap);
                    }
                }
            }
        }

        determineTrueChanges(sourceData);


    }

    private List<TableAttribute> getTableAttributes() {
        List<TableAttribute> tableAttributes = new ArrayList<>();
        tableAttributes.add(new TableAttribute("client_org_config_attrib_id", "", "String"));
        tableAttributes.add(new TableAttribute("client_org_config_attrib_value", "", "String"));
        tableAttributes.add(new TableAttribute("client_org_config_attrib_category_cd", "", "String"));
        return tableAttributes;
    }


    private void determineTrueChanges(List<Map<String, Object>> sourceData) {



    }

}
