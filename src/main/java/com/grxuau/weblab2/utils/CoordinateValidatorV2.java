package com.grxuau.weblab2.utils;

public class CoordinateValidatorV2 {
    final int MAX_INPUT_LENGTH = 12;
    //FIXME invalid regex pattern
    final String numberStartingWithZero = "^0+\\d+$";
    //FIXME rename 'r' variable
    private final double x;
    private final double y;
    private final double[] r;

    public CoordinateValidatorV2(String x, String y, String[] r) throws NumberFormatException, InvalidInputException {
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
        for (double radius: r) {
            for (double availableValue: availableValues) {
                if (radius == availableValue) {
                    break;
                }

                return false;
            }
        }

        return true;
    }



    private boolean checkInput(String x, String y, String[] r) {
        boolean validX = !x.matches(numberStartingWithZero) && x.length() <= MAX_INPUT_LENGTH;
        boolean validY = !y.matches(numberStartingWithZero) && x.length() <= MAX_INPUT_LENGTH;

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