
package questao2;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Questao2 {

    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int x = 0 , y = 1;
        double r = (x / y);
        System.out.println("Eu sei dividir!");
        System.out.println("Informe o primeiro valor:");
        try{
            x = teclado.nextInt();
            System.out.println("Informe o segundo valor:");
            try{
                y = teclado.nextInt();
                try{
                r = (x / y);
                System.out.println("O resultado eh: "+ r);
                }
                catch(ArithmeticException exception){
                    System.out.println("Excecao denominador = 0");        
                }
            }
            catch(InputMismatchException exception){
                    System.out.println("Excecao não eh numero inteiro");
            }
        }
        catch(InputMismatchException exception){
            System.out.println("Excecao nao eh numero inteiro");
        }
        
    }
    
}
