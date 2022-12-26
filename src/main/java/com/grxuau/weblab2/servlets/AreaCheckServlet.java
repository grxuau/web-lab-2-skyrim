package com.grxuau.weblab2.servlets;

import com.grxuau.data.InputData;
import com.grxuau.weblab2.area.AreaChecker;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

//TODO: добавить полную валидацию на случай отключения JavaScript'a!
public class AreaCheckServlet extends HttpServlet {
    static final short PROCESSING_ERROR_CODE = 418; //i'm teapot xd
    static final short VALIDATING_ERROR_CODE = 450; //there is no such code in MDN WEB DOCS
    //FIXME проверить, содержит ли запрос координаты точки
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        LocalDateTime localTime = LocalDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatLocalTime = localTime.format(formatter);

        long startTime = System.currentTimeMillis();

        try {


            double x = Double.parseDouble(req.getParameter("x"));
            double y = Double.parseDouble(req.getParameter("y"));
            String[] r = req.getParameterValues("r[]");

            for (String rElement: r) {
                if (!validateR(Double.parseDouble(rElement))) {
                    resp.setStatus(VALIDATING_ERROR_CODE);
                }
            }

            boolean isValid = validateX(x) && validateY(y);

            if (isValid) {
                int checkNumber = 0;
                boolean[] hitResults = new boolean[r.length];

                for (String rElement : r) {
                    //TODO посмотреть цвет пикселя, чтобы удостовериться в правильности работа алгоса
                    boolean hit = isHit(x, y, Double.parseDouble(rElement));

                    hitResults[checkNumber] = hit;
                    checkNumber++;
                }

                StringBuilder resultString = new StringBuilder();
                for (byte i = 0; i < hitResults.length; i++) {
                    resultString.append(r[i])
                                .append("- ")
                                .append(hitResults[i])
                                .append(";");
                    if (i == hitResults.length - 1) {
                        resultString.deleteCharAt(resultString.length()-1); //удаление ';'
                    }
                }

                long endTime = System.currentTimeMillis();
                long executeTime = endTime - startTime;

                HttpSession session = req.getSession();
                session.setAttribute("x", x);
                session.setAttribute("y", y);
                session.setAttribute("r", r);
                session.setAttribute("curtime", formatLocalTime);
                session.setAttribute("exectime", executeTime);
                session.setAttribute("hitres", resultString);

                resp.sendRedirect(req.getContextPath() + "/result.jsp");
            }
        } catch (NullPointerException | NumberFormatException | IOException e) {
            System.err.println("Отладка: ошибка");
            resp.setStatus(PROCESSING_ERROR_CODE);
        }
    }

    private boolean isHit(double x, double y, double r) {
        //FIXME понять, как сделать путь короче
        String filePath = "C:\\java_senior\\web-lab-2\\src\\main\\java\\com\\grxuau\\weblab2\\skyrim.png";
        File image = new File(filePath);
        try {
            BufferedImage bufferedImage = ImageIO.read(image);

            AreaChecker areaChecker = new AreaChecker(bufferedImage);

            InputData inputData = new InputData(x, y, r);

            return areaChecker.checkHit(inputData);
        } catch (IOException e) {
            System.err.println("An error occurred while processing the bitmap image.");
            return false;
        }
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
