import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.jar.JarEntry;

public class Edit extends JPanel implements MouseListener,MouseMotionListener,Serializable {
   boolean isOval=true;
   public String state="Create";
   Figure figure;
   private int Xinit, MouseX;
   private int Yinit, MouseY;
   public Color c = Color.WHITE;
   Component component;


   public void paintComponent(Graphics g){
        super.paintComponent(g);
         }

     @Override

     public void mouseClicked(MouseEvent e) {
         MouseX=e.getX();
         MouseY=e.getY();

         if (state=="Create") CreateItem(); // creates figure on MouseX,MouseY
          repaint();


    }

    @Override
    public void mousePressed(MouseEvent e) {
        Xinit=e.getX();
        Yinit=e.getY();
        component=getComponentAt(Xinit,Yinit);
        switch (state) {
            case "Remove":
                remove(component); //removes component that user clicked
                repaint();
                break;
            case "Change": ChangeColor(component); //changes the color pressed component
            break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MouseX=e.getX();
        MouseY=e.getY();
        switch (state) {
            case "Move":
                MoveItem(e); // moves selected figure while dragging
                break;
            case "Create":
                CreateItem(); // creates multiple panels while dragging
                break;
            case "Remove":
                component = getComponentAt(MouseX, MouseY);
                remove(component); // removes the components that comes on its while draggin
                break;
        }
            repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void MoveItem (MouseEvent me) {   //moves the component

        if (component != this) {  // if selected component is not main canvas
            int x = me.getX();
            int y = me.getY();
            component.setLocation(x - 25, y - 25); // settin new location selected component
        }
    }

   public void CreateItem (){   //creates new component
            setLayout(null);
            figure=new Figure(c,isOval); // creates either oval or rectangle based on state of isOval
            add(figure);
            figure.setLocation(MouseX-25,MouseY-25);
            figure.setBounds(MouseX-25,MouseY-25,50,50);
            figure.setOpaque(false); // to make created panel to be transparent
        }

        public void ChangeColor(Component c) {
            ((Figure) c).c=this.c; // changing color
    }
    }

