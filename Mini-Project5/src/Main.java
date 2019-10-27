import javax.swing.*;
import java.awt.*;

//BY DEFAULT COLOR IS WHITE !!!


public class Main {

    public static void main(String arg[]){
        JFrame myFrame= new JFrame();
        myFrame.setDefaultCloseOperation(3);
        myFrame.setSize(500,500);
        Edit e = new Edit();
        MenuBar menuBar= new MenuBar(e,myFrame);
        myFrame.setJMenuBar(menuBar.getMenuBar());
        myFrame.setContentPane(e);
        myFrame.setBackground(Color.WHITE);
      e.setBackground(Color.WHITE);
        myFrame.setVisible(true);




        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                e.addMouseListener(e);   // setting panel e to be sensible MouseEvent
                e.addMouseMotionListener(e);
            }
        });
    }
}
