package calculadora;

import javax.swing.JOptionPane;

public class VetorPessoas extends Pessoas{
    
    public static void bubbleSort(Pessoas[] v, int n) {
    	Pessoas aux;
		for(int i = 0;i <n;i++) {
			for(int j=0;j < n-1 ; j++) {
				if(v[j].getAltura() > v[j + 1].getAltura()) {
					aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
				}
			}
		}
    }
    
    public static void maiorAltura(Pessoas[] v, int n){
    	Pessoas aux = v[0]; 
		for(int i = 0;i <n;i++) {
			for(int j=0;j < n-1 ; j++) {
				if(v[j+1].getAltura() > aux.getAltura()) {
                                    aux = v[j+1];
				}
			}
		}
        JOptionPane.showMessageDialog(null,"Pessoa com maior altura:" + aux.getNomeCompleto());
    }
    
    public static void merge (Pessoas[] V, int inicio, int meio, int fim) {
		int p1, p2, tamanho, i, j, k;
		Pessoas[] temp;
		boolean fim1 = false, fim2 = false;
		tamanho = fim - inicio + 1;
		p1 = inicio;
		p2 = meio + 1;
		
		temp = new Pessoas[tamanho];
		
		for(i = 0; i < tamanho; i++) {
			if(!fim1 && !fim2) { 
				if(V[p1].getPeso() > V[p2].getPeso()) 
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
	
    public static void mergeSort(Pessoas[] V,int inicio, int fim) {
		int meio;
		if(inicio<fim) {
			meio = (inicio+fim)/2;
			mergeSort(V,inicio,meio);
			mergeSort(V,meio+1,fim);
			merge(V,inicio,meio,fim);
		}
    }
        
    public static void menorPeso(Pessoas[] v, int n){
    	Pessoas aux = v[0] ;
        for(int i = 0;i <n;i++){
            for(int j=0;j < n-1 ; j++){
                if(v[j+1].getPeso() < aux.getPeso()){
                    aux = v[j+1]; 
                }
            }
        }
        JOptionPane.showMessageDialog(null,"Pessoa com menor peso:" + aux.getNomeCompleto());
    }
    
    public static void main(String[] args) {
        int j = 0;
        Pessoas[] vetor = new Pessoas[100];
        do{
            vetor[j] = new Pessoas();
            vetor[j].setNomeCompleto(JOptionPane.showInputDialog("Digite o nome"));  
            vetor[j].setAltura(Double.parseDouble(JOptionPane.showInputDialog("Digite a altura"))); 
            vetor[j].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso"))); 
            j++;
        }while(JOptionPane.showConfirmDialog(null,"Cadastrar mais pessoas?", "exercicio", 
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == 0);
               
        maiorAltura(vetor,j);
        
        menorPeso(vetor,j);
        
        bubbleSort(vetor,j);
        System.out.println("Ordenados de forma crescente de acordo com a altura");
        for(int h = 0;h<j;h++){
            System.out.println(vetor[h].getNomeCompleto());
        }
        
        mergeSort(vetor,0,j+1);
        System.out.println("Ordenados de forma decrescente de acordo com o peso");
        for(int h = 0;h<j;h++){
            System.out.println(vetor[h].getNomeCompleto());
        }
    }
    
}
