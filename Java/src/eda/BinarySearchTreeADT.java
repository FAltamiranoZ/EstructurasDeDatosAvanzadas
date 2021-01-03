package eda;

/**
 *
 * @author hca
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {

    public void add(T elem);

    public void remove(T elem);

    public T findMin();

    public T findMax();

    public T removeMin();

    public T removeMax();
}
