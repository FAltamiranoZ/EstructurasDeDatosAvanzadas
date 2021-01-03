package eda;

import static java.lang.Math.random;

/**
 *
 * @author hca
 * @param <T>
 */
public class SkipList<T extends Comparable> {

    NodoSkip<T> cabeza, cola;
    int cont, numListas;

    public SkipList() {
        clear();
    }

    public void clear() {
        cabeza = new NodoSkip(null);
        cola = new NodoSkip(null);
        numListas = 1;
        cont = 0;
        cabeza.setDer(cola);
        cola.setIzq(cabeza);
    }

    public NodoSkip<T> busca(T elem) {
        if (cont == 0) {
            return null;
        } else {
            return busca(elem, cabeza);
        }
    }

    private NodoSkip<T> busca(T elem, NodoSkip actual) {
        if (actual.der == null) {
            return null;
        } else {
            if (elem.compareTo(actual.getElem()) > 0) {
                return busca(elem, actual.der);
            } else {
                if (actual.getAbajo() != null) {
                    return busca(elem, actual.abajo);
                } else {
                    if (elem.compareTo(actual.getElem()) == 0) {
                        return actual;
                    } else {
                        return null;
                    }
                }
            }
        }
    }

    public boolean contains(T elem) {
        return (busca(elem) != null);
    }

    public void expande() {
        //Falta implementar
        numListas++;
    }

    public boolean inserta(T elem) {
        if (contains(elem)) {
            return false;
        } else {
            NodoSkip actual = busca(elem);
            NodoSkip nuevo = new NodoSkip<>();
            actual.ligaID(nuevo);//Liga hasta abajo
            cont++;
            int i = 0;
            while (random() < .5 && i < Math.log(cont)) {
                if (Math.log(cont) + 1 > numListas && i == Math.log(cont)) {
                    expande();
                }
                NodoSkip temp = new NodoSkip<>(elem);
                nuevo.ligaAB(temp);
                nuevo = nuevo.getArriba();
                nuevo.ligaID(temp);
                i++;
            }
            return true;
        }
    }

    public boolean elimina(T elem) {
        if (!contains(elem)) {
            return false;
        } else {
            NodoSkip actual = busca(elem);
            if (actual.der == cola && actual.izq == cabeza) {
                clear();
            }
            actual.desliga();
            while (actual.getArriba() != null) {
                actual = actual.getArriba();
                actual.desliga();
            }
            if (numListas > Math.log(cont) && numListas > 1) {
                /*
                Si se cumple la condición, es porque hay demasiados pisos para el número de objetos, por lo que
                borra
                 */
                cabeza = cabeza.abajo;
                cola = cola.abajo;
                actual = cabeza;
                while (actual != null) {
                    actual.setArriba(null);
                    actual = actual.getDer();
                }
                numListas--;
            }
            cont--;
            return true;
        }
    }
}
