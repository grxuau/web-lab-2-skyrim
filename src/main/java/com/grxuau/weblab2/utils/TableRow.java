package com.grxuau.weblab2.utils;

import java.time.LocalDateTime;

public class TableRow {
    private final double x;
    private final double y;
    private final double[] r;
    private final String hitResult;
    private final LocalDateTime clientDate;
    private final double scriptWorkingTime;

    public TableRow(double x, double y, double[] r, String hitResult, LocalDateTime clientDate, double scriptWorkingTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hitResult = hitResult;
        this.clientDate = clientDate;
        this.scriptWorkingTime = scriptWorkingTime;
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
}
