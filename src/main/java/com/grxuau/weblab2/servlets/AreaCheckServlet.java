package com.grxuau.weblab2.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
//TODO: добавить полную валидацию на случай отключения JavaScript'a!
public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime workTime = LocalDateTime.now(ZoneOffset.UTC);

    }
    //можно ли назвать это "валидацией на сервере"?
    private boolean validate(double x, double y, double r) {
        return validateX(x) && validateY(y) && validateR(r);
    }

    private boolean validateX(double x) {
        double[] allowedValues = {-5, -4, -3, -2, -1, 0, 1, 2, 3};

        for(double allowedValue: allowedValues) {
            if (x == allowedValue) {
                return true;
            }
        }
        return false;
    }

    private boolean validateY(double y) {
        return  y >= -5 && y <= 5;
    }

    private boolean validateR(double r) {
        double[] allowedValues = {1, 1.5, 2, 2.5, 3};

        for(double allowedValue: allowedValues) {
            if (r == allowedValue) {
                return true;
            }
        }
        return false;
    }
}
