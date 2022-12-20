package practica7;
/*Fer un procediment anomenat titol que donat un text el 
mostri de manera centrada asumint que l'amplada es de 80 */
import java.util.Scanner;
public class Exercici5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int AMPLADA = 80;
        System.out.print("Escriu el que volguis: ");
        String texte = scan.nextLine();   
        Titol(AMPLADA, texte);
    }
    
    static void Titol(int amplada, String texte){
        String txtfinal ="";
        
        /*
        Per a números imparells no el podem centrar perfectament perquè per centrar
        deixem els mateixos espais a l'esquerra que a la dreta i no podem partir
        un espai en 2 i que quedi mig espai i mig espai
        */
        int longitud = amplada - texte.length();
        for(int i =0; i<longitud/2;i++){
            txtfinal += " ";
        }
        txtfinal += texte;
        for(int i = 0; i<longitud/2; i++){
            txtfinal += " ";
        }
        System.out.println(txtfinal);
        
    }
}
