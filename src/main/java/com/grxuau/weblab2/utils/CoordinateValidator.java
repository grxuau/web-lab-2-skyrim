package com.grxuau.weblab2.utils;

public class CoordinateValidator {
    final int MAX_INPUT_LENGTH = 12;

    final String integerStartingWithZero = "^0+\\d+$";
    final String numberSystemsPattern    = "(0x|0o|0b)\\d*";

    //FIXME what if 1.50000000000000 will be passed?
    String   x;
    String   y;
    String[] r;

    public CoordinateValidator(String x, String y, String[] r) {
        String[] xyCoord = processXY(x, y);
        String[]  rCoord = processR(r);

        this.x = xyCoord[0];
        this.y = xyCoord[1];
        this.r = rCoord;
    }

    private String[] processXY(String x, String y) {
        String processedX = x.trim();
        String processedY = y.trim();

        processedX = processedX.replace(',', '.');
        processedY = processedY.replace(',', '.');

        return new String[]{processedX, processedY};
    }

    private String[] processR(String[] r) {
        for (int i = 0; i < r.length; i++) {
            r[i] = r[i].trim()
            r[i] = r[i].replace(',', '.');
        }
        return r;
    }

    public boolean validateX(double[] availableValues) {
        if (isNumeric(x)) {
            return   isDecimal(x) &&
                     isCorrectLength(x) &&
                    !isStartedWithZero(x) &&
                     isBelongToInterval(availableValues, Double.parseDouble(x));
        } else {
            return false;
        }
    }

    public boolean validateY(double leftBorder, double rightBorder) {
        if (isNumeric(y)) {
            return   isDecimal(y) &&
                     isCorrectLength(y) &&
                    !isStartedWithZero(y) &&
                     isBelongToInterval(leftBorder, rightBorder, Double.parseDouble(x));
        } else {
            return false;
        }
    }

//    public boolean validateR(double[] availableValues) {
//        boolean valid;
//
//        for (String rValue: r) {
//            if ()
//        }
//    }

//    boolean validR;
//        for (String rValue: r) {
//        if (!isNumeric(rValue) || !isCorrectLength(rValue)) {
//            validR = false;
//            break;
//        }
//    }

    //FIXME how to check r[]?
    //TODO process coords in constructor
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

    public boolean isBelongToInterval(double leftBorder, double rightBorder, double number) {
        try {
            return  (number >= leftBorder) &&
                    (number <= rightBorder);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isBelongToInterval(double[] avaliableValues, double number) {
        for (double value: avaliableValues) {
            if (number == value) {
                return true;
            }
        }
        return false;
    }

    public boolean isCorrectLength(String formInput) {
        return  formInput.length() < MAX_INPUT_LENGTH;
    }
}