import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Figure extends JPanel {
    Color c = Color.CYAN;
boolean isOval;


public Figure (Color c, boolean isOval){
    this.c=c;
    this.isOval=isOval;
}


public void paintComponent(Graphics g){
     super.paintComponent(g);
        g.setColor(c);
         if (isOval)   g.fillOval(0,0,50,50);  //drawing oval
         else g.fillRect(0,0,50,50);  // drawing rectangle
    }
}

