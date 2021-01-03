package eda;

public class BinaryTreeNode<T extends Comparable> {

    protected T elem;
    protected BinaryTreeNode<T> left, right;

    BinaryTreeNode(T obj) {
        elem = obj;
        left = null;
        right = null;
    }

    public int numDescendientes() {
        int res = 0;
        if (left != null) {
            res = left.numDescendientes() + 1;
        }
        if (right != null) {
            res += right.numDescendientes() + 1;
        }
        return res;
    }

    public void cuelga(BinaryTreeNode<T> actual) {
        if (actual == null) {
            return;
        }
        if (actual.getElem().compareTo(elem) <= 0) {
            left = actual;
        } else {
            right = actual;
        }
    }

    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

}
