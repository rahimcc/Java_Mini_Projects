package Sources;

import java.util.Random;

public class Counter extends Thread {
    private String s;  //name of Thread
    private int n;    //number to print to
    static int i=1;

    public Counter(String s, int n) { //Constructor for class Counter
        this.s = s;
        this.n = n;
    }


    @Override
    public void run() {
        Random r = new Random();  // object of Class Random to get a random number
        for (int j = 0; j < n;) {
            System.out.printf("%s %d\n", s,j); // printing
            j++;
            if (j==n) break; // if statement to break for loop when it is in last period of printing with this statement we prevent program to sleep
            try { // try catch block as method sleep throws InteruptedException
                sleep(r.nextInt(5000)); // sleeping randomly between 0-5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        {
            System.out.printf("Tread %s ended, completion order %d\n", s, i++);//end message with completion order
        }
    }
}


