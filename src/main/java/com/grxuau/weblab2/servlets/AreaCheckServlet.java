package com.grxuau.weblab2.servlets;

import com.grxuau.data.InputData;
import com.grxuau.weblab2.area.AreaChecker;
import com.grxuau.weblab2.utils.CoordinateValidator;
import com.grxuau.weblab2.utils.InvalidInputException;
import com.grxuau.weblab2.utils.TableRow;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AreaCheckServlet extends HttpServlet {
    final double[] availableX = {-5, -4, -3, -2, -1, 0, 1, 2, 3};
    final double[] availableR = {1, 1.5, 2, 2.5, 3};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String[] r = req.getParameterValues("r[]");

        try {
            CoordinateValidator validator = new CoordinateValidator(x, y, r);

            boolean validX = validator.validateX(availableX);
            boolean validY = validator.validateY(-5, 5);
            boolean validR = validator.validateR(availableR);

            if (validX && validY && validR) {
                HttpSession httpSession = req.getSession();
                LocalDateTime clientDate = LocalDateTime.now();
                TableRow newRow = formNewTableRow(validator.getX(), validator.getY(), validator.getR(), clientDate);
                List<TableRow> tableRows = sessionObjectToArrayList(httpSession.getAttribute("table"));
                tableRows.add(newRow);
                httpSession.setAttribute("table", tableRows);

                resp.setStatus(HttpServletResponse.SC_OK);
                resp.setCharacterEncoding("UTF-8");
            }
        } catch (InvalidInputException | NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Bad Request: invalid input");
        }
    }

    public TableRow formNewTableRow(double x, double y, double[] r, LocalDateTime clientDate) {
        boolean[] hitResults = new boolean[r.length];

        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < r.length; i++) {
            hitResults[i] = isHit(x, y, r[i]);
        }
        double scriptWorkingTime = System.currentTimeMillis() - currentTime;
        String result = getResult(hitResults, r);

        return new TableRow(x, y, r, result, clientDate, scriptWorkingTime);
    }

    private List<TableRow> sessionObjectToArrayList(Object table) {
        if (table instanceof Collection) {
            return (List<TableRow>) table;
        } else {
            return new ArrayList<>();
        }
    }

    private boolean isHit(double x, double y, double r) {
        String filePath = "C:\\java_senior\\web-lab-2\\src\\main\\java\\com\\grxuau\\weblab2\\skyrim.png";
        File image = new File(filePath);
        try {
            AreaChecker areaChecker = new AreaChecker(ImageIO.read(image));
            return areaChecker.checkHit(new InputData(x, y, r));
        } catch (IOException e) {
            return false;
        }
    }

    private String getResult(boolean[] hitResults, double[] r) {
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < hitResults.length; i++) {
            resultString.append(r[i])
                    .append("- ")
                    .append(hitResults[i])
                    .append(";");
            if (i == hitResults.length - 1) {
                resultString.deleteCharAt(resultString.length() - 1); //удаление ';'
            }
        }

        return resultString.toString();
    }
}