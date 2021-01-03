package eda;

import eda.exceptions.*;
import java.util.*;

public class LinkedBinaryTree<T extends Comparable> implements BinaryTreeADT<T> {

    protected int cont;
    protected BinaryTreeNode<T> raiz;

    public LinkedBinaryTree() {
        cont = 0;
        raiz = null;
    }

    public LinkedBinaryTree(T obj) {
        cont = 1;
        raiz = new BinaryTreeNode(obj);
    }

    @Override
    public boolean isEmpty() {
        return raiz == null;
    }

    @Override
    public int size() {
        return raiz.numDescendientes();
    }

    @Override
    public boolean contains(T obj) {
        return false;
    }

    @Override
    public T find(T obj) throws ElementNotFoundException {
        if (busca(obj, raiz) != null) {
            return obj;
        } else {
            throw new ElementNotFoundException();
        }
    }

    private BinaryTreeNode<T> busca(T elem, BinaryTreeNode<T> actual) {

        if (actual == null) {
            return null;
        }
        if (actual.getElem().equals(elem)) {
            return actual;
        }
        BinaryTreeNode temp = busca(elem, actual.getLeft());
        if (temp == null) {
            temp = busca(elem, actual.getRight());
        }
        return temp;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public Iterator<T> inOrder() {
        ArrayList<T> lista = new ArrayList();
        InOrder(lista, raiz);
        return lista.iterator();
    }

    private void InOrder(ArrayList<T> lista, BinaryTreeNode<T> actual) {
        if (actual == null) {
            return;
        }
        InOrder(lista, actual.getLeft());
        lista.add(actual.getElem());
        InOrder(lista, actual.getRight());
    }

    @Override
    public Iterator<T> postOrder() {
        ArrayList<T> lista = new ArrayList();
        PostOrder(lista, raiz);
        return lista.iterator();
    }

    private void PostOrder(ArrayList<T> lista, BinaryTreeNode<T> actual) {
        if (actual == null) {
            return;
        }
        PostOrder(lista, actual.getLeft());
        PostOrder(lista, actual.getRight());
        lista.add(actual.getElem());
    }

    @Override
    public Iterator<T> preOrder() {
        ArrayList<T> lista = new ArrayList();
        preOrder(lista, raiz);
        return lista.iterator();
    }

    private void preOrder(ArrayList<T> lista, BinaryTreeNode<T> actual) {
        if (actual == null) {
            return;
        }
        lista.add(actual.getElem());
        preOrder(lista, actual.getLeft());
        preOrder(lista, actual.getRight());
    }

    public Iterator preOrderIterativo() { //Si uso una cola, se imprimen por pisos de izquierda a derecha
        Stack<BinaryTreeNode<T>> p = new Stack(); //Al usar un stack, si pongo primero getIzq -> se organiza por la derecha
        ArrayList<T> lista = new ArrayList();
        BinaryTreeNode<T> temp;
        p.push(raiz);
        while (!p.isEmpty()) {
            temp = p.pop();
            lista.add(temp.getElem());
            if (temp.getLeft() != null) {
                p.push(temp.getLeft());
            }
            if (temp.getRight() != null) {
                p.push(temp.getRight());
            }
        }
        return lista.iterator();
    }

    @Override
    public Iterator<T> levelOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int altura() {
        if (raiz == null) {
            return -1;
        } else {
            return alturaSupport(raiz, 0);
        }
    }

    private int alturaSupport(BinaryTreeNode<T> actual, int res) {
        int resI = res, resD = res;
        if (actual != null) {
            resI += alturaSupport(actual.getLeft(), resI + 1);
            resD += alturaSupport(actual.getLeft(), resD + 1);
        }
        return Math.max(resI, resD);
    }

}
