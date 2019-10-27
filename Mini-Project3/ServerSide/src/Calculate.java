import java.rmi.*;
import java.rmi.server.*;


public class Calculate extends UnicastRemoteObject implements CalculateInterface {


    Calculate() throws RemoteException { }

    @Override
    public int CalculateExp(String s) throws RemoteException {
        char opr = '0'; //initializing opr to 0
        int result = -1;
        String[] buffer;
        try {

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '*') { //gets the operator assings it to variable;
                    opr = s.charAt(i);
                }
            }

            if (opr== '0') {  //checks if operator is equal to 0
                System.out.println("Unkown Operator"); //printing error message
                return -1;
            }

            switch (opr) {
                case '+':
                    buffer = s.split("\\+"); // splitting expression based operator
                    result = Integer.parseInt(buffer[0]) + Integer.parseInt(buffer[1]);  // calculation
                    break;

                case '-':
                    buffer = s.split("-");
                    result = Integer.parseInt(buffer[0]) - Integer.parseInt(buffer[1]);// calculation
                    break;

                case '/':
                    buffer = s.split("/");
                    result = Integer.parseInt(buffer[0]) / Integer.parseInt(buffer[1]);// calculation
                    break;

                case '*':
                    buffer = s.split("\\*");
                    result = Integer.parseInt(buffer[0]) * Integer.parseInt(buffer[1]);// calculation
                    break;
            }
                return result ;
        } catch (NumberFormatException e) {
            System.out.println("Unkown Format"); // if operand is diffetent than integer
        } catch (ArithmeticException e){
            System.out.println("Arithmetic Inaccuracy"); // if user tries to divide to 0
        }
return result;

    }

}
