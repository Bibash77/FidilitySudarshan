package com.jsonMappingStrategy.sudarshanFidilityApp.model;

public class TableMetadata {

    int tableId;
    String tableName;
    String tableSchema;
    String storedProcedureName;
    int insertOrder;
    int deleteOrder;

    public String getTableName() {
        return tableName;
    }

    public String getStoredProcedureName() {
        return storedProcedureName;
    }

    public void setStoredProcedureName(String storedProcedureName) {
        this.storedProcedureName = storedProcedureName;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getInsertOrder() {
        return insertOrder;
    }

    public void setInsertOrder(int insertOrder) {
        this.insertOrder = insertOrder;
    }

    public int getDeleteOrder() {
        return deleteOrder;
    }

    public void setDeleteOrder(int deleteOrder) {
        this.deleteOrder = deleteOrder;
    }

}