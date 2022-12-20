package practica7;
/*Fer una funció que rebi com a parametres el preu i la categoria 
d'un producte i retorni el preu amb el descompte*/
import java.util.Scanner;
import java.util.Random;
public class Exercici1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int preu;
        //Per posar el preu li posaré un preu de manera aleatoria
        preu = random.nextInt(200)+1;
        //I fiquem la categoria del producte
        String categoria;
        boolean correcte = false;
        //Comprobem si la categoria es troba entre a, b i c
        do{
            System.out.println("Introdueix la categoria (A, B o C): ");
            categoria = scan.nextLine().toUpperCase();
            
            if(categoria.equals("A") || categoria.equals("B")|| categoria.equals("C")){
                correcte=true;               
            }
            else{
                System.err.print("INCORRECTE, TORNA A INTENTAR-HO: ");
            }
        }while(!correcte);
        
        System.out.println("El preu final de " + preu + " és " + CalcularDescompte(preu, categoria));
        
    }
    
    static float CalcularDescompte(int preu, String categoria){
        
        float preu_final = 0;
        //Comprobem els descmptes segons el seu preu i la seva categoria
        if(categoria.equals("A")){
            preu_final = preu - (preu * 0.05f);
        }
        else if(categoria.equals("B")){
            preu_final = preu - (preu * 0.10f);
        }
        else if(categoria.equals("C")&&preu<100){
            preu_final = preu - (preu*0.20f);
        }
        else if(categoria.equals("C") && preu>100){
            preu_final = preu - (preu * 0.35f);
        }
        
        return preu_final;
    }
    
}
