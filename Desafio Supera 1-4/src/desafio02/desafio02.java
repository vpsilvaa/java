package desafio02;

import java.util.*;

public class desafio02 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int centavos = (int) Math.round(x * 100);
        int NotasDe100 = centavos / 10000;
        centavos %= 10000;
        int NotasDe50 = centavos / 5000;
        centavos %= 5000;
        int NotasDe20 = centavos / 2000;
        centavos %= 2000;
        int NotasDe10 = centavos / 1000;
        centavos %= 1000;
        int NotasDe5 = centavos / 500;
        centavos %= 500;
        int NotasDe2 = centavos / 200;
        centavos %= 200;
        int MoedasDe1 = centavos / 100;
        centavos %= 100;
        int MoedasDe50 = centavos / 50;
        centavos %= 50;
        int MoedasDe25 = centavos / 25;
        centavos %= 25;
        int MoedasDe10 = centavos / 10;
        centavos %= 10;
        int MoedasDe05 = centavos / 5;
        centavos %= 5;
        int MoedasDe01 = centavos;

        System.out.println("NOTAS:");
        System.out.println(NotasDe100 + "\t" + "nota(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "100.00");
        System.out.println(NotasDe50 + "\t" + "nota(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "50.00");
        System.out.println(NotasDe20 + "\t" + "nota(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "20.00");
        System.out.println(NotasDe10 + "\t" + "nota(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "10.00");
        System.out.println(NotasDe5 + "\t" + "nota(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "5.00");
        System.out.println(NotasDe2 + "\t" + "nota(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "2.00");
        System.out.println("MOEDAS:");
        System.out.println(MoedasDe1 + "\t" + "moeda(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "1.00");
        System.out.println(MoedasDe50 + "\t" + "moeda(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "0.50");
        System.out.println(MoedasDe25 + "\t" + "moeda(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "0.25");
        System.out.println(MoedasDe10 + "\t" + "moeda(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "0.10");
        System.out.println(MoedasDe05 + "\t" + "moeda(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "0.05");
        System.out.println(MoedasDe01 + "\t" + "moeda(s)" + "\t" + "de" + "\t" + "R$" + "\t" + "0.01");
    }
}
