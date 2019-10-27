import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class Circle extends JPanel {
    String s;
    int x;
    int y;
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

    public void recieve() {
        color = Color.green;
        repaint();
    }


    public void sleep() throws InterruptedException {
        Random rand = new Random();
        color = Color.red;
        repaint();
        new java.util.Timer().schedule(new java.util.TimerTask() {
                                           @Override
                                           public void run() {
                                               color = Color.CYAN;
                                               repaint();

                                           }
                                       }, rand.nextInt(2000)
        );

    }
    public void displayLast() {
            color = Color.CYAN;
            repaint();
    }


}



