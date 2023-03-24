
package conta;

import java.util.Scanner;
public class Conta {
    public int saldo,deposita,limite;

    public void saca(float valor){
            if (valor>saldo)
            {
                ContaExcecao s = new ContaExcecao();
            }
            saldo -= valor;
        
    }
    public void deposita(int deposita){
        this.deposita = deposita;
    }
    public void setLimite(int limite){
        this.limite = limite;
    }
    public void saldo(int saldo){
        this.saldo = saldo;
    }

    


    
    public static void main(String[] args) {
        Conta minhaConta = new Conta();
        minhaConta.deposita(100);
        minhaConta.setLimite(100);
        minhaConta.saca(1000);

        
    }

    
    
}
