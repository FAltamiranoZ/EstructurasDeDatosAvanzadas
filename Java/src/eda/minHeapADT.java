package eda;

/**
 *
 * @author hca
 * @param <T>
 */
public interface minHeapADT<T extends Comparable> {
    public void inserta(T elem);
    public T buscaMin();
    public T borraMin();
}
