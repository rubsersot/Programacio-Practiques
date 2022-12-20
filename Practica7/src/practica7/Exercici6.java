package practica7;

import utils.Utils;

public class Exercici6 {

    static int[] pila;
    static int tamany;
    
    public static void main(String[] args) {
        final int TAMANY_MAX = 10;
        pila = new int[TAMANY_MAX];
        tamany = 0;
        
        MostrarMenu();
        
        GestionarOpcions();
    }
    
    //Procediment per mostrar menú d'opcions
    public static void MostrarMenu(){
        System.out.println("Selecciona la opció que vulguis introduint el número de l'esquerra");
        System.out.println("1: Afegir número (push)");
        System.out.println("2: Treure número (pop)");
        System.out.println("3: Mostrar contingut de la pila");
        System.out.println("4: Sortir");
        System.out.println("5: Torna a mostrar el menú");
    }
    
    //Procediment que gestiona les opcions del menú
    public static void GestionarOpcions(){
        int opcio = Utils.LlegirInt();
        while(opcio != 4){
            switch (opcio) {
                case 1:
                    AfegirNum(pila);
                    break;
                case 2:
                    TreureNum(pila);
                    break;
                case 3:
                    MostrarPila(pila);
                    break;
                case 5:
                    MostrarMenu();
                    break;
                default:
                    System.out.println("ERROR, opció no vàlida");
                    break;
            }
            System.out.print("Selecciona la següent opció: ");
            opcio = Utils.LlegirInt();
        }        
    }
    
    //Procediment per afegir número a la pila
    public static void AfegirNum(int[] pila){
        if(tamany == 10){
            System.out.println("ERROR, la pila es troba plena");
        }
        else{
            System.out.print("Introdueix el número que vols afegir: ");
            pila[tamany] = Utils.LlegirInt();
            tamany++; 
        }
    }
    
    //Procediment per treure número de la pila
    public static void TreureNum(int[] pila){
        if(tamany == 0){
            System.out.println("ERROR, la pila ja és buida");
        }
        else{
            //No fa falta borrar el número del vector, simplement quan el mostrem 
            //arribarem fins al número anterior al esborrat
            System.out.println("S'ha tret el número " + pila[tamany-1] + " de la pila");
            --tamany;
        }
    }
    
    //Procediment per mostrar la pila
    public static void MostrarPila(int[] pila){
        for(int i = 0; i < tamany; ++i){
            System.out.print(pila[i] + " ");
        }
        System.out.println();
    }
    
}
