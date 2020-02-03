package paintapplet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class PaintApplet extends Applet {

    String currentPainting = "line";
    Shape s;
    List<Shape> shapesArray = new ArrayList<>();
    Button[] buttonArray = new Button[9];

    int startXPoint;
    int startYPoint;

    Button lineButton;
    Button rectButton;
    Button ovalButton;
    Button greenButton;
    Button redButton;
    Button blueButton;
    Button filledButton;
    Button notFilledButton;
    Button clearAllButton;

    boolean filled = false;
    Color color = Color.BLACK;

    public void init() {
        lineButton = new Button("line");
        rectButton = new Button("Rectangle");
        ovalButton = new Button("Oval");
        filledButton = new Button("Fill");
        notFilledButton = new Button("NotFill");
        greenButton = new Button("Green");
        redButton = new Button("red");
        blueButton = new Button("blue");
        clearAllButton = new Button("ClearAll");

        add(lineButton);
        add(rectButton);
        add(ovalButton);
        add(filledButton);
        add(notFilledButton);
        add(greenButton);
        add(redButton);
        add(blueButton);
        add(clearAllButton);

        addButtonsActionsListeners();
        this.addMouseListener(new mouseActionHandler());
        this.addMouseMotionListener(new mouseActionHandler());
        resize(1000, 500);
    }

    public void paint(Graphics g) {
        drawShapesArray(g);
        s.draw(g);
    }

    private void drawShapesArray(Graphics g) {
        for (int i = 0; i < shapesArray.size(); i++) {
            shapesArray.get(i).draw(g);
        }
    }

    private void addButtonsActionsListeners() {

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPainting = "line";
            }
        });
        rectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPainting = "rect";
            }
        });
        ovalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPainting = "oval";
            }
        });

        filledButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled = true;
            }
        });
        notFilledButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filled = false;
            }
        });
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.GREEN;
            }
        });
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.RED;
            }
        });
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.BLUE;
            }
        });
        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapesArray.clear();
                repaint();
            }
        });
    }

    class mouseActionHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (currentPainting.equals("line")) {
                s = new Line(e.getX(), e.getY(), e.getX(), e.getY(), color);
            } else if (currentPainting.equals("rect")) {
                s = new Rectangle(e.getX(), e.getY(), e.getX(), e.getY(), color, filled);
            } else if (currentPainting.equals("oval")) {
                s = new Oval(e.getX(), e.getY(), e.getX(), e.getY(), color, filled);
            }
            startXPoint = s.getX1();
            startYPoint = s.getY1();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            shapesArray.add(s);
            if (currentPainting.equals("line")) {
                s = new Line();
            } else if (currentPainting.equals("rect")) {
                s = new Rectangle();
            } else if (currentPainting.equals("oval")) {
                s = new Oval();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            s.setX1(startXPoint);
            s.setY1(startYPoint);
            s.setX2(e.getX());
            s.setY2(e.getY());
            if (!currentPainting.equals("line")) {
                if (s.getX2() < s.getX1()) {
                    s.setX1(s.getX2());
                    s.setX2(startXPoint);
                }
                if (s.getY2() < s.getY1()) {
                    s.setY1(s.getY2());
                    s.setY2(startYPoint);
                }
            }
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
}
