package orientacao;

public abstract class Coisa {
	
	int codigo;
	String nomeAbreviado;
	String nomeCompleto;

	public abstract void cadastrar ();
	public abstract void alterar ();
	public abstract void consultar ();
	public abstract void excluir ();
	
}