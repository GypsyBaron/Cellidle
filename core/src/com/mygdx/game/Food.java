package com.mygdx.game;

public class Food {
    private float x;
    private float y;
    private float width;
    private int colorR;
    private int colorG;
    private int colorB;

    public Food(float x, float y, float width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public Food(float x, float y, float width, int colorR, int colorG, int colorB) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public void setX(float x) {
        this.x = x;
    }

    public int getColorR() {
        return colorR;
    }

    public void setColorR(int colorR) {
        this.colorR = colorR;
    }

    public int getColorG() {
        return colorG;
    }

    public void setColorG(int colorG) {
        this.colorG = colorG;
    }

    public int getColorB() {
        return colorB;
    }

    public void setColorB(int colorB) {
        this.colorB = colorB;
    }

    public Food() {

    }


    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = (float)x;
    }

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = (float)y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
