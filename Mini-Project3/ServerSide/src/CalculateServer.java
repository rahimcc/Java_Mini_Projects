import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;

public class CalculateServer {
        public static void main (String[] argv){
            try {
                System.setProperty("java.security.policy","file:./security.policy"); // setting security policy
                Calculate object = new Calculate (); // creating remote object from class Calculate
                Registry registry= LocateRegistry.getRegistry(1099); // gets the reference to the rmi registry on the default port 1099
                registry.rebind("Calculator",object); //Sending object to rmi registry with layer "Calculator"
                TimeUnit.SECONDS.sleep(2);
                System.out.println("************* CALCULATOR SERVER IS READY ************* ");
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
