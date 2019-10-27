import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    private Random rand;

    public static void main(String[] args) throws InterruptedException {

        JFrame myFrame = new JFrame();
        myFrame.getContentPane().setBackground(Color.WHITE);
        myFrame.setLayout(new GridLayout(2, 5));
        myFrame.setSize(700, 200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(3);


        Circle[] myCircleArray = new Circle[5];

        myCircleArray[0] = new Circle("ST", 10, 10);
        myCircleArray[1] = new Circle("IT2", 10, 10);
        myCircleArray[2] = new Circle("IT1", 10, 10);
        myCircleArray[3] = new Circle("IT3", 10, 10);
        myCircleArray[4] = new Circle("WT", 10, 10);

        buffer[] myBufferArray = new buffer[4];

        myBufferArray[0] = new buffer("B1", 90, 10);
        myBufferArray[1] = new buffer("B2", 90, 10);
        myBufferArray[2] = new buffer("B3", 90, 10);
        myBufferArray[3] = new buffer("B4", 90, 10);

        myFrame.add(myCircleArray[0]);
        myFrame.add(myCircleArray[1]);
        myFrame.add(myCircleArray[2]);
        myFrame.add(myCircleArray[3]);
        myFrame.add(myCircleArray[4]);

        myFrame.add(myBufferArray[0]);
        myFrame.add(myBufferArray[1]);
        myFrame.add(myBufferArray[2]);
        myFrame.add(myBufferArray[3]);

        Random rand=new Random();

        int i = 0;
        int j= 0;
        while (true) {
            int numb= rand.nextInt(2000);
            if (i == 5){
                i = 0;

            }
            if (j == 5) j = 0;


            if (myCircleArray[i].isActive==true) {
                myCircleArray[i].recieve(numb);
            } else {
                if (i != 4)
                myBufferArray[i].recieve();
            }


                     if (i > 2 || j!=0) {
                             if (myCircleArray[j].isActive==true) {
                                       myCircleArray[j].recieve(numb);
                                          j++;
                             }else {
                                 j++;
                                 if (j!=5)
                              myBufferArray[j].recieve();
                                  }
            }
            Thread.sleep(1000);
            i++;
        }
    }
}







