package desafio03;

import java.util.Scanner;

public class desafio03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		int res=0,aux2=0, aux = 0,aux3, aux4;
		while(aux != n) {
			arr[aux] = sc.nextInt();
			aux++;
		}
		for(aux2=0;aux2<n;aux2++){
			for(aux3=0;aux3<n;aux3++){
				aux4 = arr[aux2]-arr[aux3];
				if(aux4 == k) {
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
