package testeexception;


public class TesteException {

    
    public static void main(String[] args) {
        System.out.println("Inicio do main");
        metodo1();
        System.out.println("fim do main");
    }
    
    static void metodo1(){
        System.out.println("Inicio do metodo1");
        metodo2();
        System.out.println("Fim do metodo1");
    }
    
    static void metodo2(){
        System.out.println("Inicio do metodo2");
        int[] array = new int[10];
        for(int i = 0;i <=15;i++){
            try{
                array[i] = i;
                System.out.println(i);
            }
            catch(ArrayIndexOutOfBoundsException exception){
                System.out.println("Excecao por conta de vetor que não existe");
            }
        }
        System.out.println("Fim do metodo2");
    }
    
}
