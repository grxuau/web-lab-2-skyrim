package com.grxuau.weblab2.utils;

public class Playground {

    public static void main(String[] args) {
        String[] r = {"1", "2"};
        double[] xav = {1.0, 2.0, 3.0};
        try {
            CoordinateValidatorV2 coordinateValidatorV2 = new CoordinateValidatorV2("1", "1,344", r);
            coordinateValidatorV2.validateX(xav);
            System.out.println("all is good!");
        } catch (InvalidInputException e) {
            System.out.println("Плохие координаты!");
        }
    }
}
