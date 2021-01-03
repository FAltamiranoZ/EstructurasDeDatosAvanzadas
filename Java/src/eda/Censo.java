package eda;


public class Censo<T extends Comparable> implements Comparable<Censo<T>> {

    private int clave, ano;
    private String titulo;

    public Censo(int clave, int ano, String titulo) {
        this.clave = clave;
        this.ano = ano;
        this.titulo = titulo;
    }

    @Override
    public int compareTo(Censo<T> o) {
        if (this.clave == o.clave) {
            return 0;
        }
        if (this.clave < o.clave) {
            return -1;
        }
        return 1;
    }

    public int getClave() {
        return clave;
    }

    public int getAno() {
        return ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Censo{" + "clave=" + clave + ", ano=" + ano + ", titulo=" + titulo + '}';
    }

}
