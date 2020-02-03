/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintapplet;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mohamed-Suliman
 */
public class Rectangle extends Shape {

   private boolean filled;

    public Rectangle() {
        super();
        this.filled = false;
    }

    public Rectangle(int x1, int y1, int x2, int y2,Color color ,boolean filled) {
        super(x1, y1, x2, y2,color);
        this.filled = filled;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if (filled) {
            g.fillRect(x1, y1, x2 - x1, y2 - y1);
        } else {
            g.drawRect(x1, y1, x2 - x1, y2 - y1);
        }
    }

}
