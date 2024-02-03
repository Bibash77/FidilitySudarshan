package com.jsonMappingStrategy.sudarshanFidilityApp.service.sourceProcesser;

import com.jsonMappingStrategy.sudarshanFidilityApp.model.TableAttribute;
import com.jsonMappingStrategy.sudarshanFidilityApp.model.TableMetadata;
import com.jsonMappingStrategy.sudarshanFidilityApp.service.ReadService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientNodeProcesser extends GenericSourceProcessor{


    public ClientNodeProcesser(ReadService readService) {
        super(readService);
    }


    @Override
    public Map<String, List<Map<String, Object>>> prepareSourceData(Map.Entry<String, Map<String, List<Map<String, Object>>>> sourceDataEntry, List<TableMetadata> tableData) {
        try {
            Map<String, List<Map<String, Object>>> returnValue = new HashMap<>();
            Map<String, List<Map<String, Object>>> sourceNodeValue = sourceDataEntry.getValue();
            for (Map.Entry<String, List<Map<String, Object>>> sourceTable : sourceNodeValue.entrySet()) { // client_org_config_attrib
                String tableName = sourceTable.getKey();
                List<Map<String, Object>> listTableEntrys = sourceTable.getValue();
                for (TableMetadata table : tableData) { // table all list
                    if (table.getTableName().contains(tableName)) {  // check if table name is client_org_config_attrib
                        List<TableAttribute> tableAttribs = readService.getTableAttributes(table.getTableId());
// Loop through table to pick up relavent fields
                        // Will omit fields used by other nodes/modules
                        List<Map<String, Object>> listToAdd = new ArrayList<>();
                        for (Map<String, Object> tableEntry : listTableEntrys) {
                            Map<String, Object> mapToAdd = new HashMap<>();
                            for (Map.Entry<String, Object> keyVal : tableEntry.entrySet()) {
                                for (TableAttribute tableAttrib : tableAttribs) {
                                    if (tableEntry.get(tableAttrib.getTableAttributeName()) != null) {
                                        mapToAdd.put(keyVal.getKey(), keyVal.getValue());
                                        break;// Found table column matching to keyval in source, go to next keyval
                                    }
                                }
                                mapToAdd.put("client_org_config_attrib_category_cd", "CLIENTCONFIG");
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
        return Collections.emptyMap();
    }
}
