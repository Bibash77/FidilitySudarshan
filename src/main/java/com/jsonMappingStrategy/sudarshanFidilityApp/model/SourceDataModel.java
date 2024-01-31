package com.jsonMappingStrategy.sudarshanFidilityApp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SourceDataModel {

    // This maps key value tables to their corresponding key,val column names
    private static final HashMap<String, String> keyValTables;
    // This maps columns to their default values
    private static final HashMap<String, String> defaultValues;
    // Tables map
    private static HashMap<String, String> tablesMap;

    static {
        keyValTables = new HashMap<String, String>();
        keyValTables.put("service_step_config_attrib", "service_step_config_attrib_cd,service_step_config_attrib_val");
    }

    static {
        defaultValues = new HashMap<String, String>();
        defaultValues.put("client_org_config_attrib_category_cd", "CLIENTCONFIG");
    }

    static {
        tablesMap.put("service", "service_config,service_step_config,service_step_config_attrib");
    }

    // Hashset for custom coding tables?

    // This map will hold all values unused, PK to value to be accessed by later modules/nodes
    public HashMap<String, String> fieldsMap;
// GETTERS AND SETTERS?
    // Setter input validation? Or no setter since everything should be static for above
    // Setter might need for the missingFields

    // Getter do string logic to return list of values?

    public List<String> getTablesMap(String nodeName) {
        String mapValue = tablesMap.get(nodeName);
        List<String> returnList = new ArrayList<String>();
        if (mapValue != null || !mapValue.isEmpty()) {
            String[] mapValueSplit = mapValue.split(",");
            Collections.addAll(returnList, mapValueSplit);
        }
        return returnList;
    }

    // Add ones just for key and value, could be unordered!
    public List<String> getKeyValMap(String nodeName) {
        String mapValue = keyValTables.get(nodeName);
        List<String> returnList = new ArrayList<String>();
        if (mapValue != null || !mapValue.isEmpty()) {
            String[] mapValueSplit = mapValue.split(",");
            Collections.addAll(returnList, mapValueSplit);
        }
        return returnList;
    }

}