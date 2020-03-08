package com.mygdx.game;

public class Cell {

    private float x;
    private float y;
    private float width;
    private int stepSize;

    public Cell(float x, float y, float width, int stepSize) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.stepSize = stepSize;
    }

    public int getStepSize() {
        return this.stepSize;
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
