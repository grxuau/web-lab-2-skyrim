package com.grxuau.data;

public class InputData {
    double x;
    double y;
    double r;

    public InputData(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
