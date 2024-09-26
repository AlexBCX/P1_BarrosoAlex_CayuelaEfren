public interface TipusPesa {

    //Classe abstracta per a la classe peça!!

    public abstract String getTipus();
    public abstract int getFila();
    public abstract char getColumna();
    public  abstract boolean fiJoc();
    public abstract void setPosicio(int fil, char col);
}
