public class Pieza implements TipoPieza{
    private char pieza; //(R, D, T, C, A, P -> Rey, Dama, Torre, Caballo, Alfil, Peón)
    private int fil;
    private int col;








    @Override
    public String getTipus() {
        return "";
    }

    @Override
    public int getFila() {
        return 0;
    }

    @Override
    public int getColumna() {
        return 0;
    }

    @Override
    public boolean fiJoc() {
        return false;
    }

    @Override
    public void setPosicio(int fil, int col) {

    }
}
