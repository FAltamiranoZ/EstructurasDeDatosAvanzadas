package eda;

/**
 *
 * @author hca
 * @param <T>
 */
public class NodoHash<T extends Comparable> {

    T elem;
    NodoHash<T> sig;

    public NodoHash(T elem) {
        this.elem = elem;
    }

    public NodoHash() {
    }

}
