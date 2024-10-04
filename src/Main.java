import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Torns<String> torns=new Torns<>();

    String nomFitxer=""; //nom on guardarem les partides
    mostrarMenu();
    }
    private static void mostrarMenu() {
        boolean jugant=true;
        Scanner sc = new Scanner(System.in);

        while(jugant) {
            System.out.println("Benvingut als escacs!");
            System.out.println("1. Jugar una partida nova");
            System.out.println("2. Reproduir una partida des d'un fitxer");
            System.out.println("3. Sortir");
            System.out.print("Selecciona una opció: ");
            int opcio = sc.nextInt();

            switch (opcio) {
                case 1:
                    jugarPartidaNova();
                    break;
                case 2:
                    //case de reproduir desde fitxer
                    break;
                case 3:
                    jugant = false;
                    System.out.println("Sortint del joc...");
                    break;
                default:
                    System.out.println("Si pasa esto me meto un tiro.");
            }
        }
        sc.close();
    }
    private static void reproduirPartida(){
    }
    /*
    private static Torns<String> llegirTorns(){
        return
    }
     */
    private static void tornToPosition(String torn, Jugador<Pieza> p1, Jugador<Pieza> p2) throws FiJocException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el moviment (ex: 'a2 d7'):");
        String movimentP1 = sc.nextLine();
        String[] moviments = movimentP1.split(" ");

        if (moviments.length != 2) {
            throw new RuntimeException("Format de moviment incorrecte. Utilitza 'a2 d7'.");

        }

        // Extraer pos inicial y final
        String posInicial = moviments[0];
        String posFinal = moviments[1];
        
        // Convertir pos inicial (ex----> "a2")
        int colInicial = posInicial.charAt(0) - 'a' + 1; // Convertir 'a'-'h' a 1-8
        int filInicial = Character.getNumericValue(posInicial.charAt(1));

        // Convertir pos final (ex. "d7")
        int colFinal = posFinal.charAt(0) - 'a' + 1;
        int filFinal = Character.getNumericValue(posFinal.charAt(1));

        // Mover la pieza
        p1.moverPieza(filInicial, colInicial, filFinal, colFinal);
        if(p2.eliminarPiezaPosicion(filFinal, colFinal)){
            System.out.println("Has matat la peça que está en "+ posFinal);
        }

    }

    private static void jugarPartidaNova(){
        Torns<String> torns;
        String tornActual="";
        Scanner sc = new Scanner(System.in);
        boolean partida = true;
        boolean derechos=true;
        //TODO: nombre archivo
       //inicialitzem les peces i jugadors
        ArrayList<Pieza>Blanques=new ArrayList<>();
        ArrayList<Pieza>Negres=new ArrayList<>();
        Blanques = iniciarJuegoBlancas(Blanques);
        Negres = iniciarJuegoNegras(Negres);

        Jugador<Pieza>JugadorBlanc=new Jugador<>(Blanques);
        Jugador<Pieza>JugadorNegre=new Jugador<>(Negres);
        System.out.println("Peces posicionades correctament! (Blanques abaix)");

        while (partida) {
            try {
                mostrarTauler(JugadorBlanc, JugadorNegre);//mostrar taulell

                System.out.println("Torn de les " + (derechos?"blanques":"negres"));
                tornToPosition(tornActual,(derechos?JugadorBlanc:JugadorNegre), (derechos?JugadorNegre:JugadorBlanc));


                // todavia no -->System.out.println("peça eliminada!");
                derechos = !derechos;
            } catch (FiJocException e) {
                System.out.println("Has matat al rei!!! " + e.getMessage());
                partida = false;
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    private static ArrayList<Pieza> iniciarJuegoBlancas(ArrayList<Pieza> piezasBlancas){
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

    private static ArrayList<Pieza> iniciarJuegoNegras(ArrayList<Pieza> piezasNegras){
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

    private static void mostrarTauler(Jugador<Pieza> JugadorBlanc, Jugador<Pieza> JugadorNegre) {
        // Matriu per mostrar Taulell
        char[][] taulell = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                taulell[i][j] = '.';
            }
        }

        // Aafegim les blanquess
        for (Pieza p : JugadorBlanc.getPiezasVivas()) {
            int fila = p.getFila() - 1;
            int columna = p.getColumna() - 1;
            taulell[fila][columna] = Character.toUpperCase(p.getTipus());//en mayus per distingir de les neges
        }

        // Afegim negres
        for (Pieza p : JugadorNegre.getPiezasVivas()) {
            int fila = p.getFila() - 1;
            int columna = p.getColumna() - 1;
            taulell[fila][columna] = Character.toLowerCase(p.getTipus());//en minus per distingir de les altres
        }

        // fem el print del taulell
        System.out.println("  a b c d e f g h");
        for (int i = 7; i >= 0; i--) {  // Recorremos de 7 a 0 para mostrar de la fila 8 a la 1
            System.out.print((i + 1) + " ");  // Num fila
            for (int j = 0; j < 8; j++) {
                System.out.print(taulell[i][j] + " ");
            }
            System.out.println((i + 1));  // Num fila
        }
        System.out.println("  a b c d e f g h");
    }
}
