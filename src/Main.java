import java.io.FileNotFoundException;
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
        sc.close();
    }
    public static void jugarPartidaNova(Torns<String> torns){
        boolean partida = true;
       //inicialitzem les peces i jugadors
        ArrayList<Pieza>Blanques=new ArrayList<>();
        ArrayList<Pieza>Negres=new ArrayList<>();

        Jugador<Pieza>JugadorBlanc=new Jugador<>(Blanques);
        Jugador<Pieza>JugadorNegre=new Jugador<>(Negres);
        while(partida){
        //TODO:
            try{

            }catch(FiJocException e){
                System.out.println("Has matat al rei!!!");
                partida=false;
            }
        }
    }
    public static ArrayList<Pieza> inicialitzarBlanques(ArrayList<Pieza> piezasBlancas){
    piezasBlancas.clear();


        // Fila 1 (torre, caballo, alfil, reina, rey, alfil, caballo, torre)
        piezasBlancas.add(new Pieza(1, 'a', Pieza.TORRE));
        piezasBlancas.add(new Pieza(1, 'b', Pieza.CABALLO));
        piezasBlancas.add(new Pieza(1, 'c', Pieza.ALFIL));
        piezasBlancas.add(new Pieza(1, 'd', Pieza.REINA));
        piezasBlancas.add(new Pieza(1, 'e', Pieza.REI));
        piezasBlancas.add(new Pieza(1, 'f', Pieza.ALFIL));
        piezasBlancas.add(new Pieza(1, 'g', Pieza.CABALLO));
        piezasBlancas.add(new Pieza(1, 'h', Pieza.TORRE));

        // Fila 2 (peones)
        piezasBlancas.add(new Pieza(2, 'a', Pieza.PEON));
        piezasBlancas.add(new Pieza(2, 'b', Pieza.PEON));
        piezasBlancas.add(new Pieza(2, 'c', Pieza.PEON));
        piezasBlancas.add(new Pieza(2, 'd', Pieza.PEON));
        piezasBlancas.add(new Pieza(2, 'e', Pieza.PEON));
        piezasBlancas.add(new Pieza(2, 'f', Pieza.PEON));
        piezasBlancas.add(new Pieza(2, 'g', Pieza.PEON));
        piezasBlancas.add(new Pieza(2, 'h', Pieza.PEON));

        return piezasBlancas;
    }

    public static ArrayList<Pieza> inicialitzarNegres(ArrayList<Pieza> piezasNegras){
        piezasNegras.clear();
        // Fila 8 (torre, caballo, alfil, reina, rey, alfil, caballo, torre)
        piezasNegras.add(new Pieza(8, 'a', Pieza.TORRE));
        piezasNegras.add(new Pieza(8, 'b', Pieza.CABALLO));
        piezasNegras.add(new Pieza(8, 'c', Pieza.ALFIL));
        piezasNegras.add(new Pieza(8, 'd', Pieza.REINA));
        piezasNegras.add(new Pieza(8, 'e', Pieza.REI));
        piezasNegras.add(new Pieza(8, 'f', Pieza.ALFIL));
        piezasNegras.add(new Pieza(8, 'g', Pieza.CABALLO));
        piezasNegras.add(new Pieza(8, 'h', Pieza.TORRE));

        // Fila 7 (peones)
        piezasNegras.add(new Pieza(7, 'a', Pieza.PEON));
        piezasNegras.add(new Pieza(7, 'b', Pieza.PEON));
        piezasNegras.add(new Pieza(7, 'c', Pieza.PEON));
        piezasNegras.add(new Pieza(7, 'd', Pieza.PEON));
        piezasNegras.add(new Pieza(7, 'e', Pieza.PEON));
        piezasNegras.add(new Pieza(7, 'f', Pieza.PEON));
        piezasNegras.add(new Pieza(7, 'g', Pieza.PEON));
        piezasNegras.add(new Pieza(7, 'h', Pieza.PEON));

        return piezasNegras;
    }
}
