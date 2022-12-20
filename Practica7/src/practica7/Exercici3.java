package practica7;
/*Escriure una funcio anomenada roman i que retorni el valor de uns numeros 
entre 1 i 3999 en romans*/
import java.util.Random;

public class Exercici3 {

    public static void main(String[] args) {
        Random random = new Random();
        //Fiquem un numero aleatori
        int numero = random.nextInt(3999) + 1;

        System.out.println("El " + numero + " en romà es: " + Roman(numero));
    }

    static String Roman(int numero) {
        int milers, centena, desena, unitat;
        String numRoma = "";

        //Obtenim cada xifra del numero
        milers = numero / 1000;
        centena = numero / 100 % 10;
        desena = numero / 10 % 10;
        unitat = numero % 10;

        //Fem un bucle for per obtenir el miler
        for (int i = 1; i <= milers; i++) {
            numRoma += "M";
        }
        //Ara amb les centenes
        if (centena == 9) {
            numRoma += "CM";
        } else if (centena >= 5) {
            numRoma += "D";
            //Si la centena es mayor o igual a 600 se li afegeixen C a la D de 500
            for (int i = 6; i <= centena; i++) {
                numRoma += "C";
            }
        } else if (centena == 4) {
            numRoma += "CD";
        } else {
            for (int i = 1; i <= centena; i++) {
                numRoma += "C";
            }
        }

        //Desenes
        if (desena == 9) {
            numRoma += "XC";
        } else if (desena >= 5) {
            numRoma += "L";
            //Si la desena es mayor o igual a 60 se li van afegint X a la L de 50
            for (int i = 6; i <= desena; i++) {
                numRoma += "X";
            }
        } else if (desena == 4) {
            numRoma += "XL";
        } else {
            for (int i = 1; i <= desena; i++) {
                numRoma += "X";
            }
        }

        //Unitats
        if (unitat == 9) {
            numRoma += "IX";
        } else if (unitat >= 5) {
            numRoma += "V";
            //Si la unitat es major o igual a 6 se li afegeixen I a la V del 5
            for (int i = 6; i <= unitat; i++) {
                numRoma += "I";
            }
        } else if (unitat == 4) {
            numRoma += "IV";
        } else {
            for (int i = 1; i <= unitat; i++) {
                numRoma += "I";
            }
        }

        return numRoma;
    }
}
