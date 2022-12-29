package com.grxuau.weblab2.area;

import com.grxuau.data.InputData;

import java.awt.image.BufferedImage;

public class AreaChecker {
    private final BufferedImage image;

    public AreaChecker(BufferedImage image) {
        this.image = image;
    }

    public boolean checkHit(InputData inputData) {
        try {
            int pixel = getPixel(inputData);
            return checkPixelBelongToArea(pixel);
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private int getPixel(InputData inputData) {
        int pixelColumn = getPixelColumn(image, inputData.getX(), inputData.getR());
        int pixelRow = getPixelRow(image, inputData.getY(), inputData.getR());

        return image.getRGB(pixelColumn, pixelRow);
    }

    private boolean checkPixelBelongToArea(int pixelColour) {
        return pixelColour == -16449;
    }

    private int getPixelColumn(BufferedImage image, double x, double r) {
        int widthPx = image.getWidth();
        double pixelColumn = ((r + x) / (2 * r)) * widthPx;
        return (int) Math.round(pixelColumn);
    }

    private int getPixelRow(BufferedImage image, double y, double r) {
        int heightPx = image.getHeight();
        double pixelRow = ((r - y) / (2 * r)) * heightPx;
        return (int) Math.round(pixelRow);
    }
}
