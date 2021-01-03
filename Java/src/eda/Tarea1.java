package eda;

public class Tarea1 {

    public static void main(String[] args) {

        AlgoritmosOrdenamiento al = new AlgoritmosOrdenamiento();
        al.lectura();
        al.mergeSort(al.getCensos(), 0, al.getCensos().length - 1);
        System.out.println(al.getConsultas());

        AlgoritmosOrdenamiento al2 = new AlgoritmosOrdenamiento();
        al2.lectura2();
        al2.mergeSort(al2.getCensos2(), 0, al2.getCensos2().length - 2);
        System.out.println(al2.getConsultas());

        AlgoritmosOrdenamiento al3 = new AlgoritmosOrdenamiento();
        al3.lectura3();
        al3.mergeSort(al3.getCensos3(), 0, al3.getCensos3().length - 2);
        System.out.println(al3.getConsultas());

        AlgoritmosOrdenamiento al4 = new AlgoritmosOrdenamiento();
        al4.lectura4();
        al4.mergeSort(al4.getCensos4(), 0, al4.getCensos4().length - 2);
        System.out.println(al4.getConsultas());

        AlgoritmosOrdenamiento al5 = new AlgoritmosOrdenamiento();
        al5.lectura5();
        al5.mergeSort(al5.getCensos5(), 0, al5.getCensos5().length - 2);
        System.out.println(al5.getConsultas());

        AlgoritmosOrdenamiento al6 = new AlgoritmosOrdenamiento();
        al6.lectura6();
        al6.mergeSort(al6.getCensos6(), 0, al6.getCensos6().length - 2);
        System.out.println(al6.getConsultas());

        AlgoritmosOrdenamiento al7 = new AlgoritmosOrdenamiento();
        al7.lectura7();
        al7.mergeSort(al7.getCensos7(), 0, al7.getCensos7().length - 2);
        System.out.println(al7.getConsultas());

        AlgoritmosOrdenamiento al8 = new AlgoritmosOrdenamiento();
        al8.lectura8();
        al8.mergeSort(al8.getCensos8(), 0, al8.getCensos8().length - 2);
        System.out.println(al8.getConsultas());

        AlgoritmosOrdenamiento al9 = new AlgoritmosOrdenamiento();
        al9.lectura9();
        al9.mergeSort(al9.getCensos9(), 0, al9.getCensos9().length - 2);
        System.out.println(al9.getConsultas());

        long startTime = System.currentTimeMillis();
        long total = 0;
        for (int i = 0; i < 10000000; i++) {
            total += i;
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }
}
