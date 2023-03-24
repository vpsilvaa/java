package orientacao;

import java.util.*;
import javax.swing.*;

/**
 * @author Lucas, Marco Ant�nio, Talysson, Vinicius, Vitor 
 * Classe principal do projeto final de AP2, do grupo 2, repons�vel pelo departamento de cursos de um sistema de gest�o acad�mico
 */

public class Curso extends Coisa{
	
    String situacao = "Curso desativado";  
    int cargaHorariaTotal;      
    int cargaHorariaTeoria;
    int cargaHorariaPratica;

    private static ArrayList<Curso> cursos = new ArrayList<Curso>();
    
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public String getNomeAbreviado() {
		return nomeAbreviado;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public int getCargaHorariaTeoria() {
		return cargaHorariaTeoria;
	}
	
	public int getCargaHorariaPratica() {
		return cargaHorariaPratica;
	}
	
	public int getCargaHorariaTotal() {
		return cargaHorariaTotal=cargaHorariaPratica+cargaHorariaTeoria;
	}

	public void setNomeCompleto() {
		String name = JOptionPane.showInputDialog("Nome completo do curso:");
                if(name.length()>0)this.nomeCompleto = name;
                else{
                    int a = 0;
                    while(a == 0){
                    	JOptionPane.showMessageDialog(null,"Nome INV�LIDO.","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
                        name = JOptionPane.showInputDialog("Nome completo do curso:");
                        if(name.length()>0){
                            this.nomeCompleto = name;
                            a++;
                        }
                        
                    }
                }
	}

	public void setNomeAbreviado() {
		String nameab = JOptionPane.showInputDialog(null,"Nome abrevaido do curso: ", "Ao menos 3 letras");
                if(nameab.length()>0)this.nomeAbreviado = nameab;
                else{
                    int a = 0;
                    while(a == 0){
                    	JOptionPane.showMessageDialog(null,"Nome INV�LIDO.","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
                        nameab = JOptionPane.showInputDialog("Nome abrevaido do curso: ","Ao menos, 3 letras");
                        if(nameab.length()>0){
                            this.nomeAbreviado = nameab;
                            a++;
                        }
                        
                    }
                }
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setCargaHorariaTeoria(int cargaHorariaTeoria) {
		this.cargaHorariaTeoria = cargaHorariaTeoria;
	}

	public void setCargaHorariaPratica(int cargaHorariaPratica) {
		this.cargaHorariaPratica = cargaHorariaPratica;
	}

	private void setCargaHorariaTotal(int i) {
		this.cargaHorariaTotal=i;
	}	

	/**
	 * @author Marco, Vinicius
	 * M�todo que gera um menu para a acessibilidade de outros m�todos contidos no c�digo
	 */
    public void menuCursos() {
		new Curso();
		boolean loopErroMenu=false;
    	while(loopErroMenu == false) {
    		try{
    			int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"1 - Cadastrar     \t2 - Consultar \n3 - Alterar           \t4 - Excluir\n5 - Cursos Cadastrados\nDigite a op��o:","MENU CURSOS",JOptionPane.INFORMATION_MESSAGE));
    			if(opcao==1) {
    				cadastrar();
    				loopErroMenu = true;
    			}if(opcao==2) {
    				consultar();
    				loopErroMenu = true;
    			}if(opcao==3) {
    				alterar();
    				loopErroMenu = true;
    			}if(opcao==4){
    				excluir();
    				loopErroMenu = true;
    			}if(opcao==5) {
    				listarCursos();
    				loopErroMenu = true;
    			}if(opcao!=1 && opcao!=2 && opcao!=3 && opcao!=4 && opcao!=5) {
    				JOptionPane.showMessageDialog(null,"Entrada inexistente, por favor tente novamente.","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
    				loopErroMenu = true;
    			}
    			
    		}catch(NumberFormatException e) {
    			JOptionPane.showMessageDialog(null,"Valor incorreto, tente novamente.","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }	
	/**
	 * @author Marco
	 * M�todo que recebe os par�metros necess�rios para a cria��o/cadastro de um curso no sistema.
	 * Recebe: Nome abreviado do curso (sigla), Nome completo, cargas horarias.
	 * Ao final do cadastro o m�todo atribui ao objeto um c�digo e o adiciona na lista array .
	 */
	public void cadastrar() {
        
        setNomeAbreviado();	
        
        setNomeCompleto();
        
        this.situacao = "Curso ativo";
                
        while(getCargaHorariaPratica()==0 && getCargaHorariaTeoria()==0) {
        	boolean loopErro3=false;
        	while(!loopErro3) {//validador da entrada de horas
        		try {
        			setCargaHorariaTeoria(Integer.parseInt(JOptionPane.showInputDialog("Insira a carga horaria de aula teorica:")));
        			loopErro3=true;
        		}catch(NumberFormatException e) {
        			
        			JOptionPane.showMessageDialog(null,"Valor incorreto, tente novamente.","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
        		}
        	}
        	boolean loopErro4=false;
        	while(!loopErro4) {//validador da entrada de horas
        		try {
        			setCargaHorariaPratica(Integer.parseInt(JOptionPane.showInputDialog("Insira a carga horaria de aula pratica:")));
        			loopErro4=true;
        		}catch(NumberFormatException e) {
        			JOptionPane.showMessageDialog(null,"Valor incorreto, tente novamente.","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);            	
        		}
        	}
        }
        
        Curso.adicionar(this);
        
        int ghostcod = cursos.size();
        for(int u = 1; u < cursos.size();u++ ){
            if(ghostcod == cursos.get(u).codigo )
            	ghostcod++;
        }     
        this.codigo = ghostcod;
              
        JOptionPane.showMessageDialog(null, "Nome: " +getNomeAbreviado()+" - " +getNomeCompleto()+"\nCarga horaria: "+getCargaHorariaTotal()+"h"+"\nC�digo: "+ghostcod);
        JOptionPane.showMessageDialog(null, "Curso adicionado ao sistema");
	}
     /**
      * @author Vitor
      * M�todo que altera as informa��es que um curso possui.
      * Recebe o c�digo:int para procura-lo na lista array e modificar as informa��es do curso.
      * Ap�s achar um curso com seu respectivo c�digo o programa pergunta ao usario quais atributos do mesmo ele deseja alterar.
      */
	 public void alterar() {
	        try{
	            int cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do curso que deseja alterar:"));
	            int x = 0;
                    int b = 0;
	            for (int s = 0; s < cursos.size(); s++){ 
                        if (cursos.get(s).codigo == (cod)){
	                    JOptionPane.showMessageDialog(null,"Codigo encontrado");
	                    x++;
	                    int i = Integer.parseInt(JOptionPane.showInputDialog("1 - Alterar o nome do curso\n"
	                    + "2 - Alterar a carga horaria teorica\n3 - Alterar a carga horaria pratica\n4 - "
	                    + "Alterar o nome abreviado do curso\n5 - Alterar a situa��o"));
	            
	                    if(i==1){
	                        try{
	                            
	                            cursos.get(s).setNomeCompleto();
	                            JOptionPane.showMessageDialog(null,"Valor alterado com sucesso"); 
	                            JOptionPane.showMessageDialog(null,"Codigo: "+cursos.get(s).codigo+"\nCurso: "+cursos.get(s).nomeAbreviado+" - "+cursos.get(s).nomeCompleto+"\nCarga horaria: "
	                                    +cursos.get(s).cargaHorariaTotal+"h"+"\nCarga horaria teorica: "+cursos.get(s).cargaHorariaTeoria+"h"+"\nCarga horaria pratica: "+cursos.get(s).cargaHorariaPratica+"h");
	                        }
	                        catch(NumberFormatException exception){
	                        JOptionPane.showMessageDialog(null,"Valor INCORRETO","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
	                        }
	                    }  
	                    if(i==2){
	                        try{
	                            int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo valor da carga teorica"));
	                            cursos.get(s).setCargaHorariaTeoria(n);
	                            int somaHoraTotal=cursos.get(s).getCargaHorariaPratica()+cursos.get(s).getCargaHorariaTeoria();
	                            cursos.get(s).setCargaHorariaTotal(somaHoraTotal);
	                            JOptionPane.showMessageDialog(null,"Valor alterado com sucesso");
	                            JOptionPane.showMessageDialog(null,"Codigo: "+cursos.get(s).codigo+"\nCurso: "+cursos.get(s).nomeAbreviado+" - "+cursos.get(s).nomeCompleto+"\nCarga horaria: "
	                                    +cursos.get(s).cargaHorariaTotal+"h"+"\nCarga horaria teorica: "+cursos.get(s).cargaHorariaTeoria+"h"+"\nCarga horaria pratica: "+cursos.get(s).cargaHorariaPratica+"h");
	                        }
	                        catch(NumberFormatException exception){
	                        JOptionPane.showMessageDialog(null,"Valor INCORRETO","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
	                        }
	                    }
	                    if(i==3){
	                        try{
	                            int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo valor da carga pratica"));        
	                            cursos.get(s).setCargaHorariaPratica(n);
	                            int somaHoraTotal=cursos.get(s).getCargaHorariaPratica()+cursos.get(s).getCargaHorariaTeoria();
	                            cursos.get(s).setCargaHorariaTotal(somaHoraTotal);  
	                            JOptionPane.showMessageDialog(null,"Valor alterado com sucesso");
	                            JOptionPane.showMessageDialog(null,"Codigo: "+cursos.get(s).codigo+"\nCurso: "+cursos.get(s).nomeAbreviado+" - "+cursos.get(s).nomeCompleto+"\nCarga horaria: "
	                                    +cursos.get(s).cargaHorariaTotal+"h"+"\nCarga horaria teorica: "+cursos.get(s).cargaHorariaTeoria+"h"+"\nCarga horaria pratica: "+cursos.get(s).cargaHorariaPratica+"h");
	                        }
	                        catch(NumberFormatException exception){
	                        JOptionPane.showMessageDialog(null,"Valor INCORRETO","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
	                        }  
	                    }
	                    if(i==4){
	                        try{
	                            
	                            cursos.get(s).setNomeAbreviado();
	                            JOptionPane.showMessageDialog(null,"Valor alterado com sucesso");
	                            JOptionPane.showMessageDialog(null,"Codigo: "+cursos.get(s).codigo+"\nCurso: "+cursos.get(s).nomeAbreviado+" - "+cursos.get(s).nomeCompleto+"\nCarga horaria: "
	                                    +cursos.get(s).cargaHorariaTotal+"h"+"\nCarga horaria teorica: "+cursos.get(s).cargaHorariaTeoria+"h"+"\nCarga horaria pratica: "+cursos.get(s).cargaHorariaPratica+"h");
	                        }
                             
                                
	                        catch(NumberFormatException exception){
	                        JOptionPane.showMessageDialog(null,"Valor INCORRETO","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
	                        }      
	                    }
                            if(i==5){
                                if((cursos.get(s).situacao == "Curso ativo")&&(b==0)){
                                    cursos.get(s).situacao = "Curso desativado";
                                    b++;
                                }
                                if((cursos.get(s).situacao == "Curso desativado")&&(b==0)){
                                    cursos.get(s).situacao = "Curso ativo";
                                    b++;
                                }   
                                JOptionPane.showMessageDialog(null,"Valor alterado com sucesso");
                                JOptionPane.showMessageDialog(null,"Codigo: "+cursos.get(s).codigo+"\nCurso: "+cursos.get(s).nomeAbreviado+" - "+cursos.get(s).nomeCompleto+"\nCarga horaria: "
                            +cursos.get(s).cargaHorariaTotal+"h"+"\nCarga horaria teorica: "+cursos.get(s).cargaHorariaTeoria+"h"+"\nCarga horaria pratica: "+cursos.get(s).cargaHorariaPratica+"h"+"\nSitua��o: "+cursos.get(s).situacao);
                            }
	                }
	            }
	            if(x == 0){
	                JOptionPane.showMessageDialog(null, "N�o foi possivel encontrar este codigo","Erro de preenchimento", JOptionPane.WARNING_MESSAGE);
	            }
	        }
	        catch(NumberFormatException exception){
	            JOptionPane.showMessageDialog(null,"Valor INCORRETO","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
	        }       
	    }
	 /**
	  * @author Vinicius
	  * M�todo usado para procurar dentro do sistema um curso qualquer.
	  * Procura o curso na lista array atrav�s de uma entrada do usu�rio, sendo ela o c�digo ou o nome.
	  * Retorna ao usu�rio por meio de um JOptionPane as informa��es do curso encontrado.
	  */
    public void consultar() {
    	int p = 0;
        while(p == 0){
          try{
            p = Integer.parseInt(JOptionPane.showInputDialog("1 - Pesquisar por codigo.\n2 - Pesquisar por nome."));
          }catch(Exception e){
            p = 0;
          }
          
          if(p == 1){
            int codigoc= -1;
            int n = cursos.size();
            while(codigoc < 0){
                try{
                  codigoc = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do curso:"));
                }catch(Exception e){
                  codigoc = -1;
                }
                if(codigoc >= 0){
                    int aux = 0;
                    for(int i = 0; i < n; i++){
                        if(codigoc == cursos.get(i).codigo){
                            JOptionPane.showMessageDialog(null,"Um curso encontrado com este codigo");
                            JOptionPane.showMessageDialog(null,"Codigo: "+cursos.get(i).codigo+"\nCurso: "+cursos.get(i).nomeAbreviado+" - "+cursos.get(i).nomeCompleto+"\nCarga horaria: "
                            +cursos.get(i).cargaHorariaTotal+"h"+"\nCarga horaria teorica: "+cursos.get(i).cargaHorariaTeoria+"h"+"\nCarga horaria pratica: "+cursos.get(i).cargaHorariaPratica+"h"+"\nSitua��o: "+cursos.get(i).situacao);
                            aux++;
                        } 
                    }
                    if(aux == 0){
                        JOptionPane.showMessageDialog(null,"N�o foi possivel encontrar um curso compativel com este codigo.","Erro de preenchimento",JOptionPane.WARNING_MESSAGE);
                    } 
                }
                
                if(codigoc < 0)
                	JOptionPane.showMessageDialog(null,"C�digo INCORRETO, tente novamente","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
     
            }
            
          }
        
          if(p == 2){
            String nome = "";
            int n = cursos.size();
            while( nome == ""){
                try{
                  nome = JOptionPane.showInputDialog("Digite o nome do curso: ","Pelo menos 3 letras");
                }catch(Exception e){
                  nome = "";
                }
                
                if(nome.length() > 2 ){
                    int aux = 0;
                    int aux2 = 0;
                    int aux3 = 0;
                    for(int i = 0; i < n; i++){
                        aux = 0;
                        if((nome.equalsIgnoreCase(cursos.get(i).nomeCompleto))||(nome.equalsIgnoreCase(cursos.get(i).nomeCompleto))){
                            JOptionPane.showMessageDialog(null,"Encontrou um curso com este nome!");
                            JOptionPane.showMessageDialog(null,"Codigo: "+cursos.get(i).codigo+"\nCurso: "+cursos.get(i).nomeAbreviado+" - "+cursos.get(i).nomeCompleto+"\nCarga horaria: "
                                    +cursos.get(i).cargaHorariaTotal+"h"+"\nCarga horaria teorica: "+cursos.get(i).cargaHorariaTeoria+"h"+"\nCarga horaria pratica: "+cursos.get(i).cargaHorariaPratica+"h"+"\nSitua��o: "+cursos.get(i).situacao);
                            aux3++;
                        }
                        else{
                            
                            char c;
                            char b;
                            int t = 0;
                            String compara;
                            String compara2;
                            if(nome.length() > cursos.get(i).nomeAbreviado.length() ){
                              for(int j = 0; j < cursos.get(i).nomeCompleto.length(); j++){
                                compara = cursos.get(i).nomeCompleto.toLowerCase();
                                b = compara.charAt(j);
                                t=0;
                                for(int u = 0; u < nome.length(); u++){
                                    compara2 = nome.toLowerCase();
                                    c = compara2.charAt(u);
                                    if((c == b)&&(t==0)){
                                      aux++;
                                      t++;
                                    }
                                }
                                    
                              }  
                              if(aux >= 4){
                            	  JOptionPane.showMessageDialog(null,"Codigo: "+cursos.get(i).codigo+"\nCurso: "+cursos.get(i).nomeAbreviado+" - "+cursos.get(i).nomeCompleto+"\nCarga horaria: "
                                          +cursos.get(i).cargaHorariaTotal+"h"+"\nCarga horaria teorica: "+cursos.get(i).cargaHorariaTeoria+"h"+"\nCarga horaria pratica: "+cursos.get(i).cargaHorariaPratica+"h"+"\nSitua��o: "+cursos.get(i).situacao);
                            	  aux2++; 
                              }
                            }
                          if(nome.length() <= cursos.get(i).nomeAbreviado.length() ){
                              for(int j = 0; j < cursos.get(i).nomeAbreviado.length(); j++){
                                compara = cursos.get(i).nomeAbreviado.toLowerCase();
                                b = compara.charAt(j);
                                t=0;
                                for(int u = 0; u < nome.length(); u++){
                                    compara2 = nome.toLowerCase();
                                    c = compara2.charAt(u);
                                    if((c == b)&&(t==0)){
                                      aux++;
                                      t++;
                                    }
                                }
                                    
                              }  
                              if(aux >= 2){
                            	JOptionPane.showMessageDialog(null,"Codigo: "+cursos.get(i).codigo+"\nCurso: "+cursos.get(i).nomeAbreviado+" - "+cursos.get(i).nomeCompleto+"\nCarga horaria: "
                                    +cursos.get(i).cargaHorariaTotal+"h"+"\nCarga horaria teorica: "+cursos.get(i).cargaHorariaTeoria+"h"+"\nCarga horaria pratica: "+cursos.get(i).cargaHorariaPratica+"h"+"\nSitua��o: "+cursos.get(i).situacao);
                                aux2++; 
                              }
                          }  
                        }
                        
                    }
                  if ((aux2 != 0)&&(aux3 == 0))
                      JOptionPane.showMessageDialog(null,"Encontrou "+aux2+" curso(s).");
                  if((aux2 == 0)&&(aux3 == 0))
                  		JOptionPane.showMessageDialog(null,"Nenhum curso encontrado","Erro de preenchimento",JOptionPane.WARNING_MESSAGE);
                  
                    } 
      
                if(nome.length() <= 2){
                    JOptionPane.showMessageDialog(null,"Quantidade inssuficiente de letras, tente novamente","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
                    nome = "";            
                }
            }   
          }
          
          if((p != 1) && (p != 2)){ 
        	  JOptionPane.showMessageDialog(null,"Valor INV�LIDO","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
             p = 0;         
          }
        }
     }
    /**
     * @author Lucas, Talysson, Vitor
     * M�todo utilizado para excluir do sistema um curso.
     * Zera os parametros de um curso na lista array. Deixando-o inativo.
     * O m�todo recebe o c�digo do curso que o usu�rio deseja excluir.
     */
    public void excluir() throws NumberFormatException {
        try{
            int i = Integer.parseInt(JOptionPane.showInputDialog("1 - Excluir por nome completo\n2 - Excluir por c�digo\n"
                + "3 - Excluir por nome abreviado"));
            int x = 0;
            int y = 0;
            if(i==1){
                try{
                    String cod = JOptionPane.showInputDialog("Digite o nome do curso que deseja remover:");
                    for (int s = 0; s < cursos.size(); s++){ 
                        if (cursos.get(s).nomeCompleto == null ? (cod) == null : cursos.get(s).nomeCompleto.equals(cod)){
                            JOptionPane.showMessageDialog(null,"Curso encontrado");
                            x++;
                            cursos.remove(cursos.get(s));
                            JOptionPane.showMessageDialog(null,"Curso removido");
                        }   
                    }
                    
                }
                catch(NumberFormatException e){
                	JOptionPane.showMessageDialog(null,"Valor INV�LIDO","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
                }
            
            }
            if(i==2){
                try{
                    int cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do curso que deseja remover:"));
                    for (int s = 0; s < cursos.size(); s++){ 
                        if (cursos.get(s).codigo == (cod)){
                            JOptionPane.showMessageDialog(null,"Curso encontrado");
                            x++;
                            cursos.remove(cursos.get(s));
                            JOptionPane.showMessageDialog(null,"Curso removido");
                        }   
                    }
                    
                }
                catch(NumberFormatException e){
                	JOptionPane.showMessageDialog(null,"Valor INV�LIDO","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
                }
            
            }
            
            if(i==3){
                try{
                    String cod = JOptionPane.showInputDialog("Digite o nome abreviado do curso que deseja remover:");
                    for (int s = 0; s < cursos.size(); s++){ 
                        if (cursos.get(s).nomeAbreviado == null ? (cod) == null : cursos.get(s).nomeAbreviado.equals(cod)){
                            JOptionPane.showMessageDialog(null,"Curso encontrado");
                            x++;
                            cursos.remove(cursos.get(s));
                            JOptionPane.showMessageDialog(null,"Curso removido");
                        }   
                    }
                    
                }
                catch(NumberFormatException e){
                	JOptionPane.showMessageDialog(null,"Valor INV�LIDO","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
                }
            
            }
            if((i!=1)&&(i!=2)&&(i!=3)){
                y++;
                throw new NumberFormatException(); 
            }
            if((x == 0)&&(y==0)){
            	JOptionPane.showMessageDialog(null,"N�o foi possivel encontrar este curso","Erro de preenchimento",JOptionPane.ERROR_MESSAGE);
            }
            
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Valor incorreto","Erro",JOptionPane.ERROR_MESSAGE);
        }
        
    }
	/**
	 * @author Marco
	 * M�todo que adiciona um curso a lista array.
	 * � chamado no m�todo cadastrar()
	 * @param c
	 */
	public static void adicionar(Curso c) { 
		cursos.add(c);
	}
	
	/**
	 * @author Marco
	 * M�todo chamado pelo listarCursos() para imprimir na tela as informa��es de um curso
	 */
	public void dadosCurso(){
	       JOptionPane.showMessageDialog(null,"Codigo: "+codigo+"\nCurso: "+getNomeAbreviado()+" - "+getNomeCompleto()+"\nCarga horaria: "
	                                    +getCargaHorariaTotal()+"h"+"\nCarga horaria teorica: "+getCargaHorariaTeoria()+"h"+"\nCarga horaria pratica: "+getCargaHorariaPratica()+"h"+"\nSitua��o: "+situacao);
	}
	/**
	 * @author Marco, Vinicius
	 * Imprime todos os cursos, atraves de um loop for enhanced, da lista array
	 */
	public static void listarCursos(){
		if (cursos.size()==0) {
			JOptionPane.showMessageDialog(null,"N�o possui cursos cadastrados no momento","Erro",JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null,+cursos.size()+" curso(s) cadastrado(s)");
		}
		
		for(Curso c: cursos){
			c.dadosCurso();
		}
		
	}	
	
}
