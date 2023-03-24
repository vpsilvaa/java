package calculadora;

import java.util.Scanner;

public class calc {
    public static void bubbleSortc(Empregado v[], int n) {
		Empregado aux = new Empregado();
		for(int i = 0;i <n;i++) {
			for(int j=0;j < n-1 ; j++) {
				if(v[j].getNome().compareTo(v[j+1].getNome())> 0) {
					aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
				}
			}
		}
	}
	
	public static void mergec (Empregado V[], int inicio, int meio, int fim) {
		int p1, p2, tamanho, i, j, k;
		boolean fim1 = false, fim2 = false;
		tamanho = fim - inicio + 1;
                Empregado[] temp = new Empregado[tamanho];
                for(int aux = 0;aux<tamanho;aux++){
                    temp[aux] = new Empregado();
                }
		p1 = inicio;
		p2 = meio + 1;
		
		for(i = 0; i < tamanho; i++) {
			if(!fim1 && !fim2) { 
				if(V[p1].getNome().compareTo(V[p2].getNome()) < 0) 
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
	
	static void mergeSortc(Empregado V[],int inicio, int fim) {
		int meio;
		if(inicio<fim) {
			meio = (inicio+fim)/2;
			mergeSortc(V,inicio,meio);
			mergeSortc(V,meio+1,fim);
			mergec(V,inicio,meio,fim);
		}
	}
	
	static void shellSortc(Empregado v[], int n) {
		int h=1;
                Empregado x = new Empregado();
		do h=h*3 + 1;while (h < n);
		do {
			h=(h-1)/3;
			for(int i = h;i<n;i++) {
				x = v[i];
				int j=i;
				while(v[j-h].getNome().compareTo(x.getNome()) > 0) {
					v[j] = v[j-h];
					j -=h;
					if(j<h) break;
				}
				v[j] = x;
			}
		} while (h !=1);
	}
	static void quickSortc(Empregado V[], int inicio, int fim) {
		int pivo;
		if(fim>inicio) {
			pivo = particionac(V,inicio,fim);
			quickSortc(V,inicio,pivo-1);
			quickSortc(V,pivo+1,fim);
		}
	}
	static int particionac(Empregado V[], int inicio, int fim) {
		int esq, dir;
                Empregado aux = new Empregado();
		esq = inicio+1;
		dir = fim;
                Empregado pivo = new Empregado();
		pivo = V[inicio];
		while(esq <=dir) {
			if(V[esq].getNome().compareTo(pivo.getNome()) <= 0)
				esq++;
			else if(V[dir].getNome().compareTo(pivo.getNome()) > 0)
				dir--;
			else if(esq<dir) {
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
	static void selectionSortc(Empregado V[],int n) {
		int menor;
                Empregado troca = new Empregado();
		for(int i = 0;i<n-1; i++) {
			menor=i;
			for(int j=i+1;j<n;j++) {
				if(V[j].getNome().compareTo(V[menor].getNome()) < 0)
					menor = j;
			}
			troca = V[i];
			V[i] = V[menor];
			V[menor] = troca;
		}
	}
	static void insertionSortc(Empregado V[], int n) {
		int i, j;
                Empregado aux = new Empregado();
		for(i = 1;i<n;i++) {
			aux = V[i];
			for(j=i;(j>0) && (aux.getNome().compareTo(V[j-1].getNome()) < 0); j--)
				V[j] = V[j-1];
			V[j] = aux;
		}
	}
        public static void bubbleSortd(Empregado v[], int n) {
		Empregado aux = new Empregado();
		for(int i = 0;i <n;i++) {
			for(int j=0;j < n-1 ; j++) {
				if(v[j].getNome().compareTo(v[j+1].getNome()) < 0) {
					aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
				}
			}
		}
	}
	
	public static void merged (Empregado V[], int inicio, int meio, int fim) {
		int  p1, p2, tamanho, i, j, k;
		boolean fim1 = false, fim2 = false;
		tamanho = fim - inicio + 1;
		p1 = inicio;
		p2 = meio + 1;
		Empregado[] temp = new Empregado[tamanho];
                for(int aux = 0;aux<tamanho;aux++){
                    temp[aux] = new Empregado();
                }
		
		for(i = 0; i < tamanho; i++) {
			if(!fim1 && !fim2) { 
				if(V[p1].getNome().compareTo(V[p2].getNome()) > 0) 
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
	
	static void mergeSortd(Empregado V[],int inicio, int fim) {
		int meio;
		if(inicio<fim) {
			meio = (inicio+fim)/2;
			mergeSortd(V,inicio,meio);
			mergeSortd(V,meio+1,fim);
			merged(V,inicio,meio,fim);
		}
	}
	
	static void shellSortd(Empregado v[], int n) {
		int h=1;
                Empregado x = new Empregado();
		do h=h*3 + 1;while (h < n);
		do {
			h=(h-1)/3;
			for(int i = h;i<n;i++) {
				x = v[i];
				int j=i;
				while(v[j-h].getNome().compareTo(x.getNome()) < 0) {
					v[j] = v[j-h];
					j -=h;
					if(j<h) break;
				}
				v[j] = x;
			}
		} while (h !=1);
	}
	static void quickSortd(Empregado V[], int inicio, int fim) {
		int pivo;
		if(fim>inicio) {
			pivo = particionad(V,inicio,fim);
			quickSortd(V,inicio,pivo-1);
			quickSortd(V,pivo+1,fim);
		}
	}
	static int particionad(Empregado V[], int inicio, int fim) {
		int esq, dir;
                Empregado pivo = new Empregado();
                Empregado aux = new Empregado();
		esq = inicio+1;
		dir = fim;
		pivo = V[inicio];
		while(esq <=dir) {
			if(V[esq].getNome().compareTo(pivo.getNome())>= 0)
				esq++;
			else if(V[dir].getNome().compareTo(pivo.getNome()) < 0)
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
	static void selectionSortd(Empregado V[],int n) {
		int menor;
                Empregado troca = new Empregado();
		for(int i = 0;i<n-1; i++) {
			menor=i;
			for(int j=i+1;j<n;j++) {
				if(V[j].getNome().compareTo(V[menor].getNome()) > 0)
					menor = j;
			}
			troca = V[i];
			V[i] = V[menor];
			V[menor] = troca;
		}
	}
	static void insertionSortd(Empregado V[], int n) {
		int i, j;
                Empregado aux = new Empregado();
		for(i = 1;i<n;i++) {
			aux = V[i];
			for(j=i;(j>0) && (aux.getNome().compareTo(V[j-1].getNome()) > 0); j--)
				V[j] = V[j-1];
			V[j] = aux;
		}
	}
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        double inicio,fim,temp;
        String cargo, nome;
        int idade;
        double salario;
		Empregado vetor[] = new Empregado[3];
		vetor[0] = new Empregado();
		vetor[1] = new Empregado();
		vetor[2] = new Empregado();
		
		for(int i = 0;i<3;i++) {
			System.out.println("Digite o nome do " + i);
			nome = sc.next();
			vetor[i].setNome(nome);
			
			System.out.println("Digite o cargo do " + i);
			cargo = sc.next();
			vetor[i].setCargo(cargo);
			
			System.out.println("Digite o salario do " + i);
			salario = sc.nextDouble();
			vetor[i].setSalario(salario);
			
			System.out.println("Digite a idade do " + i);
			idade = sc.nextInt();
			vetor[i].setIdade(idade);
			System.out.println();
		}
                
                System.out.println("Se deseja ordenar em ordem crescente( digite 1), em ordem decrescente( digite 2)");
                int ordem = sc.nextInt();
                if(ordem == 1){
                    System.out.println("1 - SelectionSort\n2 - InsertionSort\n3 - ShellSort\n4 - BubbleSort\n"
                            + "5 - MergeSort\n6 - QuickSort\n");
                    int tipo = sc.nextInt();
                    if(tipo == 1){
                        inicio = System.nanoTime();
                        selectionSortc(vetor,3);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                    else if(tipo == 2){
                        inicio = System.nanoTime();
                        insertionSortc(vetor,3);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                    else if(tipo == 3){
                        inicio = System.nanoTime();
                        shellSortc(vetor,3);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                    else if(tipo == 4){
                        inicio = System.nanoTime();
                        bubbleSortc(vetor,3);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                    else if(tipo == 5){
                        inicio = System.nanoTime();
                        mergeSortc(vetor,0, 2);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                    else if(tipo == 6){
                        inicio = System.nanoTime();
                        quickSortc(vetor,0, 2);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                }
                else if(ordem == 2){
                    System.out.println("1 - SelectionSort\n2 - InsertionSort\n3 - ShellSort\n4 - BubbleSort\n"
                            + "5 - MergeSort\n6 - QuickSort\n");
                    int tipo = sc.nextInt();
                    if(tipo == 1){
                        inicio = System.nanoTime();
                        selectionSortd(vetor,3);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                    else if(tipo == 2){
                        inicio = System.nanoTime();
                        insertionSortd(vetor,3);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                    else if(tipo == 3){
                        inicio = System.nanoTime();
                        shellSortd(vetor,3);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                    else if(tipo == 4){
                        inicio = System.nanoTime();
                        bubbleSortd(vetor,3);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                    else if(tipo == 5){
                        inicio = System.nanoTime();
                        mergeSortd(vetor,0, 2);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                    else if(tipo == 6){
                        inicio = System.nanoTime();
                        quickSortd(vetor,0, 2);
                        fim = System.nanoTime();
                        temp = fim-inicio;
                        for(int aux = 0;aux<3;aux++){
                            System.out.println(vetor[aux].getNome() + " ");   
                        }
                        System.out.println("Tempo executado: " + temp);
                    }
                }
    
    }
}
