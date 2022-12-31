package com.grxuau.weblab2.utils;

public class CoordinateValidator {
    final String integerStartingWithZero = "^0+\\d+$";
    final String numberSystemsPattern = "(0x|0o|0b)\\d*";
    //TODO make coordinateValidator builder
    double x;
    double y;
    double[] r;

    public boolean isStartedWithZero(String formInput) {
        return  formInput.matches(integerStartingWithZero);
    }

    public boolean isDecimal(String formInput) {
        return !formInput.matches(numberSystemsPattern);
    }

    public boolean isNumeric(String formInput) {
        try {
            Double.parseDouble(formInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isBelongToInterval(int leftBorder, int rightBorder, double number) {
        return (number >= leftBorder) && (number <= rightBorder);
    }

    public boolean isBelongToInterval(double[] avaliableValues, double number) {
        for (double value: avaliableValues) {
            if (number == value) {
                return true;
            }
        }

        return false;
    }
}
