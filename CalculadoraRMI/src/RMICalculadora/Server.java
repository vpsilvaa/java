package RMICalculadora;

import java.rmi.*;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class Server {
	
	public static void main(String[] args) {
		
		try {
			Registry aux = java.rmi.registry.LocateRegistry.createRegistry(5555);
			aux.rebind("Calculadora", new rmi());
			JOptionPane.showMessageDialog(null, "Server conectado");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro de conexão. " + e);
		}
		
	}

}
