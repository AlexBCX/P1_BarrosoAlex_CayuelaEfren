public class Pesa implements TipusPesa{
    private final char tipus; //(R, D, T, C, A, P -> Rey, Dama, Torre, Caballo, Alfil, Peón)
    private char col;
    private int fil;

    public Pesa(char tipus, char col, int fil){
        checkPieza(tipus);
        this.tipus = tipus;
        this.col = col;
        this.fil = fil;
    }
private void checkPieza(char tipus){
        if(tipus!='R'&&tipus!='D'&&tipus!='T'&&tipus!='C'&&tipus!='A'&&tipus!='P'){
            throw new IllegalArgumentException("Tipo de pieza no valido");
        }
}

    @Override
    public String getTipus() {
        switch (this.tipus){
            case 'R': return "Rei.";
            case 'D': return "Dama.";
            case 'T': return "Torre.";
            case 'C': return "Cavall.";
            case 'A': return "Alfil";
            case 'P': return "Peó.";

        }
        return null;
    }

    @Override
    public char getColumna() {
        return this.col;
    }

    @Override
    public int getFila() {
        return this.fil;
    }

    @Override
    public boolean fiJoc() {//acabarla
        return false;
    }

    @Override
    public void setPosicio(int fil, char col) {
        if (fil < 1 || fil > 8 || col < 'a' || col > 'h') {
            throw new RuntimeException("Posició fora del taulell");
        }
        this.fil = fil;
        this.col = col;
    }
}
