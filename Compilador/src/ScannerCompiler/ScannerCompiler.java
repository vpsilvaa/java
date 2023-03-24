package ScannerCompiler;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayList;


public class ScannerCompiler extends TabelaSimbolos{
    private char[] content;
    private int estado;
    private int posicao;
    private int line;
	private int column;
	private String aux1;
	ArrayList<String> palavrasres = preencheTabelaSimbolos();
	ArrayList<String> palavrasresnew = new ArrayList<String>();
	ArrayList<String> palavrasadd = new ArrayList<String>();
	ArrayList<String> palavrasnovas = new ArrayList<String>();
	ArrayList<String> palavrasnovas1 = new ArrayList<String>();
    
    public ScannerCompiler(String filename){
            try{
            	line = 1;
    			column = -1;
                String txtConteudo;
                txtConteudo = new String(Files.readAllBytes(Paths.get(filename)),StandardCharsets.UTF_8);
                System.out.println("----------------\n");
                System.out.println(txtConteudo + "\n");
                System.out.println("----------------\n");
                content = txtConteudo.toCharArray();
                posicao = 0;
            }
            catch(Exception ex){
                ex.printStackTrace(); 
            }
    }
    
    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
    private boolean isID(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    private boolean isUnderlined(char c) {
    	return c == '_';
    }
    private boolean isOperatorR1(char c){
        return c == '>';
    }
    private boolean isOperatorR2(char c){
        return c == '<';
    }
    private boolean isOperatorR3(char c){
        return c == '=';
    }
    private boolean isOperatorA(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    private boolean isCommentOpen(char c){
        return c == '{';
    }
    private boolean isCommentClose(char c){
        return c == '}';
    }
    private boolean isLit(char c){
        return c == '"';
    }
    private boolean isPoint(char c){
        return c == '.';
    }
    private boolean isComma(char c){
        return c == ',';
    }
    private boolean isPointComma(char c){
        return c == ';';
    }
    private boolean isOParentheses(char c){
        return c == '(';
    }
    private boolean isCParentheses(char c){
        return c == ')';
    }
    private boolean isSpace(char c){
    	if (c == '\n') {
    		line++;
    		column = -1;
		}
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }
    private boolean isExponent(char c){
        return c == 'E' || c == 'e';
    }
    
    private char nextChar() {
		if (isEOF()) {
			return '\0';
		}
		return content[posicao++];
	}
	private boolean isEOF() {
		return posicao >= content.length;
	}
    private boolean isEOF(char c) {
    	return c == '\0';
    }
    private void back() {
    	posicao--;
    }
    
    public Token nextToken(){
    	String term = "";
    	Token token;
        char currentChar;
        if(isEOF()) {
        	return null;
        }
        ArrayList<String> palavrasresini = preencheTabelaSimbolos();
        estado = 1;
        while(true){
            currentChar = nextChar();
            column++;
            switch(estado){
                case 1:
                	aux1 = " ";
                	if(isSpace(currentChar)){
                        estado = 1;
                    }
                    else if(isDigit(currentChar)){
                        estado = 2;
                        term += currentChar;
                    }
                    else if(posicao > content.length) {
                    	token = null;
                    	return token;
                    }
                    else if(currentChar == '\0') {
                    	token = null;
                    	return token;
                    }
                    else if(isComma(currentChar)){
                        estado = 15;
                        term += currentChar;
                    }
                    else if(isLit(currentChar)){
                        estado = 7;
                        term += currentChar;
                    }
                    else if(isCommentOpen(currentChar)){
                        estado = 9;
                        term += currentChar;
                    }
                    else if(isID(currentChar)){
                        estado = 11;
                        term += currentChar;
                    }
                    else if(currentChar == content.length){
                        estado = 12;
                        term += currentChar;
                    }
                    else if(isOperatorA(currentChar)){
                        estado = 13;
                        term += currentChar;
                    }
                    else if(isOParentheses(currentChar)){
                        estado = 14;
                        term += currentChar;
                    }
                    else if(isCParentheses(currentChar)){
                        estado = 16;
                        term += currentChar;
                    }
                    else if(isOperatorR1(currentChar)){
                        estado = 21;
                        term += currentChar;
                    }
                    else if(isOperatorR2(currentChar)){
                        estado = 18;
                        term += currentChar;
                    }
                    else if(isOperatorR3(currentChar)){
                        estado = 20;
                        term += currentChar;
                    }
                    else if(isPointComma(currentChar)){
                        estado = 17;
                        term += currentChar;
                    }
                    else{
                    	token = new Token();
                    	token.setClasse(Token.TK_ERRO);
                    	term += currentChar;
                    	token.setLexema(term);
                    	token.setType("null");
                    	token.setLine(line);
                    	token.setColumn(column);
                    	System.out.println("ERRO lexico - caractere invalido na linguagem");
                    	System.out.println("Linha:" + line + ",Coluna:" + column);
                    	estado = 1;
                    	return token;
                    }
                    break;
                case 2:
                    if(isDigit(currentChar)){
                        estado = 2;
                        term += currentChar;
                    }
                    else if(isPoint(currentChar)){
                    	aux1 = "double";
                        estado = 3;
                        term += currentChar;
                    }
                    else if(isExponent(currentChar)){
                        estado = 4;
                        term += currentChar;
                    }
                    else if(isSpace(currentChar)) {
                    	token = new Token();
                        token.setClasse(Token.TK_NUM);
                        token.setLexema(term);
                        if(aux1 == "double") {
                        	token.setType("real");
                        }
                        else {
                        	token.setType("inteiro");
                        }
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    else if(currentChar == '\0'){
                    	token = new Token();
                        token.setClasse(Token.TK_NUM);
                        token.setLexema(term);
                        if(aux1 == "double") {
                        	token.setType("real");
                        }
                        else {
                        	token.setType("inteiro");
                        }
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    else{
                    	token = new Token();
                        token.setClasse(Token.TK_NUM);
                        token.setLexema(term);
                        if(aux1 == "double") {
                        	token.setType("real");
                        }
                        else {
                        	token.setType("inteiro");
                        }
                        back();
                        column--;
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    break;
                case 3:
                    if(isDigit(currentChar)){
                        estado = 3;
                        term += currentChar;
                    }
                    else if(isExponent(currentChar)){
                        estado = 4;
                        term += currentChar;
                    }
                    else if(currentChar == '\0'){
                    	token = new Token();
                        token.setClasse(Token.TK_NUM);
                        token.setLexema(term);
                        if(aux1 == "double") {
                        	token.setType("real");
                        }
                        else {
                        	token.setType("inteiro");
                        }
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    else if(isSpace(currentChar)){
                    	token = new Token();
                        token.setClasse(Token.TK_NUM);
                        token.setLexema(term);
                        if(aux1 == "double") {
                        	token.setType("real");
                        }
                        else {
                        	token.setType("inteiro");
                        }
                        back();
                        column--;
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    else{
                    	token = new Token();
                        token.setClasse(Token.TK_NUM);
                        token.setLexema(term);
                        if(aux1 == "double") {
                        	token.setType("real");
                        }
                        else {
                        	token.setType("inteiro");
                        }
                        back();
                        column--;
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    break;
                case 4:
                    if(isOperatorA(currentChar)){
                        estado = 5;
                        term += currentChar;
                    }
                    else if(isDigit(currentChar)){
                        estado = 6;
                        term += currentChar;
                    }
                    else{
                    	token = new Token();
                    	token.setClasse(Token.TK_ERRO);
                    	term += currentChar;
                    	token.setLexema(term);
                    	token.setType("null");
                    	token.setLine(line);
                    	token.setColumn(column);
                    	System.out.println("ERRO lexico - caractere invalido na linguagem");
                    	System.out.println("Linha:" + line + ",Coluna:" + column);
                    	estado = 1;
                    	return token;
                    }
                    break;
                case 5:
                    if(isDigit(currentChar)){
                        estado = 6;
                        term += currentChar;
                    }
                    else{
                    	token = new Token();
                    	token.setClasse(Token.TK_ERRO);
                    	term += currentChar;
                    	token.setLexema(term);
                    	token.setType("null");
                    	token.setLine(line);
                    	token.setColumn(column);
                    	System.out.println("ERRO lexico - caractere invalido na linguagem");
                    	System.out.println("Linha:" + line + ",Coluna:" + column);
                    	estado = 1;
                    	return token;
                    }
                    break;
                case 6:
                    if(isDigit(currentChar)){
                        estado = 6;
                        term += currentChar;
                    }
                    else if(currentChar == '\0'){
                    	token = new Token();
                        token.setClasse(Token.TK_NUM);
                        token.setLexema(term);
                        if(aux1 == "double") {
                        	token.setType("double");
                        }
                        else {
                        	token.setType("inteiro");
                        }
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    else if(isSpace(currentChar)){
                    	token = new Token();
                        token.setClasse(Token.TK_NUM);
                        token.setLexema(term);
                        if(aux1 == "double") {
                        	token.setType("double");
                        }
                        else {
                        	token.setType("inteiro");
                        }
                        back();
                        column--;
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    else{
                    	token = new Token();
                        token.setClasse(Token.TK_NUM);
                        token.setLexema(term);
                        if(aux1 == "double") {
                        	token.setType("double");
                        }
                        else {
                        	token.setType("inteiro");
                        }
                        back();
                        column--;
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    break;
                case 7:
                    if(currentChar != '\0' && !isLit(currentChar)){
                        estado = 7;
                        term += currentChar;
                    }
                    else if(isLit(currentChar)){
                    	token = new Token();
                        term += currentChar;
                        token.setClasse(Token.TK_LIT);
                        token.setLexema(term);
                        token.setType("literal");
                        token.setLine(line);
                    	token.setColumn(column);
                        estado=1;
                        return token;
                    }
                    else{
                    	token = new Token();
                    	token.setClasse(Token.TK_ERRO);
                    	token.setLexema(term);
                    	token.setType("null");
                    	System.out.println("ERRO lexico - caractere invalido na linguagem");
                    	System.out.println("Linha:" + line + ",Coluna:" + column);
                    	estado = 1;
                    	column--;
                    	token.setLine(line);
                    	token.setColumn(column);
                    	return token;
                    }
                    break;
                case 8:
                	if(currentChar == '\0') {
                		token = new Token();
                		token.setClasse(Token.TK_LIT);
                		token.setLexema(term);
                		token.setType("literal");
                		token.setLine(line);
                    	token.setColumn(column);
                		term += currentChar;
                		estado=1;
                		return token;
                	}
                	else {
                		token = new Token();
                		token.setClasse(Token.TK_LIT);
                		token.setLexema(term);
                		token.setType("literal");
                		term += currentChar;
                		estado=1;
                		column--;
                		back();
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                case 9:
                	if(currentChar != '\0' && !isCommentClose(currentChar)){
                        estado = 9;
                        term += currentChar;
                    }
                	else if(isCommentClose(currentChar)){
                        term += currentChar;
                        System.out.println(term);
                        term="";
                        estado = 1;
                	}
                	else{
                    	token = new Token();
                    	token.setClasse(Token.TK_ERRO);
                    	token.setLexema(term);
                    	token.setType("null");
                    	System.out.println("ERRO lexico - caractere invalido na linguagem");
                    	System.out.println("Linha:" + line + ",Coluna:" + column);
                    	estado = 1;
                    	column--;
                    	token.setLine(line);
                    	token.setColumn(column);
                    	return token;
                    }
                    break;
                case 11:
                	if(isDigit(currentChar) || isID(currentChar) || isUnderlined(currentChar)) {
                		term += currentChar;
                		estado = 11;
                	}
                	else if(currentChar != '\0') {
                		back();
                		int i = 0;
                		for(i=0;i<palavrasnovas1.size();i++) {
                			if(term.equals(palavrasnovas1.get(i))) {
	    						token = new Token();
	    	                    token.setClasse(Token.TK_ID);
	    	                    token.setType("null");
	    	                    token.setLexema(term);
	    	                    column--;
	    	                    token.setLine(line);
	                        	token.setColumn(column);
	    	                    return token;
                			}
						
                		}
                		for(i=0;i<palavrasres.size();i++) {
                			if(term.equals(palavrasres.get(i))) {
	    						token = new Token();
	    	                    token.setClasse(term);
	    	                    token.setType(term);
	    	                    token.setLexema(term);
	    	                    column--;
	    	                    token.setLine(line);
	                        	token.setColumn(column);
	    	                    return token;
                			}
						
                		}
                		palavrasresnew = insert(term, palavrasres);
                		palavrasadd = palavrasresnew;
                		palavrasnovas1 = insert(term, palavrasnovas);
                		token = new Token();
                		token.setClasse(Token.TK_ID);
                		token.setLexema(term);
                		token.setType("null");
                		column--;
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                		}
                    	else{
                    		int i = 0;
                    		for(i=0;i<palavrasnovas1.size();i++) {
                    			if(term.equals(palavrasnovas1.get(i))) {
    	    						token = new Token();
    	    	                    token.setClasse(Token.TK_ID);
    	    	                    token.setType("null");
    	    	                    token.setLexema(term);
    	    	                    column--;
    	    	                    token.setLine(line);
    	                        	token.setColumn(column);
    	    	                    return token;
                    			}
    						
                    		}
                    		for(i=0;i<palavrasres.size();i++) {
                    			if(term.equals(palavrasres.get(i))) {
    	    						token = new Token();
    	    	                    token.setClasse(term);
    	    	                    token.setType(term);
    	    	                    token.setLexema(term);
    	    	                    column--;
    	    	                    token.setLine(line);
    	                        	token.setColumn(column);
    	    	                    return token;
                    			}
    						
                    		}
                    		palavrasresnew = insert(term, palavrasres);
                    		palavrasadd = palavrasresnew;
                    		token = new Token();
                    		token.setClasse(Token.TK_ID);
                    		token.setLexema(term);
                    		token.setType("null");
                    		column--;
                    		token.setLine(line);
                        	token.setColumn(column);
                    		return token;
                    		}
                    break;
                case 12:
                	token = new Token();
                    token.setClasse(Token.TK_EOF);
                    token.setLexema(term);
                    token.setType("null");
                    estado =1;
                    token.setLine(line);
                	token.setColumn(column);
                    return token;
                case 13:
                	if(currentChar == '\0') {
                		token = new Token();
                		token.setClasse(Token.TK_OPA);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                	else {
                		token = new Token();
                		token.setClasse(Token.TK_OPA);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		column--;
                		back();
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                case 14:
                	if(currentChar == '\0') {
                		token = new Token();
                		token.setClasse(Token.TK_AB_P);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                	else {
                		token = new Token();
                		token.setClasse(Token.TK_AB_P);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		column--;
                		back();
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                case 15:
                	if(currentChar == '\0') {
                		token = new Token();
                		token.setClasse(Token.TK_VIR);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		return token;
                	}
                	else {
                		token = new Token();
                		token.setClasse(Token.TK_VIR);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		column--;
                		back();
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                case 16:
                	if(currentChar == '\0') {
                		token = new Token();
                		token.setClasse(Token.TK_FC_P);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                	else {
                		token = new Token();
                		token.setClasse(Token.TK_FC_P);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		column--;
                		back();
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                case 17:
                	if(currentChar == '\0') {
                		token = new Token();
                		token.setClasse(Token.TK_PT_V);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		column--;
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                	else {
                		token = new Token();
                		token.setClasse(Token.TK_PT_V);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		column--;
                		back();
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                case 18:
                    if(isOperatorA(currentChar)){
                        estado = 19;
                        term += currentChar;
                    }
                    else if(isOperatorR3(currentChar) || isOperatorR1(currentChar)){
                        estado = 20;
                        term += currentChar;
                    }
                    else if(currentChar != '\0' || isSpace(currentChar)){
                    	back();
                    	token = new Token();
                        token.setClasse(Token.TK_OPR);
                        token.setLexema(term);
                        token.setType("null");
                        column--;
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    else {
                    	token = new Token();
                        token.setClasse(Token.TK_OPR);
                        token.setLexema(term);
                        token.setType("null");
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    break;
                case 19:
                	if(currentChar == '\0') {
                		token = new Token();
                		token.setClasse(Token.TK_ATR);
                		token.setLexema(term);
                		token.setType("null");
                		token.setLine(line);
                    	token.setColumn(column);
                		estado =1;
                		return token;
                	}
                	else {
                		token = new Token();
                		token.setClasse(Token.TK_ATR);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		column--;
                		back();
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                case 20:
                	if(currentChar == '\0') {
                		token = new Token();
                		token.setClasse(Token.TK_OPR);
                		token.setLexema(term);
                		token.setType("null");
                		token.setLine(line);
                    	token.setColumn(column);
                		estado =1;
                		return token;
                	}
                	else {
                		token = new Token();
                		token.setClasse(Token.TK_OPR);
                		token.setLexema(term);
                		token.setType("null");
                		estado =1;
                		column--;
                		back();
                		token.setLine(line);
                    	token.setColumn(column);
                		return token;
                	}
                case 21:
                    if(isOperatorR3(currentChar)){
                        estado = 20;
                        term += currentChar;
                    }
                    else if (currentChar != '\0' || isSpace(currentChar)){
                    	back();
                    	token = new Token();
                        token.setClasse(Token.TK_OPR);
                        token.setLexema(term);
                        token.setType("null");
                        column--;
                        token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }else{
                    	token = new Token();
                        token.setClasse(Token.TK_OPR);
                        token.setLexema(term);
                        token.setType("null");token.setLine(line);
                    	token.setColumn(column);
                        return token;
                    }
                    break;
                    
            }
        }
    }
}
