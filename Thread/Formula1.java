
package formula1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Formula1 implements Runnable{
    int volta = 0;
    long rubinho = 0;
    long massa = 0;
    public void run(){
        long tempoInicial = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            try {
            Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Formula1.class.getName()).log(Level.SEVERE, null, ex);
            }
            volta++;
        }
        long tempoFinal = System.currentTimeMillis();
        long TempoExecucao = (tempoFinal - tempoInicial);
        System.out.println("Tempo Massa = " + TempoExecucao + " ms");
        long tempoI = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            try {
            Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Formula1.class.getName()).log(Level.SEVERE, null, ex);
            }
            volta++;
        }
        long tempoF = System.currentTimeMillis();
        long TempoE = (tempoF - tempoI);
        System.out.println("Tempo Rubinho = " + TempoE + " ms");
        if(TempoE<TempoExecucao){
            System.out.println("Portanto Rubinho é o vencedor");
        }
        else if(TempoExecucao<TempoE){
            System.out.println("Portanto Massa é o vencedor");
        }
        else if(TempoExecucao==TempoE){
            System.out.println("Empate");
        }
    }
    
    
    public static void main(String[] args) {
         Formula1 p = new Formula1();
         Thread p1 = new Thread(p);
         p1.start();
         
         
    }
    
}
