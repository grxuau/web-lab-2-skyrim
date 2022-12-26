package com.grxuau.weblab2.servlets;

import com.grxuau.data.InputData;
import com.grxuau.weblab2.area.AreaChecker;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
//TODO: добавить полную валидацию на случай отключения JavaScript'a!
public class AreaCheckServlet extends HttpServlet {
    static final short PROCESSING_ERROR_CODE = 418; //i'm teapot xd
    static final short VALIDATING_ERROR_CODE = 450; //there is no such code in MDN WEB DOCS
    //FIXME проверить, содержит ли запрос координаты точки
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        LocalDateTime workTime = LocalDateTime.now(ZoneOffset.UTC);

        try {
            double x = Double.parseDouble(req.getParameter("x"));
            double y = Double.parseDouble(req.getParameter("y"));
            String[] r = req.getParameterValues("r[]");

            for (String rElement: r) {
                if (!validateR(Double.parseDouble(rElement))) {
                    resp.setStatus(VALIDATING_ERROR_CODE);
                }
            }

            boolean isValid = validateX(x) && validateY(y); //no need to check with r together

            if (isValid) {
                int checkNumber = 0;
                boolean[] hitResults = new boolean[r.length];

                for (String rElement : r) {
                    //TODO посмотреть цвет пикселя, чтобы удостовериться в правильности работа алгоса
                    boolean hit = isHit(x, y, Double.parseDouble(rElement));

                    hitResults[checkNumber] = hit;
                    checkNumber++;
                }
            }
        //TODO: передать hitResults
        } catch (NullPointerException | NumberFormatException e) {
            resp.setStatus(PROCESSING_ERROR_CODE);
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        LocalDateTime workTime = LocalDateTime.now(ZoneOffset.UTC);
//
//        double x = Double.parseDouble(req.getParameter("x"));
//        double y = Double.parseDouble(req.getParameter("yCoord"));
//        String[] r = req.getParameterValues("r[]");
//
//        for (String rElement: r) {
//            if (validate(x, y, Double.parseDouble(rElement))) {
//                resp.setStatus(477);
//            }
//        }
//    }

    private boolean isHit(double x, double y, double r) {
        //FIXME понять, как сделать путь короче
        String filePath = "C:\\java_senior\\web-lab-2\\src\\main\\java\\com\\grxuau\\weblab2\\skyrim.png";
        File image = new File(filePath);
        try {
            BufferedImage bufferedImage = ImageIO.read(image);

            AreaChecker areaChecker = new AreaChecker(bufferedImage);

            InputData inputData = new InputData(x, y, r);

            return areaChecker.checkHit(inputData);
            //FIXME Cannot read a file
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

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
