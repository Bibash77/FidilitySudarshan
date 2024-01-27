package com.jsonMappingStrategy.sudarshanFidilityApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TableAttribute {

    private String tableAttributeName;
    private String tableAttributeKey;
    private String tableAttributeType;
}
