import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.util.Random;
import javax.swing.*;
import java.util.*;


public class Circle extends JPanel {
    boolean isActive = true;
    private String s;
    private int x;
    private int y;
    Color color=Color.CYAN;


    public Circle(String s, int x, int y) {
        this.s = s;
        this.x = x;
        this.y = y;
    }


    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, 50, 50);
        g.fillOval(x, y, 50, 50);
        g.setColor(Color.BLACK);
        g.drawString(s, x + 15, y + 30);
    }


    public void recieve(int numb) {
        Random rand =new Random();
        color = Color.green;
        repaint();
        new java.util.Timer().schedule( new java.util.TimerTask() {
                                            @Override
                                            public void run() {
                                               sleep(numb);
                                            }
                                        },1000
        );
    }


    public void sleep(int num) {
        color = Color.red;
        repaint();
        isActive=false;
        new java.util.Timer().schedule( new java.util.TimerTask() {
                    @Override
                    public void run() {

                        color = Color.CYAN;
                        repaint();
                        isActive=true;

                    }
                },num
        );
        }

}



