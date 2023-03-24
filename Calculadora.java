package calculadora;


import java.awt.GridLayout;
import javax.swing.*;


// Interface de uma calculadora

public class Calculadora extends JFrame{
    JFrame janela = new JFrame();
    JPanel painel = new JPanel();
    private JButton soma;
    private JButton subtrai;
    private JButton vezes;
    private JButton dividir;
    private JTextField campo;
    private GridLayout grid;
    private JButton apagar,ce,c,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;


    public Calculadora(){
        
        painel.setLayout(new GridLayout(5,4));
        
        campo = new JTextField("0");
        painel.add(campo);
        
        apagar = new JButton();
        apagar.setText("<=");
        painel.add(apagar);
        
        ce = new JButton();
        ce.setText("CE");
        painel.add(ce);
        
        c = new JButton();
        c.setText("C");
        painel.add(c);
        
        b7 = new JButton();
        b7.setText("7");
        painel.add(b7);
        
        b8 = new JButton();
        b8.setText("8");
        painel.add(b8);
        
        b9 = new JButton();
        b9.setText("9");
        painel.add(b9);
        
        dividir = new JButton();
        dividir.setText("/");
        painel.add(dividir);
        
        b4 = new JButton();
        b4.setText("4");
        painel.add(b4);
        
        b5 = new JButton();
        b5.setText("5");
        painel.add(b5);
        
        b6 = new JButton();
        b6.setText("6");
        painel.add(b6);
        
        vezes = new JButton();
        vezes.setText("*");
        painel.add(vezes);
        
        b1 = new JButton();
        b1.setText("1");
        painel.add(b1);
        
        b2 = new JButton();
        b2.setText("2");
        painel.add(b2);
        
        b3 = new JButton();
        b3.setText("3");
        painel.add(b3);
        
        subtrai = new JButton();
        subtrai.setText("-");
        painel.add(subtrai);
        
        b10 = new JButton();
        b10.setText(",");
        painel.add(b10);
        
        b0 = new JButton();
        b0.setText("0");
        painel.add(b0);
        
        b11 = new JButton();
        b11.setText("=");
        painel.add(b11);
        
        soma = new JButton();
        soma.setText("+");
        painel.add(soma);

        janela.setSize(450, 350);
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setVisible(true);
        janela.setTitle("Calculadora");
        janela.setBounds(0,0,450,400);
        janela.setLocationRelativeTo(null);
        janela.add(painel);
        
        
        
    }
    public static void main(String[] args) {
       Calculadora a = new Calculadora();
    }
    
}
