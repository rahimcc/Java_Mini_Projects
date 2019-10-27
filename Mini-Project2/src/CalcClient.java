
import java.io.*;
import java.net.*;

public class CalcClient {
    public static void main(String[] args) throws IOException {

   
        InetAddress hostName = InetAddress.getLocalHost(); // getting IP of local machine to create socket
        int portNumber = 2000; // specified portnumber to make connetion the sever with same port number

        try (
                Socket CalcSocket = new Socket(hostName, portNumber); // creating socket for client
                PrintWriter out = new PrintWriter(CalcSocket.getOutputStream(), true);  // sends information to server
                BufferedReader in = new BufferedReader(new InputStreamReader(CalcSocket.getInputStream())); // receives information from server
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)) // standart I/O object between user and computer
        )    {
            if (CalcSocket.isConnected()){ // checking if client has connected to the server and printing connection message
                System.out.println("*******************        YOU ARE CONNECTED TO THE SERVER          *******************");
                System.out.println("******************* FORMAT: NUMBER OPERATOR NUMBER (WITHOUT SPACES) *******************");
                System.out.println("*******************            WARNING:WITHOUT SPACES               *******************");
                System.out.println("*******************              'exit' TO TERMINATE                *******************");
                }
            System.out.print("Here goes expression: "); // ask user to give expression
            String userInput;
            while ((userInput = stdIn.readLine()) != null) { // getting the expression as a string and assigning it to variable userInput
                if(userInput.equals("exit")) break; // terminating while loop if user want to exit
                out.println(userInput); //sending expression to the server
                System.out.println("Result: " + in.readLine()); // printing result that has been sent by server
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName); // if host is unknown or user give wrong hostname
            System.exit(1); }
            catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName); // if there is a problem in connection between server and clien
            System.exit(1);
        }
    }
}