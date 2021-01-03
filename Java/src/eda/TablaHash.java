package eda;

/**
 *
 * @author hca
 * @param <T>
 */
public class TablaHash<T extends Comparable> {

    NodoHash<T> tabla[];
    int cont;
    double factor_carga = .7;

    private int getKey(T elem) {
        String s = elem.toString();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += (int) s.charAt(i) * i;
        }
        return res;
    }

    private int findHash(T elem) {
        return getKey(elem) % tabla.length;//Evita salirme del index
    }

    private void expande() {
        NodoHash<T> temp[] = tabla;//copio apuntador
        tabla = (NodoHash<T>[]) new Object[temp.length * 2];//Creo una nueva tabla del doble de espacio
        for (int i = 0; i < temp.length; i++) {
            NodoHash<T> actual = temp[i];
            while (actual != null) {
                agregar(actual.elem);
                actual = actual.sig;
            }
        }
    }

    public boolean busca(T elem) {
        //return tabla[findHash(elem)]!=null;
        NodoHash<T> actual = tabla[findHash(elem)];
        while (actual != null && !actual.elem.equals(elem)) {
            actual = actual.sig;
        }
        return actual != null;
    }

    public void agregar(T elem) {
        //Porque no en lugar de todo esto tabla[findHash(elem)]=elem;
        NodoHash<T> actual = tabla[findHash(elem)];//?
        NodoHash<T> nuevo = new NodoHash(elem);
        nuevo.sig = actual;//?
        tabla[findHash(elem)] = nuevo;
        cont++;
        if (cont / tabla.length > factor_carga) {
            expande();
        }
    }

    public void borra(T elem) {
        NodoHash<T> actual = tabla[findHash(elem)];
        NodoHash<T> anterior = actual;
        while (actual != null && !actual.elem.equals(elem)) {
            anterior = actual;
            actual = actual.sig;
        }
        if (actual != null) {
            anterior = actual.sig;
            if (tabla[findHash(elem)].elem.equals(elem)) {//Si es la cabeza de la lista
                tabla[findHash(elem)] = null;
            }
        }
    }

}
