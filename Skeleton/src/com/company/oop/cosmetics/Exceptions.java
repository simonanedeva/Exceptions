package com.company.oop.cosmetics;

import com.company.oop.cosmetics.core.ProductRepositoryImpl;
import com.company.oop.cosmetics.models.ProductImpl;

import java.util.List;

public class Exceptions {


    private static final String STRING_LENGTH_ERROR = "%s must be between %d and %d characters long.";
    public static final String INVALID_PRICE_ERROR = "%s cannot be negative";
    public static final String INVALID_NUMBER_OF_ARGUMENTS = "";

    public static void validateIntRange(int minLength, int maxLength, int actualLength, String type) {
        if (actualLength < minLength || actualLength > maxLength) {
            throw new OurOwnException(String.format(STRING_LENGTH_ERROR, type, minLength, maxLength));
        }
    }

    public static void validateStringLength(String stringToValidate, int minLength, int maxLength, String type) {
        validateIntRange(minLength, maxLength, stringToValidate.length(), type);
    }

    public static void validatePrice(double price, String type) {
        if (price < 0) {
            throw new OurOwnException(String.format(INVALID_PRICE_ERROR, type));
        }
    }

    public static void validateArgumentsCount(List<String> list, int expectedNumberOfParameters) {
        if (list.size() < expectedNumberOfParameters || list.size() > expectedNumberOfParameters) {
            throw new OurOwnException(String.format(INVALID_NUMBER_OF_ARGUMENTS,
                    expectedNumberOfParameters, list.size()));
        }
    }


}
