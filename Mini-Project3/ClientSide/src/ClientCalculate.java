import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.concurrent.TimeUnit;

public class ClientCalculate {

    public static void main(String[] args) {


        BufferedReader Stdin = new BufferedReader(new InputStreamReader(System.in)); // object to get input from user
        try {
            Registry registry1 = LocateRegistry.getRegistry(1099); // gettin reference to rmi registry

            CalculateInterface calc= (CalculateInterface) (registry1.lookup("Calculator")); // looking up remote object "Calculator"
            TimeUnit.SECONDS.sleep(2);
            System.out.println("*******YOU ARE CONNECED; TO THE SERVER******** "); // connection message
            System.out.println("******* FORMAT: NUMBER OPERATOR NUMBER *******");
            System.out.println("*******       exit TO TERMINATE      *******");
            String exp =null;


                System.out.println("Give the expression: ");
               while( ( exp = Stdin.readLine()) != null ) {   //getting input from user
                   if (exp.equals("exit"))  break; // checking if string equals to exit
                       int result = calc.CalculateExp(exp);  // getting result
                       if (result == -1) {
                           System.out.println("Unkown"); // printing error message
                           continue; }

                       System.out.println(exp + "=" + result);
                   }

            } catch (AccessException e1) {
            e1.printStackTrace();
        } catch (RemoteException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (NotBoundException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}