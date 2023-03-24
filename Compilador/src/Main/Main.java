package Main;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import AnalisadorSemantico.AnalisadorSemantico;
import AnalisadorSintatico.Parser;
import ScannerCompiler.ScannerCompiler;
import ScannerCompiler.Token;
import ScannerCompiler.TabelaSimbolos;

public class Main{
    public static void main(String[] args) throws ParseException, IOException {
        ScannerCompiler sc = new ScannerCompiler("C:\\Users\\Vitor\\eclipse-workspace\\Compilador\\src\\codigofonte.ext");
        Token token = null;
        ArrayList<Token> Tokens = new ArrayList<Token>();
        do{
        	token = sc.nextToken();
            if(token != null){
                System.out.println(token);
                Tokens.add(token);
            }
        } while(token != null);
        Token eof = EOF();
        System.out.println(eof);
        Tokens.add(EOF());
        
        Parser pa = new Parser(sc);
        pa.parse(Tokens);
        
		
    }
    public static Token EOF() {
    	Token token;
    	token = new Token();
    	token.setClasse(Token.TK_EOF);
    	token.setLexema(Token.TK_EOF);
    	token.setType("null");
    	return token;
    }
    
}


