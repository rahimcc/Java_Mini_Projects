import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculateInterface extends Remote {
    int CalculateExp (String s) throws RemoteException; // method to be used remotely
}
