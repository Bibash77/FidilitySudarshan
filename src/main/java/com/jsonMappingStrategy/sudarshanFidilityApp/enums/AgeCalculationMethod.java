package com.jsonMappingStrategy.sudarshanFidilityApp.enums;

public enum AgeCalculationMethod {
    ACM("AGE_COMPLETED_MONTHS"),
    ANMD("AGE_NEAREST_MONTH_INCLUDE_DAYS"),
    AA("AGE_ATTAINED"),
    ACY("AGE_CALENDAR_YEAR"),
    AFOMF("AGE_FIRST_OF_MONTH"),
    AEOM("AGE_END_OF_MONTH"),
    ALB("AGE_LAST_BIRTHDAY"),
    ANM("AGE_NEAREST_MONTH"),
    ANB("AGE_NEAREST_YEAR");

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
