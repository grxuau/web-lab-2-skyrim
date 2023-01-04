package com.grxuau.weblab2.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("GET")) {
            doGet(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/error-404").forward(req, resp);
        }
    }
    //FIXME сделать валидацию чекбоксов на JS
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            String x = req.getParameter("x");
            String y = req.getParameter("y");
            String[] r = req.getParameterValues("r[]");

            if (r.length >= 1 && x != null && r != null) {
                req.getRequestDispatcher("/check-servlet").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/error-404").forward(req, resp);
            }
        } catch (NullPointerException | NumberFormatException | ServletException e) {
            getServletContext().getRequestDispatcher("/error-404").forward(req, resp);
        }
    }
}
