package com.grxuau.weblab2.utils;

public class CoordinateValidator {
    private final int MAX_INPUT_LENGTH = 12;

    private final String numberStartingWithZero = "^0+\\d+$";

    public final double x;
    public final double y;
    public final double[] r;

    public CoordinateValidator(String x, String y, String[] r) throws NumberFormatException, InvalidInputException {
        if (checkInput(x, y, r)) {
            this.x = Double.parseDouble(x.replace(",", "."));
            this.y = Double.parseDouble(y.replace(",", "."));

            double[] convertedArray = new double[r.length];
            for (int i = 0; i < r.length; i++) {
                convertedArray[i] = Double.parseDouble(r[i].replace(",", "."));
            }

            this.r = convertedArray;
        } else {
            throw new InvalidInputException("invalid input");
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double[] getR() {
        return r;
    }

    public boolean validateX(double[] availableValues) {
        for (double availableValue: availableValues) {
            if (x == availableValue) {
                return true;
            }
        }

        return false;
    }

    public boolean validateY(double leftBorder, double rightBorder) {
        return (leftBorder <= y) && (y <= rightBorder);
    }

    public boolean validateR(double[] availableValues) {
        int validatedVariables = 0;
        for (int i = r.length - 1; i >= 0; i--) {
            for (int j = 0; j < availableValues.length; j++) {
                if (r[i] == availableValues[j]) {
                    validatedVariables += 1;
                    break;
                }
            }
        }

        return validatedVariables == r.length;
    }

    private boolean checkInput(String x, String y, String[] r) {
        boolean validX = !x.matches(numberStartingWithZero) && x.length() <= MAX_INPUT_LENGTH;
        boolean validY = !y.matches(numberStartingWithZero) && x.length() <= MAX_INPUT_LENGTH;

        if (r.length == 0) {
            return false;
        }

        boolean validR = true;
        for (String radius : r) {
            if (radius.matches(numberStartingWithZero) || radius.length() > MAX_INPUT_LENGTH) {
                validR = false;
                break;
            }
        }

        return validX && validY && validR;
    }
}