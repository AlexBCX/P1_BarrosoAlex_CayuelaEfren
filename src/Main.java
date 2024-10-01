import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); //per poder escriure i llegir desde teclat
    Torns<String> torns=new Torns<>();
    boolean jugant=true;

    String nomFitxer=""; //nom on guardarem les partides

    int opcio;

    while(jugant){
        System.out.println("Benvingut als escacs!");
        System.out.println("1. Jugar una partida nova");
        System.out.println("2. Reproduir una partida des d'un fitxer");
        System.out.println("3. Sortir");
        System.out.print("Selecciona una opció: ");
        opcio = sc.nextInt();

        switch(opcio){
        case 1:
            System.out.println("Ingresa el nom del fitxer sense .txt.");
                nomFitxer=sc.next();
                jugarPartidaNova(torns);
            break;
        case 2:
            //case de reproduir desde fitxer
            break;
        case 3:
            jugant = false;
            System.out.println("Sortint del joc...");
            break;
        default:
            System.out.println("Opció no vàlida. Torna-ho a intentar.");
        }
    }   //FI WHILE (PROGRAMA)
    }
    public static void jugarPartidaNova(Torns<String> torns){

       //inicialitzem les peces i jugadors
        ArrayList<Pieza>Blanques=new ArrayList<>();
        ArrayList<Pieza>Negres=new ArrayList<>();

        Jugador<Pieza>JugadorBlanc=new Jugador<>(Blanques);
        Jugador<Pieza>JugadorNegre=new Jugador<>(Negres);
    }
}