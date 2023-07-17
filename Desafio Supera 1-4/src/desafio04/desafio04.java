package desafio04;

import java.util.*;

public class desafio04 {
	public class StringDecipher {

	    public static String decifrar(String aux) {
	        int tam = aux.length();
	        int metade = tam / 2;

	        String esquerda = aux.substring(0, metade);
	        String direita = aux.substring(metade);
	        StringBuilder esquerdaInvertida = new StringBuilder(esquerda).reverse();
	        StringBuilder direitaInvertida = new StringBuilder(direita).reverse();
	        String decifrado = esquerdaInvertida.toString() + direitaInvertida.toString();
	        return decifrado;
	    }

	    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	int n = sc.nextInt();
	    	sc.nextLine();
	    	int i;
	    	String[] string = new String[n];
	    	
	    	for(i=0;i<n;i++) {
	    		string[i] = sc.nextLine();
	    	}
	    	for (i=0;i<n;i++) {
	        	if(string[i].length()>=2 && string[i].length()<=100) {
	        		String aux1 = decifrar(string[i]);
	        		System.out.println(aux1);
	        	}
	        }
	    }
	}
}


