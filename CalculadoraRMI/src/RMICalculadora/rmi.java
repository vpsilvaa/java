package RMICalculadora;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class rmi extends UnicastRemoteObject implements Calculadora{
	public rmi() throws RemoteException{
		int a, b;
	}
	public int somar(int a, int b) throws RemoteException{
		return a+b;
	}
	public int subtrair(int a, int b) throws RemoteException{
		return a-b;
	}

}
