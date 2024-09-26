public interface TipoPieza {

    //Classe abstracta per a la classe peça!!

    public abstract String getTipus();
    public abstract int getFila();
    public abstract int getColumna();
    public  abstract boolean fiJoc();
    public abstract void setPosicio(int fil, int col);
}
