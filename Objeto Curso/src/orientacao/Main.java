package orientacao;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
	    ArrayList<Curso> cursom = new ArrayList<Curso>();	
            Curso curso = new Curso();
		for (int i = 0; i <= cursom.size(); ++i) {
		    curso = new Curso();
		     cursom.add(curso);
                     cursom.get(i).menuCursos();
                     
		}
                
                
               	 
	}
}