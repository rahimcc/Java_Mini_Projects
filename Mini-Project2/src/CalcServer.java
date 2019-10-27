
import java.net.*;
import java.io.*;

public class CalcServer {
    public static void main(String[] args) throws IOException {

        int portNumber = 2000; // specified port number to create server socket
        ServerSocket serverSocket = new ServerSocket(portNumber);  // creating server socket with portnumber to connect client
        Socket clientSocket = serverSocket.accept();  // server socket listens for clients
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // object to send information to client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // object to get information client

        String inputLine;
        int result = 0;
        String[] buffer;
        while ((inputLine = in.readLine()) != null) {  // reading the string that has been sent to the server by client
            char opr = '0';
            try {

                for (int i = 0; i < inputLine.length(); i++) {
                    if (inputLine.charAt(i) == '+' || inputLine.charAt(i) == '-' || inputLine.charAt(i) == '/' || inputLine.charAt(i) == '*') { // getting the operator
                        opr = inputLine.charAt(i);
                    }
                }
                if (opr == '0') {     //checking if the operator is incorrect
                    out.println("Unkown Operator");
                    continue;
                }

                switch (opr) {
                    case '+':
                        buffer = inputLine.split("\\+");  // spliting the string into two strings based on based on delimiter '+'
                        result = Integer.parseInt(buffer[0]) + Integer.parseInt(buffer[1]); // addittion
                        break;

                    case '-':
                        buffer = inputLine.split("-"); //spliting the string into two strings based on based on delimiter '-'
                        result = Integer.parseInt(buffer[0]) - Integer.parseInt(buffer[1]); //substraction
                        break;

                    case '/':
                        buffer = inputLine.split("/"); //  spliting the string into two strings based on based on delimiter '/'
                        result = Integer.parseInt(buffer[0]) / Integer.parseInt(buffer[1]); // division
                        break;

                    case '*':
                        buffer = inputLine.split("\\*"); //  spliting the string into two strings based on based on delimiter '*'
                        result = Integer.parseInt(buffer[0]) * Integer.parseInt(buffer[1]); // multiplication
                        break;

                }

                out.println(inputLine + "=" + result); // sending the result to the client


            } catch (NumberFormatException e) { // if parseInt tries convert any character other that number into integer
                out.println("Unkown Format");
            } catch (ArithmeticException e) {  // if user tries divide by 0 or any incorrect operation
                out.println("Arithmetic İnaccuracy");
            }
        }
    }
}