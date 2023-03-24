package AnalisadorSemantico;

import java.util.ArrayList;
import ScannerCompiler.ScannerCompiler;
import ScannerCompiler.Token;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalisadorSemantico extends PilhaSemantica{
	private ScannerCompiler scanner; 
	private Token token; 
	FileWriter arq = null;
	PilhaSemantica s = new PilhaSemantica();
	int aux=0;
	String TIPO, ARG, OPRD, CAB, OPRD2;
	String LD, LDtype;
	int aux2=0,aux5=0;
	int aux6=1;
	int currentToken = 0;
	int cabecalho=0;
	int variaveis = 0;
	String[] temporarias = new String[1000];
	String[] EXP_R = new String[1000];
	int aux3 = 0, tempValor = 0;
	
	public void recebeTokens(ArrayList<Token> tokens) throws IOException{
		ArrayList<Token> Tokens2 = new ArrayList<Token>();
		Tokens2 = tokens;
		int i;
		for(i=0;i<Tokens2.size();i++) {
			if(Tokens2.get(i).getClass().equals("inicio") ||
				Tokens2.get(i).getClass().equals("varinicio")) {
				currentToken++;
			}
		}
	}

	public void semantico(String regra, ArrayList<Token> tokens) throws IOException{
		try {
			arq = new FileWriter("C:\\Users\\Vitor\\eclipse-workspace\\Compilador\\programa.c", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter gravarArq = new PrintWriter(arq);
		ArrayList<Token> Tokens2 = new ArrayList<Token>();
		ArrayList<Token> TokensSM = new ArrayList<Token>();
		Tokens2 = tokens;
		if(cabecalho==0) {
			gravarArq.printf("#include<stdio.h>\r\n"
					+ "typedef char literal[256];\r\n"
					+ "void main(void){\n");
			cabecalho=1;
		}
		if(variaveis ==0) {
			gravarArq.printf("/*----Variaveis temporarias----*/\n");
			int currentToken3=0;
			while(currentToken3<Tokens2.size()) {
				if(Tokens2.get(currentToken3).getClasse().equals("OPA") ||
					Tokens2.get(currentToken3).getClasse().equals("OPR")) {
					gravarArq.printf("int T" + aux6 + ";\n");
					aux6++;
				}
				currentToken3++;
			}
			variaveis =1;
			gravarArq.printf("/*--------------------------*/\n");
		}
		
		if(regra.equals("P→ inicio V A")) {
			
		}
		else if(regra.equals("V→ varinicio LV")) {
			
		}
		else if(regra.equals("LV→ D LV")) {
			
		}
		else if(regra.equals("LV→ varfim pt_v")) {
			gravarArq.printf(" ");
			gravarArq.printf(" ");
			gravarArq.printf(" ");
			while(true) {
				if(Tokens2.get(currentToken).getClasse().equals("escreva")) {
					break;
				}
				currentToken++;
			}
		}
		else if(regra.equals("D→ TIPO L pt_v")) {
			while(currentToken<Tokens2.size()) {
				if(aux2 == 1) {
					aux2 = 0;
					break;
				}
				if(TIPO == "inteiro" && Tokens2.get(currentToken).getClasse().equals("ID")) {
					Tokens2.get(currentToken).setType("inteiro");
					break;
				}
				else if(TIPO == "real" && Tokens2.get(currentToken).getClasse().equals("ID")) {
					Tokens2.get(currentToken).setType("real");
					break;
				}
				else if(TIPO == "literal" && Tokens2.get(currentToken).getClasse().equals("ID")) {
					Tokens2.get(currentToken).setType("literal");
					break;
				}
				currentToken++;
			}
			if(Tokens2.get(currentToken).getClasse().equals("PT_V")) {
				currentToken++;
			}
			
		}
		else if(regra.equals("L→ id vir L")) {
			aux2 = 1;
			if(TIPO == "inteiro" && Tokens2.get(currentToken).getClasse().equals("ID")) {
				Tokens2.get(currentToken).setType("inteiro");
				currentToken++;
				currentToken++;
				Tokens2.get(currentToken).setType("inteiro");
				int currentToken2 = currentToken;
				while(currentToken2<Tokens2.size()) {
					if(Tokens2.get(currentToken2).getLexema().equals(Tokens2.get(currentToken).getLexema())) {
						Tokens2.get(currentToken2).setType("inteiro");
					}
					currentToken2++;
				}
			}
			else if(TIPO == "real" && Tokens2.get(currentToken).getClasse().equals("ID")) {
				Tokens2.get(currentToken).setType("real");
				currentToken++;
				currentToken++;
				Tokens2.get(currentToken).setType("real");
				int currentToken2 = currentToken;
				while(currentToken2<Tokens2.size()) {
					if(Tokens2.get(currentToken2).getLexema().equals(Tokens2.get(currentToken).getLexema())) {
						Tokens2.get(currentToken2).setType("real");
					}
					currentToken2++;
				}
			}
			else if(TIPO == "literal" && Tokens2.get(currentToken).getClasse().equals("ID")) {
				Tokens2.get(currentToken).setType("literal");
				currentToken++;
				currentToken++;
				Tokens2.get(currentToken).setType("literal");
				int currentToken2 = currentToken;
				while(currentToken2<Tokens2.size()) {
					if(Tokens2.get(currentToken2).getLexema().equals(Tokens2.get(currentToken).getLexema())) {
						Tokens2.get(currentToken2).setType("literal");
					}
					currentToken2++;
				}
			}
			currentToken++;
			if(Tokens2.get(currentToken).getClasse().equals("PT_V")) {
				currentToken++;
			}
		}
		else if(regra.equals("L→ id")) {
			if(Tokens2.get(currentToken+1).getClasse().equals("VIR")) {
				gravarArq.printf(" " + Tokens2.get(currentToken).getLexema() + "," + Tokens2.get(currentToken+2).getLexema() + ";\n");
			}
			else {
				gravarArq.printf(" " + Tokens2.get(currentToken).getLexema() + ";\n");
			}
			
		}
		else if(regra.equals("TIPO→ inteiro")) {
			while(currentToken<Tokens2.size()) {
				if(Tokens2.get(currentToken).getClasse().equals("ID") && Tokens2.get(currentToken).getType().equals("null")) {
					Tokens2.get(currentToken).setType("inteiro");
					TIPO = "inteiro";
					int currentToken2=0;
					while(currentToken2<Tokens2.size()) {
						if(Tokens2.get(currentToken2).getLexema().equals(Tokens2.get(currentToken).getLexema())) {
							Tokens2.get(currentToken2).setType("inteiro");
						}
						currentToken2++;
					}
					TokensSM = Tokens2;
					if(Tokens2.get(currentToken+1).getClasse().equals("VIR")) {
						Tokens2.get(currentToken+2).setType("inteiro");
						TIPO = "inteiro";
						TokensSM = Tokens2;
					}
					gravarArq.printf(" int");
					break;
				}
				aux++;
				currentToken++;
			}
	
		}
		else if(regra.equals("TIPO→ real")) {
			while(currentToken<Tokens2.size()) {
				if(Tokens2.get(currentToken).getClasse().equals("ID") && Tokens2.get(currentToken).getType().equals("null")) {
					Tokens2.get(currentToken).setType("real");
					TIPO = "real";
					int currentToken2=0;
					while(currentToken2<Tokens2.size()) {
						if(Tokens2.get(currentToken2).getLexema().equals(Tokens2.get(currentToken).getLexema())) {
							Tokens2.get(currentToken2).setType("real");
						}
						currentToken2++;
					}
					TokensSM = Tokens2;
					if(Tokens2.get(currentToken+1).getClasse().equals("VIR")) {
						Tokens2.get(currentToken+2).setType("real");
						TIPO = "real";
						TokensSM = Tokens2;
					}
					gravarArq.printf(" double");
					break;
				}
				aux++;
				currentToken++;
			}
	
		}
		else if(regra.equals("TIPO→ literal")) {
			while(currentToken<Tokens2.size()) {
				if(Tokens2.get(currentToken).getClasse().equals("ID") && Tokens2.get(currentToken).getType().equals("null")) {
					Tokens2.get(currentToken).setType("literal");
					TIPO = "literal";
					int currentToken2=0;
					while(currentToken2<Tokens2.size()) {
						if(Tokens2.get(currentToken2).getLexema().equals(Tokens2.get(currentToken).getLexema())) {
							Tokens2.get(currentToken2).setType("literal");
						}
						currentToken2++;
					}
					TokensSM = Tokens2;
					if(Tokens2.get(currentToken+1).getClasse().equals("VIR")) {
						Tokens2.get(currentToken+2).setType("literal");
						TIPO = "literal";
						TokensSM = Tokens2;
					}
					gravarArq.printf(" literal");
					break;
				}
				aux++;
				currentToken++;
			}
	
		}
		else if(regra.equals("A→ ES A")) {
	
		}
		else if(regra.equals("ES→ leia id pt_v")) {
			if(Tokens2.get(currentToken).getClasse().equals("PT_V")) {
				currentToken++;
			}
			if(Tokens2.get(currentToken).getClasse().equals("leia")) {
				currentToken++;
			}
			if(Tokens2.get(currentToken).getType().equals("null")) {
				System.out.println("Erro: variável não declarada!");
				System.out.println("Coluna: " + Tokens2.get(currentToken).getColumn() + " e linha: " + Tokens2.get(currentToken).getLine());
			}
			else if(Tokens2.get(currentToken).getType().equals("literal")) {
				String string = "%s";
				gravarArq.printf(" scanf(\"%s\", ",string );
				gravarArq.printf("&" + Tokens2.get(currentToken).getLexema() + ");\n");
				currentToken++;
			}
			else if(Tokens2.get(currentToken).getType().equals("inteiro")) {
				String string = "%d";
				gravarArq.printf(" scanf(\"%s\", ",string );
				gravarArq.printf("&" + Tokens2.get(currentToken).getLexema() + ");\n");
				currentToken++;
			}
			else if(Tokens2.get(currentToken).getType().equals("real")) {
				String string = "%lf";
				gravarArq.printf(" scanf(\" %s \", ",string );
				gravarArq.printf("&" + Tokens2.get(currentToken).getLexema() + ");\n");
				currentToken++;
			}
		}
		else if(regra.equals("ES→ escreva ARG pt_v")) {
			if(Tokens2.get(currentToken).getType().equals("inteiro") &&
					Tokens2.get(currentToken).getClasse().equals("ID")) {
						gravarArq.printf(" printf(\"%s\", ", "%d"); 
						gravarArq.printf(ARG + ");\n");
			}
			else if(Tokens2.get(currentToken).getType().equals("literal")&&
					Tokens2.get(currentToken).getClasse().equals("ID")) {
						gravarArq.printf(" printf(\"%s\", ", "%s"); 
						gravarArq.printf(ARG + ");\n");;
			}
			else if(Tokens2.get(currentToken).getType().equals("real")&&
					Tokens2.get(currentToken).getClasse().equals("ID")) {
						gravarArq.printf(" printf(\"%s\", ", "%lf"); 
						gravarArq.printf(ARG + ");\n");
			}
			else {
				gravarArq.printf(" printf(" + ARG + ");\n");
				currentToken++;
			}
			if(Tokens2.get(currentToken).getClasse().equals("PT_V")) {
				currentToken++;
			}
		}
		else if(regra.equals("ARG→ lit")) {
			while(currentToken<Tokens2.size()) {
				if(Tokens2.get(currentToken).getClasse().equals("escreva")) {
					currentToken++;
					if(Tokens2.get(currentToken).getClasse().equals("LIT")) {
						ARG = Tokens2.get(currentToken).getLexema();
						break;
					}
				}
				currentToken++;
			}
	
		}
		else if(regra.equals("ARG→ num")) {
			while(currentToken<Tokens2.size()) {
				if(Tokens2.get(currentToken).getClasse().equals("escreva")) {
					currentToken++;
					if(Tokens2.get(currentToken).getClasse().equals("NUM")) {
						ARG = Tokens2.get(currentToken).getLexema();
						break;
					}
				}
				currentToken++;
			}
	
		}
		else if(regra.equals("ARG→ id")) {
			while(currentToken<Tokens2.size()) {
				if(Tokens2.get(currentToken).getClasse().equals("escreva")) {
					currentToken++;
					if(Tokens2.get(currentToken).getClasse().equals("ID")) {
						ARG = Tokens2.get(currentToken).getLexema();
						break;
					}
				}
				currentToken++;
			}
	
		}
		else if(regra.equals("A→ CMD A")) {
	
		}
		else if(regra.equals("CMD→ id atr LD pt_v")) {
			if(aux5==2) {
				if((Tokens2.get(currentToken-2).getType().equals("inteiro") ||
						Tokens2.get(currentToken-2).getType().equals("literal") ||
						Tokens2.get(currentToken-2).getType().equals("real"))) {
						if(Tokens2.get(currentToken-2).getClasse() != "NUM") {
							gravarArq.printf(Tokens2.get(currentToken-2).getLexema() + "=" + LD + ";\n");
						}
						aux5=0;
						
					}
					else {
						System.out.println("Erro: tipos diferentes para atribuiçao!");
						System.out.println("Coluna: " + Tokens2.get(currentToken-4).getColumn() + " e linha: " + Tokens2.get(currentToken-4).getLine());
						aux5=0;
					}
				}
			else if(aux5==1) {
				if((Tokens2.get(currentToken).getType().equals("inteiro") ||
					Tokens2.get(currentToken).getType().equals("literal") ||
					Tokens2.get(currentToken).getType().equals("real"))) {
					if(Tokens2.get(currentToken).getClasse() != "NUM") {
						gravarArq.printf(Tokens2.get(currentToken).getLexema() + "=" + LD + ";\n");
					}
					aux5=0;
					
				}
				else {
					System.out.println("Erro: tipos diferentes para atribuiçao!");
					System.out.println("Coluna: " + Tokens2.get(currentToken-4).getColumn() + " e linha: " + Tokens2.get(currentToken-4).getLine());
					aux5=0;
				}
			}
			else if(Tokens2.get(currentToken-4).getType().equals("inteiro") ||
					Tokens2.get(currentToken-4).getType().equals("literal") ||
					Tokens2.get(currentToken-4).getType().equals("real") ) {
				if(LDtype.equals(Tokens2.get(currentToken-4).getType())){
					
					gravarArq.printf(Tokens2.get(currentToken-4).getLexema() + "=" + "T" + aux3 + ";\n");
				}
				else {
					System.out.println("Erro: tipos diferentes para atribuiçao!");
					System.out.println("Coluna: " + Tokens2.get(currentToken-4).getColumn() + " e linha: " + Tokens2.get(currentToken-4).getLine());
					
				}
			}
			else {
				System.out.println("Erro: variável não declarada!");
				System.out.println("Coluna: " + Tokens2.get(currentToken-4).getColumn() + " e linha: " + Tokens2.get(currentToken-4).getLine());
				
			}
	
		}
		else if(regra.equals("LD→ OPRD opa OPRD")) {
			if(Tokens2.get(currentToken).getType().equals(Tokens2.get(currentToken-2).getType()) &&
					Tokens2.get(currentToken).getType() != "literal" &&
					Tokens2.get(currentToken-2).getType() != "literal") {
				temporarias[0] = OPRD;
				temporarias[1] = Tokens2.get(currentToken-1).getLexema();
				temporarias[2] = OPRD2;
				LD = temporarias[0] + temporarias[1] + temporarias[2];
				LDtype = Tokens2.get(currentToken).getType();
				tempValor = aux3;
				aux3++;
				gravarArq.printf("T" + aux3 + "=" + temporarias[0] + temporarias[1] + temporarias[2] + ";\n");
				temporarias[0] = null;
				temporarias[1] = null;
				temporarias[2] = null;
			}else {
				System.out.println("Erro: operandos com tipos incompatíveis!");
				System.out.println("Coluna: " + Tokens2.get(currentToken).getColumn() + " e linha: " + Tokens2.get(currentToken).getLine());

			}
	
		}
		else if(regra.equals("LD→ OPRD")) {
			if(Tokens2.get(currentToken).getClasse().equals("NUM")) {
				aux5=2;
				LD = OPRD2;
			}
			else if(Tokens2.get(currentToken).getClasse().equals("ID")) {
				LD = OPRD;
				aux5=1;
				}
			
	
		}
		else if(regra.equals("OPRD→ id")) {
			while(currentToken<Tokens2.size()) {
				if(Tokens2.get(currentToken).getClasse().equals("ID")) {
					if(Tokens2.get(currentToken).getType().equals("inteiro") ||
						Tokens2.get(currentToken).getType().equals("literal") ||
						Tokens2.get(currentToken).getType().equals("real") ) {
						OPRD = Tokens2.get(currentToken).getLexema();
						if(Tokens2.get(currentToken+1).getClasse().equals("ATR")) {
							if(Tokens2.get(currentToken+3).getClasse().equals("PT_V")) {
								OPRD = Tokens2.get(currentToken+2).getLexema();
								break;
							}
							currentToken++;
							currentToken++;
							OPRD = Tokens2.get(currentToken).getLexema();
						}
						break;
					}else {
						System.out.println("Erro: variável não declarada!");
						System.out.println("Coluna: " + Tokens2.get(currentToken).getColumn() + " e linha: " + Tokens2.get(currentToken).getLine());
						break;
					}
				}
				currentToken++;
			}
		}
		else if(regra.equals("OPRD→ num")) {
			while(currentToken<Tokens2.size()) {
				if(Tokens2.get(currentToken).getClasse().equals("NUM")) {
					if(Tokens2.get(currentToken).getType().equals("inteiro") ||
						Tokens2.get(currentToken).getType().equals("literal") ||
						Tokens2.get(currentToken).getType().equals("real") ) {
						OPRD2 = Tokens2.get(currentToken).getLexema();
						if(Tokens2.get(currentToken+1).getClasse().equals("ATR")) {
							currentToken++;
							currentToken++;
							OPRD2 = Tokens2.get(currentToken).getLexema();
						}
						break;
					}else {
						System.out.println("Erro: variável não declarada!");
						System.out.println("Coluna: " + Tokens2.get(currentToken).getColumn() + " e linha: " + Tokens2.get(currentToken).getLine());
						break;
					}
				}
				currentToken++;
			}
	
		}
		else if(regra.equals("A→ COND A")) {
	
		}
		else if(regra.equals("COND→ CAB CP")) {
			gravarArq.printf("}\n");
	
		}
		else if(regra.equals("CAB→ se ab_p EXP_R fc_p então")) {
			gravarArq.printf("if (" + "T" + aux3 + ") {\n");
	
		}
		else if(regra.equals("EXP_R→ OPRD opr OPRD")) {
			if(Tokens2.get(currentToken).getType().equals(Tokens2.get(currentToken-2).getType())) {
				temporarias[0] = OPRD;
				temporarias[1] = Tokens2.get(currentToken-1).getLexema();
				temporarias[2] = OPRD2;
				EXP_R[0] = temporarias[0];
				EXP_R[1] = temporarias[1];
				EXP_R[2] = temporarias[2];
				tempValor = aux3;
				aux3++;
				gravarArq.printf("T" + aux3 + "=" + temporarias[0] + temporarias[1] + temporarias[2] + ";\n");
				temporarias[0] = null;
				temporarias[1] = null;
				temporarias[2] = null;
			}else {
				System.out.println("Erro: operandos com tipos incompatíveis!");
				System.out.println("Coluna: " + Tokens2.get(currentToken).getColumn() + " e linha: " + Tokens2.get(currentToken).getLine());

			}
	
		}
		else if(regra.equals("CP→ ES CP")) {
	
		}
		else if(regra.equals("CP→ CMD CP")) {
	
		}
		else if(regra.equals("CP→ COND CP")) {
	
		}
		else if(regra.equals("CP→ fimse")) {
	
		}
		else if(regra.equals("A→ fim")) {
			gravarArq.printf("}\n");
	
		}
		else {
			arq.close();
		}
		arq.close();
	}

}
