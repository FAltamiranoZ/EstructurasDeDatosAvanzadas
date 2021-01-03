package eda;

/**
 *
 * @author hca
 * @param <T>
 */
public class NodoSkip<T extends Comparable> {

    T elem;
    NodoSkip<T> izq, der, arriba, abajo;

    public NodoSkip() {
        izq = der = arriba = abajo = null;
    }

    public NodoSkip(T elem) {
        this.elem = elem;
        izq = der = arriba = abajo = null;
    }

    public void ligaID(NodoSkip<T> actual) {
        if (actual.elem.compareTo(elem) <= 0) {
            izq.setDer(actual);
            actual.setIzq(izq);
            actual.setDer(this);
            izq = actual;
        } else {
            actual.setDer(der);
            der.setIzq(actual);
            der = actual;
            actual.setIzq(this);
        }
    }

    public void ligaAB(NodoSkip<T> actual) {
        //Falta implementar
    }

    public void desliga() {
        NodoSkip anterior = izq, siguiente = der;
        izq.setDer(der);
        der.setIzq(izq);
    }

    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public NodoSkip<T> getIzq() {
        return izq;
    }

    public void setIzq(NodoSkip<T> izq) {
        this.izq = izq;
    }

    public NodoSkip<T> getDer() {
        return der;
    }

    public void setDer(NodoSkip<T> der) {
        this.der = der;
    }

    public NodoSkip<T> getArriba() {
        return arriba;
    }

    public void setArriba(NodoSkip<T> arriba) {
        this.arriba = arriba;
    }

    public NodoSkip<T> getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoSkip<T> abajo) {
        this.abajo = abajo;
    }

}
