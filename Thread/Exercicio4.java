
package exercicio4;

public class Exercicio4 implements Runnable{
    static int valor = 0;
    public void run(){
        int i;
        for(i=0;i<100;i++){
            
            System.out.println(valor);
            valor++;
        }
        valor = 0;
    }

   
    
    public static void main(String[] args) {
        
        Exercicio4 n = new Exercicio4();
        Thread n1 = new Thread(n);
        System.out.println(n1);
        n1.start();
        Exercicio4 u = new Exercicio4();
        Thread n2 = new Thread(u);
        System.out.println(n2);
        n2.start();
        
        
    }

    
}
