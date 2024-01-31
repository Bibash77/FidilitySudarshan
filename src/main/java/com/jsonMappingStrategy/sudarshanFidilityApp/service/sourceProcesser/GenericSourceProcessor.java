package com.jsonMappingStrategy.sudarshanFidilityApp.service.sourceProcesser;

import com.jsonMappingStrategy.sudarshanFidilityApp.model.TableMetadata;
import com.jsonMappingStrategy.sudarshanFidilityApp.service.ReadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GenericSourceProcessor {

    private static final Logger LOGGER = LogManager.getLogger(GenericSourceProcessor.class);

//    @Autowired
//    private StoredProcedureRunner storedProcedureRunner;
//
//    @Autowired
//    private GenericCrudOperationResult genericCrudOperationResult;
//
//    @Autowired
//    private OptimusConfigurationMapper optimusConfigurationMapper;

    protected ReadService readService;

    public GenericSourceProcessor(ReadService readService) {
        this.readService = readService;
    }

    /**
     * Returns prepared source data Can map one entry to many
     *
     * @param sourceDataEntry Example, service: {service_config[{}], service_step_config[{}], ....}
     * @return returnValue
     * Example, {service_config: [{}], service_step_config[{}], service_step_config_attrib[{}]}
     */
    public Map<String, List<Map<String, Object>>> prepareSourceData(
            Map.Entry<String, Map<String, List<Map<String, Object>>>> sourceDataEntry, List<TableMetadata> tableData) {

        // need more generic processing?
        // Maybe just pick by table attributes
        Map<String, List<Map<String, Object>>> returnValue = new HashMap<>();
        String sourceNodeName = sourceDataEntry.getKey();
        Map<String, List<Map<String, Object>>> sourceNodeValue = sourceDataEntry.getValue
                ();
        returnValue = sourceNodeValue;
        return returnValue;
    }

    /**
     * Formats json entry to a key value table
     *
     * @param
     * @return list of prepared key val entries
     */
    protected List<Map<String, Object>> processKeyValEntry(String keyColumnName, String valueColumnName,
                                                           List<Map<String, Object>> listTableEntrys) {
        List<Map<String, Object>> listToAdd = new ArrayList<>();
        for (Map<String, Object> tableEntry : listTableEntrys) {
            Map<String, Object> mapToAdd = new HashMap<>();
            for (Map.Entry<String, Object> keyVal : tableEntry.entrySet()) {
                // Add entry as its part of table attributes
                mapToAdd.put(keyColumnName, keyVal.getKey());
                mapToAdd.put(valueColumnName, keyVal.getValue());
                break;// Found table column matching to keyval in source, go to next keyval
            }
            if (!mapToAdd.isEmpty()) {
                listToAdd.add(mapToAdd);
            }
        }
        return listToAdd;
    }

    // Function that prepares source data on table level
    // prepareSourceDataTable
}