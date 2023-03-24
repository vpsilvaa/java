package estudante;

import java.util.Scanner;
public class Estudante {
    private String nome;
    private String matricula;
    private String cpf;
    private String dataDeNascimento;
    
    public Estudante(String nome, String matricula, String cpf,String dataDeNascimento){
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public String getMatricula(){
        return matricula;
    }
    public String getDataDeNascimento(){
        return dataDeNascimento;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public void setDataDeNascimento(String dataDeNascimento){
        this.dataDeNascimento = dataDeNascimento;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome ");
        String n = sc.nextLine();
        System.out.println("Digite a matricula ");
        String m = sc.nextLine();
        System.out.println("Digite o cpf ");
        String c = sc.nextLine();
        System.out.println("Digite a data de nascimento ");
        String d = sc.nextLine();
        Estudante i = new Estudante(n,m,c,d);
        i.setNome(n);
        i.setMatricula(m);
        i.setDataDeNascimento(d);
        i.setCpf(c);
        System.out.println("\nNome aluno: " + i.getNome());
        System.out.println("Matricula: " + i.getMatricula());
        System.out.println("Cpf: " + i.getCpf());
        System.out.println("Data de Nascimento: " + i.getDataDeNascimento());
        
        
        
        
        
       
    }
    
}
