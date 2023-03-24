package exercicio2;

import java.util.Random;

// Ordenacao de numeros aleatorios
// ate 101 com bubbleSort, mergeSort, shellSort

public class Exercicio2 {
	public static void bubbleSort(int v[], int n) {
		int aux;
		for(int i = 0;i <n;i++) {
			for(int j=0;j < n-1 ; j++) {
				if(v[j] > v[j + 1]) {
					aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
				}
			}
		}
	}
	
	public static void merge (int V[], int inicio, int meio, int fim) {
		int temp[], p1, p2, tamanho, i, j, k;
		boolean fim1 = false, fim2 = false;
		tamanho = fim - inicio + 1;
		p1 = inicio;
		p2 = meio + 1;
		
		temp = new int[tamanho];
		
		for(i = 0; i < tamanho; i++) {
			if(!fim1 && !fim2) { 
				if(V[p1] < V[p2]) 
					temp[i] = V[p1++];
				else 
					temp[i] = V[p2++];
				
				if (p1 > meio) fim1 = true;
				if (p2 > fim) fim2 = true;
			}
			
			else {
				if(!fim1) 
					temp[i] = V[p1++];
				else 
					temp[i] = V[p2++];
			}
		}
		
		for(j = 0, k = inicio; j < tamanho; k++,j++) 
			V[k] = temp[j];	
	}
	
	static void mergeSort(int V[],int inicio, int fim) {
		int meio;
		if(inicio<fim) {
			meio = (inicio+fim)/2;
			mergeSort(V,inicio,meio);
			mergeSort(V,meio+1,fim);
			merge(V,inicio,meio,fim);
		}
	}
	
	static void shellSort(int v[], int n) {
		int h=1;
		do h=h*3 + 1;while (h < n);
		do {
			h=(h-1)/3;
			for(int i = h;i<n;i++) {
				int x = v[i];
				int j=i;
				while(v[j-h] > x) {
					v[j] = v[j-h];
					j -=h;
					if(j<h) break;
				}
				v[j] = x;
			}
		} while (h !=1);
	}
	
	public static void main(String[] args) {
                Random gerador = new Random();
                int inicio ,fim,j=0;
                float tempo;
		int[] vetor = new int[101],
                      vetor2 = new int[101],
                      vetor3 = new int[101];
                System.out.println("Números aleatórios:");
                for(int i=0;i<101;i++){
                    vetor[i] = gerador.nextInt();
                    vetor2[i] = gerador.nextInt();
                    vetor3[i] = gerador.nextInt();
                }
                /////////////////////////////////////////////////////
                inicio = (int) System.nanoTime();
                bubbleSort(vetor, 101);	
                fim = (int) System.nanoTime();
                tempo = fim-inicio;
		for(int i = 0; i < 101; i++) {
			System.out.print(vetor[i] + " ");
                }
                System.out.println();
                System.out.println("Tempo de execução bubbleSort:" + tempo);
                /////////////////////////////////////////////////////
                inicio = (int) System.nanoTime();
                mergeSort(vetor2, 0, 100);
                fim = (int) System.nanoTime();
                tempo = fim-inicio;
		for(int i = 0; i < 101; i++) {
			System.out.print(vetor2[i] + " ");
		}
                System.out.println();
                System.out.println("Tempo de execução mergeSort:" + tempo);
                ////////////////////////////////////////////////////
                inicio = (int) System.nanoTime();
                shellSort(vetor3, 101);	
                fim = (int) System.nanoTime();
                tempo = fim-inicio;
		for(int i = 0; i < 101; i++) {
			System.out.print(vetor3[i] + " ");
		}
                System.out.println();
                System.out.println("Tempo de execução shellSort:" + tempo);
                System.out.println();
                ///////////////////////////////////////////////////
                System.out.println("Números crescentes:");
                for(int i=0;i<101;i++){
                    vetor[i] = i+1;
                    vetor2[i] = i+1;
                    vetor3[i] = i+1;
                }
                /////////////////////////////////////////////////////
                inicio = (int) System.nanoTime();
                bubbleSort(vetor, 101);	
                fim = (int) System.nanoTime();
                tempo = fim-inicio;
		for(int i = 0; i < 101; i++) {
			System.out.print(vetor[i] + " ");
                }
                System.out.println();
                System.out.println("Tempo de execução bubbleSort:" + tempo);
                /////////////////////////////////////////////////////
                inicio = (int) System.nanoTime();
                mergeSort(vetor2, 0, 100);
                fim = (int) System.nanoTime();
                tempo = fim-inicio;
		for(int i = 0; i < 101; i++) {
			System.out.print(vetor2[i] + " ");
		}
                System.out.println();
                System.out.println("Tempo de execução mergeSort:" + tempo);
                ////////////////////////////////////////////////////
                inicio = (int) System.nanoTime();
                shellSort(vetor3, 101);	
                fim = (int) System.nanoTime();
                tempo = fim-inicio;
		for(int i = 0; i < 101; i++) {
			System.out.print(vetor3[i] + " ");
		}
                System.out.println();
                System.out.println("Tempo de execução shellSort:" + tempo);
                System.out.println();
                ///////////////////////////////////////////////////
                System.out.println("Números decrescentes:");
                for(int i=0;i<101;i++){
                    vetor[i] = j-1;
                    vetor2[i] = j-1;
                    vetor3[i] = j-1;
                    j--;
                }
                /////////////////////////////////////////////////////
                inicio = (int) System.nanoTime();
                bubbleSort(vetor, 101);	
                fim = (int) System.nanoTime();
                tempo = fim-inicio;
		for(int i = 0; i < 101; i++) {
			System.out.print(vetor[i] + " ");
                }
                System.out.println();
                System.out.println("Tempo de execução bubbleSort:" + tempo);
                /////////////////////////////////////////////////////
                inicio = (int) System.nanoTime();
                mergeSort(vetor2, 0, 100);
                fim = (int) System.nanoTime();
                tempo = fim-inicio;
		for(int i = 0; i < 101; i++) {
			System.out.print(vetor2[i] + " ");
		}
                System.out.println();
                System.out.println("Tempo de execução mergeSort:" + tempo);
                ////////////////////////////////////////////////////
                inicio = (int) System.nanoTime();
                shellSort(vetor3, 101);	
                fim = (int) System.nanoTime();
                tempo = fim-inicio;
		for(int i = 0; i < 101; i++) {
			System.out.print(vetor3[i] + " ");
		}
                System.out.println();
                System.out.println("Tempo de execução shellSort:" + tempo);
	}

}
