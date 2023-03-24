
package ScannerCompiler;


public class Token {
    public static final String TK_NUM = "NUM";
    public static final String TK_LIT = "LIT";
    public static final String TK_ID = "ID";
    public static final String TK_COMENTARIO = "COMENTARIO";
    public static final String TK_EOF = "EOF";
    public static final String TK_OPR = "OPR";
    public static final String TK_ATR = "ATR";
    public static final String TK_OPA = "OPA";
    public static final String TK_AB_P = "AB_P";
    public static final String TK_FC_P = "FC_P";
    public static final String TK_PT_V = "PT_V";
    public static final String TK_VIR = "VIR";
    public static final String TK_ERRO = "ERRO";
    
    
    private String classe;
    private String lexema;
	private String type;
	private int line;
	private int column;
    
     public Token(String classe, String lexema, String type, int line, int column){
         super();
         this.classe = classe;
         this.lexema = lexema;
         this.type = type;
         this.line = line;
         this.column = column;
     }
     
     public String toString(){
         return "TOKEN - classe = " + classe + ", lexema =" + lexema + ", tipo =" + type;
     }
     public Token(){
         super();
     }
     public String getClasse(){
         return classe;
     }
     public void setClasse(String classe){
         this.classe = classe;
     }
     public String getLexema(){
         return lexema;
     }
     public void setLexema(String lexema){
         this.lexema = lexema;
     }
	 public String getType() {
 		 return type;
	 }
	 public void setType(String type) {
		 this.type = type;
	 }
 	public int getLine() {
 		 return line;
	 }
	 public void setLine(int line) {
		 this.line = line;
	 }
	 public int getColumn() {
 		 return column;
	 }
	 public void setColumn(int column) {
		 this.column = column;
	 }
     
     
}
