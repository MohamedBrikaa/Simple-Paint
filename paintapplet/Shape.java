/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapplet;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    protected Color color;

    public Shape() {
        x1 = y1 = x2 = y2 = 0;
        color = Color.BLACK;
    }

    public Shape(int x1, int y1, int x2, int y2,Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color=color;
    }

    public void setCord(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
    
    public Color getColor() {
       return color;
    }

    public abstract void draw(Graphics g);
}