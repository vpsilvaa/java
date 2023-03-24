package ordenaçãodecrescente;

public class OrdenaçãoDecrescente {

    public static void bubbleSort(int v[], int n) {
		int aux;
		for(int i = 0;i <n;i++) {
			for(int j=0;j < n-1 ; j++) {
				if(v[j] < v[j + 1]) {
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
				if(V[p1] > V[p2]) 
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
				while(v[j-h] < x) {
					v[j] = v[j-h];
					j -=h;
					if(j<h) break;
				}
				v[j] = x;
			}
		} while (h !=1);
	}
	static void quickSort(int V[], int inicio, int fim) {
		int pivo;
		if(fim>inicio) {
			pivo = particiona(V,inicio,fim);
			quickSort(V,inicio,pivo-1);
			quickSort(V,pivo+1,fim);
		}
	}
	static int particiona(int V[], int inicio, int fim) {
		int esq, dir, pivo,aux;
		esq = inicio+1;
		dir = fim;
		pivo = V[inicio];
		while(esq <=dir) {
			if(V[esq]>= pivo)
				esq++;
			else if(V[dir] < pivo)
				dir--;
			else if(esq < dir) {
				aux = V[esq];
				V[esq] = V[dir];
				V[dir] = aux;
				esq++;
				dir--;
			}
		}
		V[inicio] = V[dir];
		V[dir] = pivo;
		return dir;
	}
	static void selectionSort(int V[],int n) {
		int menor, troca;
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
	static void insertionSort(int V[], int n) {
		int i, j, aux;
		for(i = 1;i<n;i++) {
			aux = V[i];
			for(j=i;(j>0) && (aux>V[j-1]); j--)
				V[j] = V[j-1];
			V[j] = aux;
		}
	}
	public static void main(String[] args) {
		int[] vetor1 = {2,1,5,10,2}, vetor2 = {3,2,4,10,6},
                      vetor3 = {7,4,5,1,10}, vetor4 = {4,7,1,5,2},
                      vetor5 = {4,2,1,5,10}, vetor6 = {4,5,1,10,3};
                mergeSort(vetor1, 0, 4);
                System.out.println("mergeSort: ");
		for(int i = 0; i < 5; i++) {
			System.out.print(vetor1[i] + " ");
		}
                selectionSort(vetor2, 5);
                System.out.println("\nselectionSort: ");
                for(int i = 0; i < 5; i++) {
			System.out.print(vetor2[i] + " ");
		}
                insertionSort(vetor3, 5);
                System.out.println("\ninsertionSort: ");
                for(int i = 0; i < 5; i++) {
			System.out.print(vetor3[i] + " ");
		}
                shellSort(vetor4, 5);
                System.out.println("\nshellSort: ");
                for(int i = 0; i < 5; i++) {
			System.out.print(vetor4[i] + " ");
		}
                bubbleSort(vetor5, 5);
                System.out.println("\nbubbleSort: ");
                for(int i = 0; i < 5; i++) {
			System.out.print(vetor5[i] + " ");
		}
                quickSort(vetor6, 0, 4);
                System.out.println("\nquickSort: ");
                for(int i = 0; i < 5; i++) {
			System.out.print(vetor6[i] + " ");
		}
	}
}
