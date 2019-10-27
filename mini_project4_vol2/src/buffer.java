import javax.swing.*;
import java.awt.*;

public class buffer extends JPanel  {
    int x , y ;
    String s;
    Color color = Color.ORANGE;


    public buffer(String s , int x , int y ){
        this.x=x;
        this.y=y;
        this.s=s;
    }


    public void paintComponent(Graphics g) {
                g.setColor(color);
                g.drawOval(x, y, 30, 30);
                g.fillOval(x, y, 30,30);
                g.setColor(Color.BLACK);
                g.drawString(s, x + 10, y + 20);
    }



    public void recieve() throws InterruptedException {
        color = Color.green;
        repaint();
        new java.util.Timer().schedule( new java.util.TimerTask() {
                                            @Override
                                            public void run() {
                                                color = Color.ORANGE;
                                                repaint();
                                            }
                                        },1000
        );

    }

}
