import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main (String[] args) throws InterruptedException {

        JFrame myFrame = new JFrame();
        myFrame.getContentPane().setBackground(Color.WHITE);
        myFrame.setLayout(new GridLayout(2,5));

        myFrame.setSize(700,200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(3);


        Circle[] myCircleArray= new Circle[5];

        myCircleArray[0]= new Circle("ST",10,10);
        myCircleArray[1]= new Circle("IT2",10,10);
        myCircleArray[2]= new Circle("IT1",10,10);
        myCircleArray[3]= new Circle("IT3",10,10);
        myCircleArray[4]= new Circle("WT",10,10);


        buffer[] myBufferArray= new buffer[4];

        myBufferArray[0]= new buffer("B1",90,10);
        myBufferArray[1]= new buffer("B2",90,10);
        myBufferArray[2]= new buffer("B3",90,10);
        myBufferArray[3]= new buffer("B4",90,10);



        myFrame.add (myCircleArray[0]);
        myFrame.add (myCircleArray[1]);
        myFrame.add (myCircleArray[2]);
        myFrame.add (myCircleArray[3]);
        myFrame.add (myCircleArray[4]);

            myFrame.add(myBufferArray[0]);
            myFrame.add(myBufferArray[1]);
            myFrame.add(myBufferArray[2]);
            myFrame.add(myBufferArray[3]);

        int i=0;

        while (true) {
            if (i==5) i=0;
            myCircleArray[i].recieve();
            Thread.sleep(500);

            if (i!=4) {
                myCircleArray[i].sleep();

                myBufferArray[i].recieve();
            } else {
                myCircleArray[i].displayLast();
            }
                i++;
        }
        }
    }


