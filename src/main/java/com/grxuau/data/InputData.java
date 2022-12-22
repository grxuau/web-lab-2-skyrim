package com.grxuau.data;

public class InputData {
    float x;
    float y;
    float r;

    public InputData(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
