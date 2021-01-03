package eda;

import java.util.Iterator;

public interface BinaryTreeADT<T> {

    public boolean isEmpty();

    public int size();

    public boolean contains(T elem);

    public T find(T elem);

    public String toString();

    public Iterator<T> inOrder();

    public Iterator<T> postOrder();

    public Iterator<T> preOrder();

    public Iterator<T> levelOrder();
}
