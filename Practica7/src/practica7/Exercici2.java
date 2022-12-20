package practica7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import utils.Utils;

public class Exercici2 {

    public static void main(String[] args) {
        //Demanem dades del problema
        String missatge = "Introdueix el preu inicial: ";
        float preu = Utils.LlegirFloat(missatge);
        System.out.print("Introdueix un número per escollir el tipus d'IVA: (0 Exempt, 1 General, 2 Reduït, 3 Superreduït): ");
        int tipus = Utils.LlegirInt(0, 3);   
        missatge = "Introdueix el dia: ";
        int dia = Utils.LlegirInt(missatge);
        missatge = "Introdueix el mes: ";
        int mes = Utils.LlegirInt(missatge);
        missatge = "Introdueix l'any: ";
        int any = Utils.LlegirInt(missatge);
        //Comprovem si la data és vàlida, si ho és mostrem el resultat si no ho és sortim
        if(!ComprovarData(dia, mes, any)){
            System.out.println("La data no és vàlida");
        }
        else{
            float preu_final = CalcularIva(preu, tipus, dia, mes, any);
            System.out.println("El preu final és de: " + preu_final);
        }
        
    }
    
    //Funció que comprova si una data és vàlida
    public static boolean ComprovarData(int dia, int mes, int any){
        boolean resultat;
        //Transformem la data en un unic String
        String dataString = dia + "/" + mes + "/" + any;
        //Establim el format de dates
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        Date data = null;
        //Comprovem si és vàlida
        try{
            data = formatter.parse(dataString); 
            resultat = true;
        }
        catch(ParseException e){
            resultat = false;
        }
        return resultat;
    }
    
    //Funció que retorna un preu aplicant l'IVA
    public static float CalcularIva(float preu, int tipus, int dia, int mes, int any){
        //Inicialitzem el preu final amb el preu original el qual després modificarem
        float preu_final = preu;
        //Constants queindiquen els tipus
        final int EXEMPT = 0;
        final int GENERAL = 1;
        final int REDUIT = 2;
        final int SUPERREDUIT = 3;
        //Dues dates, la que hem llegit i una que utilitzem per comprovar a quina franja estem
        Date data1 = new Date(any, mes, dia);
        Date data2 = new Date(2012, 7, 15);
        //Comprovem la data, comprovem el tipus i apliquem l'IVA corresponent
        if(any < 1992){
            switch (tipus) {
                case GENERAL:
                    preu_final += preu * 0.12f;
                    break;
                case REDUIT:
                    preu_final += preu + preu * 0.06f;
                    break;
                case SUPERREDUIT:
                    System.out.println("No existeix");
                    break;
                default:
                    break;
            }
        }
        else if(any < 1993){
            switch (tipus) {
                case GENERAL:
                    preu_final += preu * 0.15f;
                    break;
                case REDUIT:
                    preu_final += preu * 0.06f;
                    break;
                case SUPERREDUIT:
                    System.out.println("No existeix");
                    break;
                default:
                    break;
            }
        }
        else if(any < 1995){
            switch (tipus) {
                case GENERAL:
                    preu_final += preu * 0.15f;
                    break;
                case REDUIT:
                    preu_final += preu * 0.06f;
                    break;
                case SUPERREDUIT:
                    preu_final += preu * 0.03f;
                    break;
                default:
                    break;
            }
        }
        else if(any < 2010){
            switch (tipus) {
                case GENERAL:
                    preu_final += preu * 0.16f;
                    break;
                case REDUIT:
                    preu_final += preu * 0.07f;
                    break;
                case SUPERREDUIT:
                    preu_final += preu * 0.04f;
                    break;
                default:
                    break;
            }
        }
        else if(data1.before(data2)){
            switch (tipus) {
                case GENERAL:
                    preu_final += preu * 0.18f;
                    break;
                case REDUIT:
                    preu_final += preu * 0.08f;
                    break;
                case SUPERREDUIT:
                    preu_final += preu * 0.04f;
                    break;
                default:
                    break;
            }
        }
        else{
            switch (tipus) {
                case GENERAL:
                    preu_final += preu * 0.21f;
                    break;
                case REDUIT:
                    preu_final += preu * 0.10f;
                    break;
                case SUPERREDUIT:
                    preu_final += preu * 0.04f;
                    break;
                default:
                    break;
            }
        }
        return preu_final;
    }
    
}
