package com.jsonMappingStrategy.sudarshanFidilityApp.service.sourceProcesser;

import com.jsonMappingStrategy.sudarshanFidilityApp.model.TableAttribute;
import com.jsonMappingStrategy.sudarshanFidilityApp.model.TableMetadata;
import com.jsonMappingStrategy.sudarshanFidilityApp.service.ReadService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceNodeProcessor extends GenericSourceProcessor {

    public ServiceNodeProcessor(ReadService readService) {
        super(readService);
    }

    @Override
    public Map<String, List<Map<String, Object>>> prepareSourceData(Map.Entry<String, Map<String, List<Map<String, Object>>>> sourceDataEntry, List<TableMetadata> tableData) {
        try {
            Map<String, List<Map<String, Object>>> returnValue = new HashMap<>();
            Map<String, List<Map<String, Object>>> sourceNodeValue = sourceDataEntry.getValue();
            for (Map.Entry<String, List<Map<String, Object>>> sourceTable : sourceNodeValue.entrySet()) {
                String tableName = sourceTable.getKey();
                List<Map<String, Object>> listTableEntrys = sourceTable.getValue();
                if (tableName.equals("read_step") || tableName.equals("compute_step")) {
                    String attribTable = "service_step_config_attrib";
                    // DO key value processing

                    // Pop key values used to look up
                    // get service_config_id and service_step_config_id
                    continue;
                }

                for (TableMetadata table : tableData) {
                    if (table.getTableName().contains(tableName)) {
                        List<TableAttribute> tableAttribs = readService.getTableAttributes(table.getTableId());
// Loop through table to pick up relavent fields
                        // Will omit fields used by other nodes/modules
                        List<Map<String, Object>> listToAdd = new ArrayList<>();
                        for (Map<String, Object> tableEntry : listTableEntrys) {
                            Map<String, Object> mapToAdd = new HashMap<>();
                            for (Map.Entry<String, Object> keyVal : tableEntry.entrySet()) {
                                for (TableAttribute tableAttrib : tableAttribs) {
                                    // TODO WHAT TO DO ABOUT OPTIONAL FIELDS?
                                    if (tableEntry.get(tableAttrib.getTableAttributeName()) != null) {
                                        // Add entry as its part of table attributes
                                        mapToAdd.put(keyVal.getKey(), keyVal.getValue());
                                        break;// Found table column matching to keyval in source, go to next keyval
                                    }
                                }
                            }
                            if (!mapToAdd.isEmpty()) {
                                listToAdd.add(mapToAdd);
                            }

                        }
                        returnValue.put(tableName, listToAdd);
                    }
                }

            }
            return returnValue;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}