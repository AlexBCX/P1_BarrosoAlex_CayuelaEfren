import java.util.ArrayList;

public class Jugador<E extends ITipusPesa> {
    private ArrayList<E> piezasVivas;

    // Constructor
    public Jugador(ArrayList<E> piezasVivas) {
        this.piezasVivas = piezasVivas;
    }

    // Método para buscar una pieza en una posición específica
    private E buscarEnPosicion(int fil, int col) {
        for (E pieza : piezasVivas) {
            if (pieza.getFila() == fil && pieza.getColumna() == col) {
                return pieza;
            }
        }
        return null;
    }

    // Método para eliminar una pieza en una posición dada
    public boolean eliminarPiezaPosicion(int fil, int col) throws FiJocException {
        E pieza = buscarEnPosicion(fil, col);
        if (pieza != null) {
            if (pieza.fiJoc()) {
                throw new FiJocException("Has matat al rei!"); // Se lanza la excepción si se elimina el rey
            }
            piezasVivas.remove(pieza);
            return true;
        }
        return false; // Si no hay pieza en la posición dada
    }

    // Método para mover una pieza de una posición a otra
    public void moverPieza(int fil1, int col1, int fil2, int col2) {
        E pieza = buscarEnPosicion(fil1, col1);
        if (pieza != null) {
            // Buscamos si hay una pieza en la nueva posición
            E piezaDestino = buscarEnPosicion(fil2, col2);

            try {

                if (piezaDestino != null && piezaDestino.getTipus() != pieza.getTipus()) {
                    piezasVivas.remove(piezaDestino);
                }

                // Intentamos mover la pieza a la nueva posición
                pieza.setPosicion(fil2, col2);
            } catch (RuntimeException e) {
                System.out.println("No pots moure la peça: " + e.getMessage());
                return;
            }
        } else {
            throw new RuntimeException("Peça no trobada!");
        }
    }

    public ArrayList<E> getPiezasVivas() {
        return piezasVivas;
    }
}

