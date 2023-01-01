package com.grxuau.weblab2.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class AreaCheckServletV2 extends HttpServlet {
    static final short PROCESSING_ERROR_CODE = 418;
    static final short VALIDATING_ERROR_CODE = 450;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        class Point {
            double x;
            double y;
            double[] r;
            //FIXME first call CoordinateValidator, then SetCoords
            public void setCoords() {
                double x = Double.parseDouble(req.getParameter("x"));
                double y = Double.parseDouble(req.getParameter("y"));
                double[] r = Arrays.stream(req.getParameterValues("r[]"))
                                   .mapToDouble(Double::parseDouble)
                                   .toArray();

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

            public double[] getR() {
                return r;
            }
        }

        Point point = new Point();
        point.setCoords();

        boolean[] hitResults;




    }


}
