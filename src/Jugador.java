import java.util.ArrayList;
public class Jugador <E extends Itipopieza> {
    private ArrayList<E> piezasVivas;

    public Jugador(ArrayList<E> piezasVivas) {
        this.piezasVivas = piezasVivas;
    }

    private E buscarEnPosicion(int fil, int col) {
        for (E pieza : piezasVivas) {
            if (pieza.getFila() == fil && pieza.getColumna() == col) {
                return pieza;
            }
        }
        return null;
    }

    public boolean eliminarPiezaPosicion(int fil, int col) throws FiJocException {
        E pieza = buscarEnPosicion(fil, col);
        if (pieza != null) {
            if(pieza.fiJoc()){
                throw new FiJocException("Has matat al rei!");
            }
            piezasVivas.remove(pieza);
            return true;
        }
        return false;
    }

    public void moverPieza(int fil1, int col1, int fil2, int col2) throws RuntimeException {
        E pieza = buscarEnPosicion(fil1, col1);
        if (pieza != null) {
            E pieza2=buscarEnPosicion(fil2,col2);

            try{
                pieza.setPosicion(fil2, col2);
                if(pieza)
            }
            catch(RuntimeException e){
                System.out.println("No pots moure la peça:" + e.getMessage());
            }
        }
        throw new RuntimeException("Peça no trobada!");
    }

}
