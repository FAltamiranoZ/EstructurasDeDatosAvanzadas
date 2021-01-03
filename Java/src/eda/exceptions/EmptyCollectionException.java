package eda.exceptions;

/**
 * Excepcion lanzada si la colección esta vacia.
 *
 * @author Hagen
 */
public class EmptyCollectionException extends RuntimeException {

    public EmptyCollectionException(String collection) {
        super("La colleccion " + collection + " está vacia");
    }

}
