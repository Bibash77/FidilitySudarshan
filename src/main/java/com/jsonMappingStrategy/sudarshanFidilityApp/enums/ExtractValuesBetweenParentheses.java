package com.jsonMappingStrategy.sudarshanFidilityApp.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractValuesBetweenParentheses {
    public static void main(String[] args) {
        String input1 = "aa{20)";
        String input2 = "asdasdasdasdsadsadsadsa(9)";
        String input3 = "a(111)";

        System.out.println(extractValueBetweenParentheses(input1));  // Output: ""
        System.out.println(extractValueBetweenParentheses(input2));  // Output: "9"
        System.out.println(extractValueBetweenParentheses(input3));  // Output: "111"
    }

    private static String extractValueBetweenParentheses(String input) {
        // Define a regular expression pattern to match values between parentheses
        Pattern pattern = Pattern.compile("\\(([^)]+)\\)");
        Matcher matcher = pattern.matcher(input);

        // Check if the pattern is found
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }
}
