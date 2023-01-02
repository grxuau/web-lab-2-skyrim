package com.grxuau.weblab2.utils;

public class Playground {

    public static void main(String[] args) {
        String[] r = {"1", "2"};

        try {
            CoordinateValidatorV2 coordinateValidatorV2 = new CoordinateValidatorV2("1", "1,344", r);
            System.out.println("all is good!");
        } catch (InvalidInputException e) {
            System.out.println("Плохие координаты!");
        }
    }
}
