package RMICalculadora;

import java.rmi.*;

public interface Calculadora extends Remote {
	public int somar(int a, int b) throws RemoteException;
	public int subtrair(int a, int b) throws RemoteException;

}
