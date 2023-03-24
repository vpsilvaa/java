package empregado;


public class Empregado {
    public String nome;
    public String cargo;
    public double salario;
    public int idade;
	
    public Empregado() {
	this.nome = nome;
	this.cargo = cargo;
        this.salario = salario;
	this.idade = idade;
    }
	
    void setNome(String nome) {
        this.nome = nome;
    }
    void setCargo(String cargo) {
        this.cargo = cargo;
    }
    void setSalario(double salario) {
        this.salario = salario;
    }
    void setIdade(int idade) {
        this.idade = idade;
    }
    String getNome() {
        return nome;
    }
    String getCargo() {
        return cargo;
    }
    double getSalario() {
        return salario;
    }
    int getIdade() {
        return idade;
    }
    
    
}
