package com.grxuau.weblab2.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ControllerServlet extends HttpServlet {
    final static int BAD_REQUEST = 400;

    //boolean isPost = "POST".equals(request.getMethod());
    //прописать post-запрос
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Double x = Double.parseDouble(req.getParameter("x"));
            Double y = Double.parseDouble(req.getParameter("y"));
            String[] r = req.getParameterValues("r[]");
            //FIXME
            if ((r.length >= 1) && ("GET".equals(req.getMethod()))) {
                req.getRequestDispatcher("/area-check-servlet").forward(req, resp);
            } else {
                resp.setStatus(400);
            }

        } catch (NullPointerException | NumberFormatException e) {
            Writer writer = resp.getWriter();
            writer.write("ОШИБКА");
            resp.setStatus(BAD_REQUEST);
        }
    }
}
