package eda;

import eda.exceptions.*;

/**
 *
 * @author hca
 * @param <T>
 */
public class LinkedBinarySearchTree<T extends Comparable> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

    @Override
    public void add(T elem) {
        BinaryTreeNode<T> nuevo = new BinaryTreeNode(elem);
        BinaryTreeNode<T> actual = raiz, papa = raiz;
        if (raiz == null) {
            raiz = nuevo;
            cont++;
            return;
        }
        while (actual != null) {
            papa = actual;
            if (elem.compareTo(actual.getElem()) <= 0) {
                actual = actual.getLeft();

            } else {
                actual = actual.getRight();
            }
        }
        papa.cuelga(nuevo);
        cont++;
    }

    @Override
    public void remove(T elem) {
        BinaryTreeNode<T> actual = raiz, papa = raiz;
        while (actual != null && actual.getElem().compareTo(elem) != 0) {
            papa = actual;
            if (elem.compareTo(actual.getElem()) < 0) {
                actual = actual.getLeft();
            } else {
                actual = actual.getRight();
            }
        }
        if (actual == null) {
            throw new ElementNotFoundException();
        }
        if (actual == raiz && (actual.getLeft() == null || actual.getRight() == null)) {//Caso donde la raíz tiene una sola hoja.
            if (raiz.getLeft() != null) {
                raiz = raiz.getLeft();
            } else {
                raiz = raiz.getRight();
            }
            cont--;
            return;
        }
        if (actual.getLeft() == null && actual.getRight() == null) {//Caso de hoja
            if (papa.getLeft() == actual) {//Ve si esta a la derecha o la izquierda
                papa.setLeft(null);
            } else {
                papa.setRight(null);
            }
            cont--;
        } else {//Si no es una hoja, debe de ser un nodo
            if (!(actual.getLeft() != null && actual.getRight() != null)) {//Un hijo, si se cumplen las 2, el ! al inicio lo saca
                papa.cuelga(actual.getLeft());
                papa.cuelga(actual.getRight());
            } else {//Si tiene 2 hijos
                BinaryTreeNode<T> temp = actual;
                actual = actual.getRight();
                papa = actual;
                while (actual.getLeft() != null) {
                    papa = actual;
                    actual = actual.getLeft();
                }
                temp.setElem(actual.getElem());
                if (papa == actual) {
                    temp.setRight(actual.getRight());
                } else {
                    papa.setLeft(actual.getRight());
                }

            }
            cont--;
        }
    }

    @Override
    public T findMin() {
        BinaryTreeNode<T> actual = raiz;
        if (raiz == null) {
            throw new ElementNotFoundException();
        }
        while (actual.getLeft() != null) {
            actual.getLeft();
        }
        return actual.getElem();
    }

    @Override
    public T findMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeMin() {
        BinaryTreeNode<T> actual, papa;
        T elem;
        if (raiz == null) {
            throw new ElementNotFoundException();
        }
        if (raiz.getLeft() == null) {
            elem = raiz.getElem();
            raiz = raiz.getRight();
            cont--;
            return elem;
        }
        actual = raiz.getLeft();
        papa = raiz;
        while (actual.getLeft() != null) {
            papa = actual;
            actual = actual.getLeft();
        }
        elem = actual.getElem();
        papa.setLeft(actual.getRight());
        cont--;
        return elem;
    }

    @Override
    public T removeMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object busca(T elem, BinaryTreeNode<T> actual) {
        if (actual == null) {
            return actual;
        }
        if (actual.getElem().compareTo(elem) == 0) {
            return actual;
        }
        if (elem.compareTo(actual.getElem()) <= 0) {
            return busca(elem, actual.getLeft());
        } else {
            return busca(elem, actual.getRight());
        }
    }

}
