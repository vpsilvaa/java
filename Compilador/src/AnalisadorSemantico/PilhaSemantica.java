package AnalisadorSemantico;

import java.util.Stack;

public class PilhaSemantica {
	   static final int MAX = 100000;
	   int top;
	   Object a[] = new Object[MAX];  

	   public PilhaSemantica() {
	      top = -1;
	   }

	   public boolean isEmpty() {
	     if(top < 0) {
	    	 return true;
	     }else {
	    	 return false;
	     }
	   }
	   public boolean empilhar(Object x) {
	      if (top >= (MAX-1)) {
	         System.out.println("Estouro de Pilha!");
	         return false;
	      }
	      else {
	         a[++top] = x;
	         return true;
	      }
	   }
	   public Object desempilhar() {
	      if (top < 0) {
	         System.out.println("Pilha Vazia!");
	         return 0;
	      }
	      else {
	         a[top] = null;
	         top--;
	      }
		return a;
	   }
	   public void printPilhaS(PilhaSemantica p){
	       if (p.isEmpty()) {
	           return;
	       }
	       Object x = p.exibeUltimoValor();
	       p.desempilhar();
	       printPilhaS(p);
	       System.out.print(x + " ");
	       p.empilhar(x);
	   }
	   public void printPilha() {
		   int aux;
		   for(aux=0; aux<MAX; aux++) {
			   if(a[aux] == null) {
				   break;
			   }
			   System.out.print(a[aux] + ", ");
		   }
		   System.out.println();
	   }
	   public Object exibeUltimoValor() {
	      if (top < 0) {
	         System.out.println("Pilha Vazia!");
	         return 0;
	      }
	      else {
	         return a[top];
	      }
	   }
	}