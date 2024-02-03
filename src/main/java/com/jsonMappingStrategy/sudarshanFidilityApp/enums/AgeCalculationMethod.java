package com.jsonMappingStrategy.sudarshanFidilityApp.enums;

public enum AgeCalculationMethod {
    AGE_COMPLETED_MONTHS("ACM"),
    AGE_NEAREST_MONTH_INCLUDE_DAYS("ANMD"),
    AGE_ATTAINED("AA"),
    AGE_CALENDAR_YEAR("ACY"),
    AGE_FIRST_OF_MONTH("AFOMF"),
    AGE_END_OF_MONTH("AEOM"),
    AGE_LAST_BIRTHDAY("ALB"),
    AGE_NEAREST_MONTH("ANM"),
    AGE_NEAREST_YEAR("ANB");

    private final String code;

    AgeCalculationMethod(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static void main(String[] args) {
        System.out.println(AgeCalculationMethod.valueOf("AGE_COMPLETED_MONTHS"));
    }
}
