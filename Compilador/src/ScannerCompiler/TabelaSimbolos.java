package ScannerCompiler;

import java.util.ArrayList;

public class TabelaSimbolos {
	public static ArrayList<String> preencheTabelaSimbolos() {
		ArrayList<String> palavrasres = new ArrayList<String>();
		palavrasres.add("inicio");
		palavrasres.add("varinicio");
		palavrasres.add("varfim");
		palavrasres.add("escreva");
		palavrasres.add("leia");
		palavrasres.add("se");
		palavrasres.add("entao");
		palavrasres.add("fimse");
		palavrasres.add("fim");
		palavrasres.add("inteiro");
		palavrasres.add("literal");
		palavrasres.add("real");
		return palavrasres;
	}
	
	public ArrayList<String> insert(String c, ArrayList<String> aux){
		ArrayList<String> palavrasres = aux;
		palavrasres.add(c);
		return palavrasres;
	}

}
