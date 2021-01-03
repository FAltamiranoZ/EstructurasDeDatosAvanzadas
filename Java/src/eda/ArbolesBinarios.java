package eda;

public class ArbolesBinarios {

    public static void main(String[] args) {
        BinaryAVLTree<Integer> p = new BinaryAVLTree<Integer>();

        p.insert(50);

        p.insert(20);

        p.insert(10);

        p.insert(10);

        p.insert(12);

        p.insert(89);

        p.insert(74);

        p.insert(90);

        p.imprime();

        System.out.println("Mamamamama");

        p.remove(50);

        p.imprime();

        p.remove(50);

        p.imprime();

        p.remove(20);

        p.imprime();

        p.remove(10);

        p.imprime();
        
        System.out.println("Mememe");

        p.remove(90);

        p.imprime();
    }

}
