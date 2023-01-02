package com.grxuau.weblab2.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
//формирует html страницу, а не jsp
public class AreaCheckServletV2 extends HttpServlet {
    static final short PROCESSING_ERROR_CODE = 418;
    static final short VALIDATING_ERROR_CODE = 450;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        class Point {
            double x;
            double y;
            double[] r;

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

//            private boolean validateCoords() {
//                final double[] availableXValues = {-5, -4, -3, -2, -1, 0, 1, 2, 3};
//                final double[] availableRValues = {1, 1.5, 2, 2.5, 3};
//
//                final double MIN_Y_VALUE = -5;
//                final double MAX_Y_VALUE =  5;
//
//                String   x = req.getParameter("x");
//                String   y = req.getParameter("y");
//                String[] r = req.getParameterValues("r[]");
//
//            }

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
