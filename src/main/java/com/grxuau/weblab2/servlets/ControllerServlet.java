package com.grxuau.weblab2.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ControllerServlet extends HttpServlet {
    final static int BAD_REQUEST = 400;
    //FIXME: как оно определяет тип запроса?
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double x = Double.parseDouble(req.getParameter("x"));
            double y = Double.parseDouble(req.getParameter("y"));

            //FIXME: скорее всего здесь будет падать
//            String r = req.getParameter("r[]");


//            req.getRequestDispatcher("/area-check-servlet").forward(req, resp);
        } catch (NullPointerException | NumberFormatException e) {
            Writer writer = resp.getWriter();
            writer.write("ОШИБКА");
            resp.setStatus(BAD_REQUEST);
        }
    }
}
