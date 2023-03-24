package AnalisadorSintatico;

import ScannerCompiler.ScannerCompiler;
import AnalisadorSemantico.AnalisadorSemantico;
import AnalisadorSemantico.PilhaSemantica;
import ScannerCompiler.Token;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import java.util.ArrayList;
import java.util.ArrayList;

public class Parser extends Pilha  {

	private ScannerCompiler scanner; 
	private Token token;   
	int i = 0;
	static int s = 0;
	int aux, aux1;
	Pilha p = new Pilha();
	PilhaSemantica p2 = new PilhaSemantica();
	AnalisadorSemantico sm = new AnalisadorSemantico();
	
	public Parser(ScannerCompiler scanner) {
		this.scanner = scanner;
	}
	
	public void parse(ArrayList<Token> tokens) throws IOException {
		p.empilhar(s);
		ArrayList<Token> Tokens1 = new ArrayList<Token>();
		Tokens1 = tokens;
		System.out.println("\n");
		i=0;
		System.out.println("----------------");
		System.out.println("\n");
		sm.recebeTokens(Tokens1);
		while(true) {
				if(s == 0 && Tokens1.get(i).getClasse().equals("inicio")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("2");
					s=2;
					i++;
				}
				else if(s == 2 && Tokens1.get(i).getClasse().equals("varinicio")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("4");
					s=4;
					i++;
				}
				else if(s == 4 && Tokens1.get(i).getClasse().equals("varfim") || 
						s == 16 && Tokens1.get(i).getClasse().equals("varfim")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("17");
					s=17;
					i++;
				}
				else if(s == 17 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("38");
					s=38;
					i++;
				}
				else if(s == 25 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("41");
					s=41;
					i++;
				}
				else if(s == 26 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("42");
					s=42;
					i++;
				}
				else if(s == 39 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("52");
					s=52;
					i++;
				}
				else if(s == 43 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("54");
					s=54;
					i++;
				}
				else if(s == 3 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 6 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 7 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 8 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 13 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 32 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 33 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 34 && Tokens1.get(i).getClasse().equals("ID")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("12");
					i++;
					s=12;
				}
				else if(s == 10 && Tokens1.get(i).getClasse().equals("ID")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("25");
					s=25;
					i++;
				}
				else if(s == 11 && Tokens1.get(i).getClasse().equals("ID")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("29");
					s=29;
					i++;
				}
				else if(s == 18 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 53 && Tokens1.get(i).getClasse().equals("ID")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("40");
					s=40;
					i++;
				}
				else if(s == 30 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 36 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 55 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 57 && Tokens1.get(i).getClasse().equals("ID")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("45");
					s=45;
					i++;
				}
				else if(s == 40 && Tokens1.get(i).getClasse().equals("VIR")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("53");
					s=53;
					i++;
				}
				else if(s == 4 && Tokens1.get(i).getClasse().equals("inteiro") ||
						s == 16 && Tokens1.get(i).getClasse().equals("inteiro")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("19");
					s=19;
					i++;
				}
				else if(s == 4 && Tokens1.get(i).getClasse().equals("real") ||
						s == 16 && Tokens1.get(i).getClasse().equals("real")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("20");
					s=20;
					i++;
				}
				else if(s == 4 && Tokens1.get(i).getClasse().equals("literal") ||
						s == 16 && Tokens1.get(i).getClasse().equals("literal")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("21");
					s=21;
					i++;
				}
				else if(s == 3 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 6 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 7 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 8 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 13 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 32 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 33 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 34 && Tokens1.get(i).getClasse().equals("leia")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("10");
					s=10;
					i++;
				}
				else if(s == 3 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 6 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 7 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 8 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 13 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 32 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 33 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 34 && Tokens1.get(i).getClasse().equals("escreva")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("11");
					s=11;
					i++;
				}
				else if(s == 11 && Tokens1.get(i).getClasse().equals("LIT")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("27");
					s=27;
					i++;
				}
				else if(s == 11 && Tokens1.get(i).getClasse().equals("NUM")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("28");
					s=28;
					i++;
				}
				else if(s == 30 && Tokens1.get(i).getClasse().equals("NUM") ||
						s == 46 && Tokens1.get(i).getClasse().equals("NUM") ||
						s == 55 && Tokens1.get(i).getClasse().equals("NUM") ||
						s == 57 && Tokens1.get(i).getClasse().equals("NUM")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("46");
					s=46;
					i++;
				}
				else if(s == 12 && Tokens1.get(i).getClasse().equals("ATR")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("30");
					s=30;
					i++;
				}
				else if(s == 44 && Tokens1.get(i).getClasse().equals("OPA")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("55");
					s=55;
					i++;
				}
				else if(s == 3 && Tokens1.get(i).getClasse().equals("se") ||
						s == 6 && Tokens1.get(i).getClasse().equals("se") ||
						s == 7 && Tokens1.get(i).getClasse().equals("se") ||
						s == 8 && Tokens1.get(i).getClasse().equals("se") ||
						s == 13 && Tokens1.get(i).getClasse().equals("se") ||
						s == 32 && Tokens1.get(i).getClasse().equals("se") ||
						s == 33 && Tokens1.get(i).getClasse().equals("se") ||
						s == 34 && Tokens1.get(i).getClasse().equals("se")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("14");
					s=14;
					i++;
				}
				else if(s == 14 && Tokens1.get(i).getClasse().equals("AB_P")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("36");
					s=36;
					i++;
				}
				else if(s == 50 && Tokens1.get(i).getClasse().equals("FC_P")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("56");
					s=56;
					i++;
				}
				else if(s == 56 && Tokens1.get(i).getClasse().equals("entao")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("60");
					s=60;
					i++;
				}
				else if(s == 51 && Tokens1.get(i).getClasse().equals("OPR")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("57");
					s=57;
					i++;
				}
				else if(s == 13 && Tokens1.get(i).getClasse().equals("fimse") ||
						s == 32 && Tokens1.get(i).getClasse().equals("fimse") ||
						s == 33 && Tokens1.get(i).getClasse().equals("fimse") ||
						s == 34 && Tokens1.get(i).getClasse().equals("fimse")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("35");
					s=35;
					i++;
				}
				else if(s == 3 && Tokens1.get(i).getClasse().equals("fim") ||
						s == 7 && Tokens1.get(i).getClasse().equals("fim") ||
						s == 8 && Tokens1.get(i).getClasse().equals("fim") ||
						s == 6 && Tokens1.get(i).getClasse().equals("fim")) {
					p.empilhar(Tokens1.get(i).getClasse());
					p2.empilhar(Tokens1.get(i).getClasse());
					p.empilhar("9");
					s=9;
					i++;
				}
				else if(s == 52 && Tokens1.get(i).getClasse().equals("varfim") ||
						s == 52 && Tokens1.get(i).getClasse().equals("inteiro") ||
						s == 52 && Tokens1.get(i).getClasse().equals("real") ||
						s == 52 && Tokens1.get(i).getClasse().equals("literal")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"D");
					System.out.println("D→ TIPO L pt_v");
					sm.semantico("D→ TIPO L pt_v", Tokens1);
				}
				else if(s == 15 && Tokens1.get(i).getClasse().equals("EOF")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"P");
					System.out.println("P→ inicio V A");
					sm.semantico("P→ inicio V A", Tokens1);
				}
				else if(s == 15 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 15 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 15 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 15 && Tokens1.get(i).getClasse().equals("se") ||
						s == 15 && Tokens1.get(i).getClasse().equals("fim")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"V");
					System.out.println("V→ varinicio LV");
					sm.semantico("V→ varinicio LV", Tokens1);
				}
				else if(s == 37 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 37 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 37 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 37 && Tokens1.get(i).getClasse().equals("se") ||
						s == 37 && Tokens1.get(i).getClasse().equals("fim")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"LV");
					System.out.println("LV→ D LV");
					sm.semantico("LV→ D LV", Tokens1);
				}
				else if(s == 38 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 38 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 38 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 38 && Tokens1.get(i).getClasse().equals("se") ||
						s == 38 && Tokens1.get(i).getClasse().equals("fim")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"LV");
					System.out.println("LV→ varfim pt_v");
					sm.semantico("LV→ varfim pt_v", Tokens1);
				}
				else if(s == 58 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"L");
					System.out.println("L→ id vir L");
					sm.semantico("L→ id vir L", Tokens1);
				}
				else if(s == 40 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"L");
					System.out.println("L→ id");
					sm.semantico("L→ id", Tokens1);
				}
				else if(s == 19 && Tokens1.get(i).getClasse().equals("ID")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"TIPO");
					System.out.println("TIPO→ inteiro");
					sm.semantico("TIPO→ inteiro", Tokens1);
				}
				else if(s == 20 && Tokens1.get(i).getClasse().equals("ID")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"TIPO");
					System.out.println("TIPO→ real");
					sm.semantico("TIPO→ real", Tokens1);
				}
				else if(s == 21 && Tokens1.get(i).getClasse().equals("ID")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"TIPO");
					System.out.println("TIPO→ literal");
					sm.semantico("TIPO→ literal", Tokens1);
				}
				else if(s == 22 && Tokens1.get(i).getClasse().equals("EOF")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"A");
					System.out.println("A→ ES A");
					sm.semantico("A→ ES A", Tokens1);
				}
				else if(s == 41 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 41 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 41 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 41 && Tokens1.get(i).getClasse().equals("se") ||
						s == 41 && Tokens1.get(i).getClasse().equals("fim") ||
						s == 41 && Tokens1.get(i).getClasse().equals("fimse")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"ES");
					System.out.println("ES→ leia id pt_v");
					sm.semantico("ES→ leia id pt_v", Tokens1);
				}
				else if(s == 42 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 42 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 42 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 42 && Tokens1.get(i).getClasse().equals("se") ||
						s == 42 && Tokens1.get(i).getClasse().equals("fim") ||
						s == 42 && Tokens1.get(i).getClasse().equals("fimse")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"ES");
					System.out.println("ES→ escreva ARG pt_v");
					sm.semantico("ES→ escreva ARG pt_v", Tokens1);
				}
				else if(s == 27 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"ARG");
					System.out.println("ARG→ lit");
					sm.semantico("ARG→ lit", Tokens1);
				}
				else if(s == 28 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"ARG");
					System.out.println("ARG→ num");
					sm.semantico("ARG→ num", Tokens1);
				}
				else if(s == 29 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"ARG");
					System.out.println("ARG→ id");
					sm.semantico("ARG→ id", Tokens1);
				}
				else if(s == 23 && Tokens1.get(i).getClasse().equals("EOF")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"A");
					System.out.println("A→ CMD A");
					sm.semantico("A→ CMD A", Tokens1);
				}
				else if(s == 54 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 54 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 54 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 54 && Tokens1.get(i).getClasse().equals("se") ||
						s == 54 && Tokens1.get(i).getClasse().equals("fim") ||
						s == 54 && Tokens1.get(i).getClasse().equals("fimse")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"CMD");
					System.out.println("CMD→ id atr LD pt_v");
					sm.semantico("CMD→ id atr LD pt_v", Tokens1);
				}
				else if(s == 59 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"LD");
					System.out.println("LD→ OPRD opa OPRD");
					sm.semantico("LD→ OPRD opa OPRD", Tokens1);
				}
				else if(s == 44 && Tokens1.get(i).getClasse().equals("PT_V")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"LD");
					System.out.println("LD→ OPRD");
					sm.semantico("LD→ OPRD", Tokens1);
				}
				else if(s == 45 && Tokens1.get(i).getClasse().equals("PT_V") ||
						s == 45 && Tokens1.get(i).getClasse().equals("OPA") ||
						s == 45 && Tokens1.get(i).getClasse().equals("FC_P") ||
						s == 45 && Tokens1.get(i).getClasse().equals("OPR")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"OPRD");
					System.out.println("OPRD→ id");
					sm.semantico("OPRD→ id", Tokens1);
				}
				else if(s == 46 && Tokens1.get(i).getClasse().equals("PT_V") ||
						s == 46 && Tokens1.get(i).getClasse().equals("OPA") ||
						s == 46 && Tokens1.get(i).getClasse().equals("FC_P") ||
						s == 46 && Tokens1.get(i).getClasse().equals("OPR")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"OPRD");
					System.out.println("OPRD→ num");
					sm.semantico("OPRD→ num", Tokens1);
				}
				else if(s == 24 && Tokens1.get(i).getClasse().equals("EOF")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"A");
					System.out.println("A→ COND A");
					sm.semantico("A→ COND A", Tokens1);
				}
				else if(s == 31 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 31 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 31 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 31 && Tokens1.get(i).getClasse().equals("se") ||
						s == 31 && Tokens1.get(i).getClasse().equals("fim") ||
						s == 31 && Tokens1.get(i).getClasse().equals("fimse")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"COND");
					System.out.println("COND→ CAB CP");
					sm.semantico("COND→ CAB CP", Tokens1);
				}
				else if(s == 60 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 60 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 60 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 60 && Tokens1.get(i).getClasse().equals("se") ||
						s == 60 && Tokens1.get(i).getClasse().equals("fim")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"CAB");
					System.out.println("CAB→ se ab_p EXP_R fc_p então");
					sm.semantico("CAB→ se ab_p EXP_R fc_p então", Tokens1);
				}
				else if(s == 61 && Tokens1.get(i).getClasse().equals("FC_P")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"EXP_R");
					System.out.println("EXP_R→ OPRD opr OPRD");
					sm.semantico("EXP_R→ OPRD opr OPRD", Tokens1);
				}
				else if(s == 47 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 47 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 47 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 47 && Tokens1.get(i).getClasse().equals("se") ||
						s == 47 && Tokens1.get(i).getClasse().equals("fim") ||
						s == 47 && Tokens1.get(i).getClasse().equals("fimse")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"CP");
					System.out.println("CP→ ES CP");
					sm.semantico("CP→ ES CP", Tokens1);
				}
				else if(s == 48 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 48 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 48 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 48 && Tokens1.get(i).getClasse().equals("se") ||
						s == 48 && Tokens1.get(i).getClasse().equals("fim") ||
						s == 48 && Tokens1.get(i).getClasse().equals("fimse")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"CP");
					System.out.println("CP→ CMD CP");
					sm.semantico("CP→ CMD CP", Tokens1);
				}
				else if(s == 49 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 49 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 49 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 49 && Tokens1.get(i).getClasse().equals("se") ||
						s == 49 && Tokens1.get(i).getClasse().equals("fim") ||
						s == 49 && Tokens1.get(i).getClasse().equals("fimse")) {
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"CP");
					System.out.println("CP→ COND CP");
					sm.semantico("CP→ COND CP", Tokens1);
				}
				else if(s == 35 && Tokens1.get(i).getClasse().equals("ID") ||
						s == 35 && Tokens1.get(i).getClasse().equals("leia") ||
						s == 35 && Tokens1.get(i).getClasse().equals("escreva") ||
						s == 35 && Tokens1.get(i).getClasse().equals("se") ||
						s == 35 && Tokens1.get(i).getClasse().equals("fim") ||
						s == 35 && Tokens1.get(i).getClasse().equals("fimse")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"CP");
					System.out.println("CP→ fimse");
					sm.semantico("CP→ fimse", Tokens1);
				}
				else if(s == 9 && Tokens1.get(i).getClasse().equals("EOF")) {
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					goTo(p.exibeUltimoValor(),"A");
					System.out.println("A→ fim");
					sm.semantico("A→ fim", Tokens1);
					
				}
				else if(s == 5 && Tokens1.get(i).getClasse().equals("EOF")){
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					p2.desempilhar();
					System.out.println("P→ inicio V A");
					sm.semantico("P→ inicio V A", Tokens1);
					if(isEmpty() == true) {
						break;
					}
				}
				else if(Tokens1.get(i).getClasse().equals("ERRO")){
					System.out.println("Token ERRO na coluna " + Tokens1.get(i).getColumn() + " e linha: " + Tokens1.get(i).getLine());
					i++;
				}
				else {
					if(Tokens1.get(i).getClasse().equals("EOF")) {
						System.out.println("Erro Sintático da linguagem no final do código fonte");
						break;
					}
					System.out.println("Erro Sintático da linguagem na coluna " + Tokens1.get(i).getColumn() + " e linha: " + Tokens1.get(i).getLine());
					
					i++;
				}
		}
		
	}
		

	public void goTo(Object a, String b){
		if(a == "0" && b =="P") {
			p.empilhar("P");
			p2.empilhar("P");
			p.empilhar("1");
			s =1;
		}
		else if(a == "2" && b =="V") {
			p.empilhar("V");
			p2.empilhar("V");
			p.empilhar("3");
			s =3;
		}
		else if(a == "4" && b =="LV") {
			p.empilhar("LV");
			p2.empilhar("LV");
			p.empilhar("15");
			s =15;
		}
		else if(a == "16" && b =="LV") {
			p.empilhar("LV");
			p2.empilhar("LV");
			p.empilhar("37");
			s =37;
		}
		else if(a == "4" && b =="D") {
			p.empilhar("D");
			p2.empilhar("D");
			p.empilhar("16");
			s =16;
		}
		else if(a == "16" && b =="D") {
			p.empilhar("D");
			p2.empilhar("D");
			p.empilhar("16");
			s =16;
		}
		else if(a == "18" && b =="L") {
			p.empilhar("L");
			p2.empilhar("L");
			p.empilhar("39");
			s =39;
		}
		else if(a == "53" && b =="L") {
			p.empilhar("L");
			p2.empilhar("L");
			p.empilhar("58");
			s =58;
		}
		else if(a == "4" && b =="TIPO") {
			p.empilhar("TIPO");
			p2.empilhar("TIPO");
			p.empilhar("18");
			s =18;
		}
		else if(a == "16" && b =="TIPO") {
			p.empilhar("TIPO");
			p2.empilhar("TIPO");
			p.empilhar("18");
			s =18;
		}
		else if(a == "3" && b =="A") {
			p.empilhar("A");
			p2.empilhar("A");
			p.empilhar("5");
			s =5;
		}
		else if(a == "6" && b =="A") {
			p.empilhar("A");
			p2.empilhar("A");
			p.empilhar("22");
			s =22;
		}
		else if(a == "7" && b =="A") {
			p.empilhar("A");
			p2.empilhar("A");
			p.empilhar("23");
			s =23;
		}
		else if(a == "8" && b =="A") {
			p.empilhar("A");
			p2.empilhar("A");
			p.empilhar("24");
			s =24;
		}
		else if(a == "3" && b =="ES") {
			p.empilhar("ES");
			p2.empilhar("ES");
			p.empilhar("6");
			s =6;
		}
		else if(a == "6" && b =="ES") {
			p.empilhar("ES");
			p2.empilhar("ES");
			p.empilhar("6");
			s =6;
		}
		else if(a == "7" && b =="ES") {
			p.empilhar("ES");
			p2.empilhar("ES");
			p.empilhar("6");
			s =6;
		}
		else if(a == "8" && b =="ES") {
			p.empilhar("ES");
			p2.empilhar("ES");
			p.empilhar("6");
			s =6;
		}
		else if(a == "13" && b =="ES") {
			p.empilhar("ES");
			p2.empilhar("ES");
			p.empilhar("32");
			s =32;
		}
		else if(a == "32" && b =="ES") {
			p.empilhar("ES");
			p2.empilhar("ES");
			p.empilhar("32");
			s =32;
		}
		else if(a == "33" && b =="ES") {
			p.empilhar("ES");
			p2.empilhar("ES");
			p.empilhar("32");
			s =32;
		}
		else if(a == "34" && b =="ES") {
			p.empilhar("ES");
			p2.empilhar("ES");
			p.empilhar("32");
			s =32;
		}
		else if(a == "11" && b =="ARG") {
			p.empilhar("ARG");
			p2.empilhar("ARG");
			p.empilhar("26");
			s =26;
		}
		else if(a == "3" && b =="CMD") {
			p.empilhar("CMD");
			p2.empilhar("CMD");
			p.empilhar("7");
			s =7;
		}
		else if(a == "6" && b =="CMD") {
			p.empilhar("CMD");
			p2.empilhar("CMD");
			p.empilhar("7");
			s =7;
		}
		else if(a == "7" && b =="CMD") {
			p.empilhar("CMD");
			p2.empilhar("CMD");
			p.empilhar("7");
			s =7;
		}
		else if(a == "8" && b =="CMD") {
			p.empilhar("CMD");
			p2.empilhar("CMD");
			p.empilhar("7");
			s =7;
		}
		else if(a == "13" && b =="CMD") {
			p.empilhar("CMD");
			p2.empilhar("CMD");
			p.empilhar("33");
			s =33;
		}
		else if(a == "32" && b =="CMD") {
			p.empilhar("CMD");
			p2.empilhar("CMD");
			p.empilhar("33");
			s =33;
		}
		else if(a == "33" && b =="CMD") {
			p.empilhar("CMD");
			p2.empilhar("CMD");
			p.empilhar("33");
			s =33;
		}
		else if(a == "34" && b =="CMD") {
			p.empilhar("CMD");
			p2.empilhar("CMD");
			p.empilhar("33");
			s =33;
		}
		else if(a == "30" && b =="LD") {
			p.empilhar("LD");
			p2.empilhar("LD");
			p.empilhar("43");
			s =43;
		}
		else if(a == "30" && b =="OPRD") {
			p.empilhar("OPRD");
			p2.empilhar("OPRD");
			p.empilhar("44");
			s =44;
		}
		else if(a == "36" && b =="OPRD") {
			p.empilhar("OPRD");
			p2.empilhar("OPRD");
			p.empilhar("51");
			s =51;
		}
		else if(a == "55" && b =="OPRD") {
			p.empilhar("OPRD");
			p2.empilhar("OPRD");
			p.empilhar("59");
			s =59;
		}
		else if(a == "57" && b =="OPRD") {
			p.empilhar("OPRD");
			p2.empilhar("OPRD");
			p.empilhar("61");
			s =61;
		}
		else if(a == "3" && b =="COND") {
			p.empilhar("COND");
			p2.empilhar("COND");
			p.empilhar("8");
			s =8;
		}
		else if(a == "6" && b =="COND") {
			p.empilhar("COND");
			p2.empilhar("COND");
			p.empilhar("8");
			s =8;
		}
		else if(a == "7" && b =="COND") {
			p.empilhar("COND");
			p2.empilhar("COND");
			p.empilhar("8");
			s =8;
		}
		else if(a == "8" && b =="COND") {
			p.empilhar("COND");
			p2.empilhar("COND");
			p.empilhar("8");
			s =8;
		}
		else if(a == "13" && b =="COND") {
			p.empilhar("COND");
			p2.empilhar("COND");
			p.empilhar("34");
			s =34;
		}
		else if(a == "32" && b =="COND") {
			p.empilhar("COND");
			p2.empilhar("COND");
			p.empilhar("34");
			s =34;
		}
		else if(a == "33" && b =="COND") {
			p.empilhar("COND");
			p2.empilhar("COND");
			p.empilhar("34");
			s =34;
		}
		else if(a == "34" && b =="COND") {
			p.empilhar("COND");
			p2.empilhar("COND");
			p.empilhar("34");
			s =34;
		}
		else if(a == "3" && b =="CAB") {
			p.empilhar("CAB");
			p2.empilhar("CAB");
			p.empilhar("13");
			s =13;
		}
		else if(a == "6" && b =="CAB") {
			p.empilhar("CAB");
			p2.empilhar("CAB");
			p.empilhar("13");
			s =13;
		}
		else if(a == "7" && b =="CAB") {
			p.empilhar("CAB");
			p2.empilhar("CAB");
			p.empilhar("13");
			s =13;
		}
		else if(a == "8" && b =="CAB") {
			p.empilhar("CAB");
			p2.empilhar("CAB");
			p.empilhar("13");
			s =13;
		}
		else if(a == "13" && b =="CAB") {
			p.empilhar("CAB");
			p2.empilhar("CAB");
			p.empilhar("13");
			s =13;
		}
		else if(a == "32" && b =="CAB") {
			p.empilhar("CAB");
			p2.empilhar("CAB");
			p.empilhar("13");
			s =13;
		}
		else if(a == "33" && b =="CAB") {
			p.empilhar("CAB");
			p2.empilhar("CAB");
			p.empilhar("13");
			s =13;
		}
		else if(a == "34" && b =="CAB") {
			p.empilhar("CAB");
			p2.empilhar("CAB");
			p.empilhar("13");
			s =13;
		}
		else if(a == "36" && b =="EXP_R") {
			p.empilhar("EXP_R");
			p2.empilhar("EXP_R");
			p.empilhar("50");
			s =50;
		}
		else if(a == "13" && b =="CP") {
			p.empilhar("CP");
			p2.empilhar("CP");
			p.empilhar("31");
			s =31;
		}
		else if(a == "32" && b =="CP") {
			p.empilhar("CP");
			p2.empilhar("CP");
			p.empilhar("47");
			s =47;
		}
		else if(a == "33" && b =="CP") {
			p.empilhar("CP");
			p2.empilhar("CP");
			p.empilhar("48");
			s =48;
		}
		else if(a == "34" && b =="CP") {
			p.empilhar("CP");
			p2.empilhar("CP");
			p.empilhar("49");
			s =49;
		}
		
	}
}
	