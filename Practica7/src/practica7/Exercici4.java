package practica7;

import java.util.Scanner;

public class Exercici4 {

    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        //Comprovem si s'ha validat la contrassenya i mostrem el missatge corresponent
        if(ValidarSuperusuari()){
            System.out.println("Contrassenya correcte");
        }
        else{
            System.out.println("Has superat el límit d'intents permesos");
        }
    }
    
    public static boolean ValidarSuperusuari(){
        
        boolean valida = false;
        //Contrassenya vàlida
        final String PASSWORD_VALIDA = "ausias";
        int intents = 0;
        //Demanem la contrassenya
        System.out.print("Introdueix la contrassenya: ");
        String password = scan.nextLine();
        
        //Bucle fins que s'hagin fet els 3 intents extra o la contrassenya sigui vàlida
        while(!valida && intents < 3){
            if(password.equals(PASSWORD_VALIDA)){
                valida = true;
            }
            else{
                System.out.println("Contrassenya incorrecta torna a introduir-la (et queden " + (3-intents) + " intents)");
                password = scan.nextLine();
                ++intents;
            }
        }
        //Comprovació final per no tornar a demanar un altra contrassenya despres d'aquesta comprovació
        if(password.equals(PASSWORD_VALIDA)) valida = true;
        
        return valida;
    }
    
}
