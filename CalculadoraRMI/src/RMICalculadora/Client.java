package RMICalculadora;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import javax.swing.*;
 
public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 5555);
			Calculadora aux1 = (Calculadora)Naming.lookup("rmi://localhost:5555/Calculadora");
			String menu = JOptionPane.showInputDialog("Digite 1 para soma e 2 para subtração");
		switch(menu) {
			
			case "1":{
				int x = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro valor"));
				int y = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo valor"));
				JOptionPane.showMessageDialog(null, "Resultado da soma é : " + aux1.somar(x,y));
				break;
		}
			case "2":{
				int x = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro valor"));
				int y = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo valor"));JOptionPane.showMessageDialog(null, "Server conectado");
				JOptionPane.showMessageDialog(null, "Resultado da subtração é : " + aux1.subtrair(x,y));
				break;
		}
		}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro de conexão. " + e);
		}

	}

}
