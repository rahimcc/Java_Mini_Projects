package Sources;

import Sources.Counter;

import java.util.Scanner;

public class TestCounter {
    public static void main (String args[]){
        System.out.print("Give a non-negative integer: "); // prompting to get number from user
        Scanner input= new Scanner(System.in);
        int n= input.nextInt();

        Thread t1= new Counter("Computer Science", n); // 4 object of the same Thread class with different name
        Thread t2= new Counter("Chemical Engineering ",n);
        Thread t3= new Counter("Petroleum",n);
        Thread t4= new Counter("Geophysics",n);

        t1.start();  //invoking 4 thread objects concurrently
        t2.start();
        t3.start();
        t4.start();

    }
}
