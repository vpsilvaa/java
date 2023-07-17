package desafio01;

import java.util.*;

public class desafio01 {
	
	static void selectionSortC(double V[],int n) {
		int menor;
		double troca;
		for(int i = 0;i<n-1; i++) {
			menor=i;
			for(int j=i+1;j<n;j++) {
				if(V[j]<V[menor])
					menor = j;
			}
			troca = V[i];
			V[i] = V[menor];
			V[menor] = troca;
		}
	}
	
	static void selectionSortD(double V[],int n) {
		int menor;
		double troca;
		for(int i = 0;i<n-1; i++) {
			menor=i;
			for(int j=i+1;j<n;j++) {
				if(V[j]>V[menor])
					menor = j;
			}
			troca = V[i];
			V[i] = V[menor];
			V[menor] = troca;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aux = sc.nextInt();
		int aux2=0, aux3=0;
		int i, pa = 0, imp = 0;
		double num[] = new double[1000000];
		double impar[] = new double[1000000];
		double par[] = new double[1000000];
		
		if(aux>1 && aux<=1000000) {
			for(i=1;i>0;i++) {
				num[i] = sc.nextDouble();
				if(num[i] % 2 == 0) {
					par[aux2] = num[i];
					pa++;
					aux2++;
				}
				else {
					impar[aux3] = num[i];
					aux3++;
					imp++;
				}
				if (i == aux) break;
			}
			selectionSortC(par, pa);
			for(i = 0; i < pa; i++) {
				System.out.print(par[i] + "\n");
			}
			selectionSortD(impar, imp);
            for(i = 0; i < imp; i++) {
            	System.out.print(impar[i] + "\n");
            }
		}
	}

}
