package com.grxuau.weblab2.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public String getR() {
        StringBuilder rString = new StringBuilder();
        for (int i = 0; i < r.length; i ++) {
            if (i == r.length - 1) {
                rString.append(r[i]);
            } else {
                rString.append(r[i] + ", ");
            }
        }
        return rString.toString();
    }

    public String getHitResult() {
        return hitResult;
    }

    public String getClientDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedClientTime = clientDate.format(formatter);
        return formattedClientTime;
    }

    public double getScriptWorkingTime() {
        return scriptWorkingTime;
    }
}