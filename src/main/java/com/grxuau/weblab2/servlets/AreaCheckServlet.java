package com.grxuau.weblab2.servlets;

import com.grxuau.data.InputData;
import com.grxuau.weblab2.area.AreaChecker;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
//TODO: добавить полную валидацию на случай отключения JavaScript'a!
@WebServlet("/area-check-servlet")
public class AreaCheckServlet extends HttpServlet {
    //FIXME проверить, содержит ли запрос координаты точки
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime workTime = LocalDateTime.now(ZoneOffset.UTC);

        double x = Double.parseDouble(req.getParameter("xCoord"));
        double y = Double.parseDouble(req.getParameter("yCoord"));
        //FIXME: скорее всего здесь будет падать
        String r = req.getParameter("rCoord");
//
//        if (validate(x, y, r)) {
//            resp.setStatus(400);
//        }
//
//        boolean status = isHit()


    }

    private boolean isHit(float x, float y, float r) {
        File image = new File("skyrim.png");
        try {
            BufferedImage bufferedImage = ImageIO.read(image);

            AreaChecker areaChecker = new AreaChecker(bufferedImage);

            InputData inputData = new InputData( x, y,  r);

            return areaChecker.checkHit(inputData);
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
