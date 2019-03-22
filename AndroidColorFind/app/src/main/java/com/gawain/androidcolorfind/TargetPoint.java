package com.gawain.androidcolorfind;

public class TargetPoint {
    private int pointWidth, pointHeight;
    private int pointRed, pointGreen, pointBlue;
    private int checkPointNumber;

    public TargetPoint(int pointWidth, int pointHeight, int pointRed, int pointGreen, int pointBlue, int checkPointNumber) {
        this.pointWidth = pointWidth;
        this.pointHeight = pointHeight;
        this.pointRed = pointRed;
        this.pointGreen = pointGreen;
        this.pointBlue = pointBlue;
        this.checkPointNumber = checkPointNumber;
    }

    public int getPointWidth() {
        return pointWidth;
    }

    public void setPointWidth(int pointWidth) {
        this.pointWidth = pointWidth;
    }

    public int getPointHeight() {
        return pointHeight;
    }

    public void setPointHeight(int pointHeight) {
        this.pointHeight = pointHeight;
    }

    public int getPointRed() {
        return pointRed;
    }

    public void setPointRed(int pointRed) {
        this.pointRed = pointRed;
    }

    public int getPointGreen() {
        return pointGreen;
    }

    public void setPointGreen(int pointGreen) {
        this.pointGreen = pointGreen;
    }

    public int getPointBlue() {
        return pointBlue;
    }

    public void setPointBlue(int pointBlue) {
        this.pointBlue = pointBlue;
    }

    public int getCheckPointNumber() {
        return checkPointNumber;
    }

    public void setCheckPointNumber(int checkPointNumber) {
        this.checkPointNumber = checkPointNumber;
    }
}
