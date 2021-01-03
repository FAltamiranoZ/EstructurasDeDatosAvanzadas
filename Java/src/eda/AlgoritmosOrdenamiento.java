package eda;


import java.util.*;
import java.io.*;

public class AlgoritmosOrdenamiento<T extends Comparable> {

    private int consultas;
    private Censo[] censos = new Censo[12214];
    private Censo[] censos2 = new Censo[10000];
    private Censo[] censos3 = new Censo[5000];
    private Censo[] censos4 = new Censo[2500];
    private Censo[] censos5 = new Censo[1000];
    private Censo[] censos6 = new Censo[500];
    private Censo[] censos7 = new Censo[100];
    private Censo[] censos8 = new Censo[10];
    private Censo[] censos9 = new Censo[1];

    public <T extends Comparable> void inserciónDirecta(T[] arre) {
        int i, j;
        T aux;
        for (i = 1; i < arre.length; i++) {
            consultas++;
            j = i - 1;
            aux = arre[i];
            while (j >= 0 && aux.compareTo(arre[j]) < 0) {
                arre[j + 1] = arre[j];
                j--;
            }
            arre[j + 1] = aux;
        }
    }

    public <T extends Comparable> void bubbleSort(T[] arre) {
        int n = arre.length;
        T aux;
        while (n > 0) {
            for (int i = 1; i < n; i++) {
                consultas++;
                if (arre[i].compareTo(arre[i - 1]) < 0) {
                    aux = arre[i];
                    arre[i] = arre[i - 1];
                    arre[i - 1] = aux;
                }
            }
            n--;
        }
    }

    public <T extends Comparable> void bubbleSortInv(T[] arre) {
        int n = arre.length;
        T aux;
        while (n > 0) {
            for (int i = 1; i < n; i++) {
                consultas++;
                if (arre[i].compareTo(arre[i - 1]) < 0) {
                    aux = arre[i];
                    arre[i] = arre[i - 1];
                    arre[i - 1] = aux;
                }
            }
            n--;
        }
    }

    public <T extends Comparable> void quickSort(T[] arre, int inferior, int superior) {
        int pivote = find_partition(arre, inferior, superior);
        consultas++;
        if (inferior >= superior) {
            return;
        }
        quickSort(arre, inferior, pivote);
        quickSort(arre, pivote + 1, superior);
    }

    private <T extends Comparable> int find_partition(T[] arre, int inferior, int superior) {
        T aux;
        T pivote = arre[inferior];
        consultas++;
        while (inferior < superior) {
            if (arre[inferior + 1].compareTo(pivote) <= 0) {
                arre[inferior] = arre[inferior + 1];
                arre[inferior + 1] = pivote;
            } else {
                aux = arre[superior];
                arre[superior] = arre[inferior + 1];
                arre[inferior + 1] = aux;
                inferior--;
                superior--;
            }
            inferior++;
        }
        return inferior;
    }

    public <T extends Comparable> void mergeSort(T[] datos, int min, int max) {
        int pivote;

        if (min >= max) {
            return;
        }
        consultas++;
        pivote = (min + max) / 2;
        mergeSort(datos, min, pivote);
        mergeSort(datos, pivote + 1, max);

        int i = min, j = pivote + 1, k = 0;
        T[] temp = (T[]) new Comparable[max - min + 1];
        while (i <= pivote && j <= max) {
            if (datos[i].compareTo(datos[j]) < 0) {
                temp[k] = datos[i];
                i++;
            } else {
                temp[k] = datos[j];
                j++;
            }
            k++;
        }
        if (i <= pivote) {
            while (i <= pivote) {
                temp[k] = datos[i];
                k++;
                i++;
            }
        } else {
            while (j <= max) {
                temp[k] = datos[j];
                k++;
                j++;
            }
        }
        for (int n = 0; n < temp.length; n++) {
            datos[min + n] = temp[n];
        }
    }

    public int getConsultas() {
        return consultas;
    }

    public Censo[] getCensos() {
        return censos;
    }

    public Censo[] getCensos2() {
        return censos2;
    }

    public Censo[] getCensos3() {
        return censos3;
    }

    public Censo[] getCensos4() {
        return censos4;
    }

    public Censo[] getCensos5() {
        return censos5;
    }

    public Censo[] getCensos6() {
        return censos6;
    }

    public Censo[] getCensos7() {
        return censos7;
    }

    public Censo[] getCensos8() {
        return censos8;
    }

    public Censo[] getCensos9() {
        return censos9;
    }

    public void lectura() {
        Censo censo;
        Scanner lectura;
        File unArchivo;
        int clave, anio, n = 12214, contador = 0;
        String titulo, linea;
        StringBuilder sb = new StringBuilder();

        unArchivo = new File("movie_titles2.txt");
        try {
            lectura = new Scanner(unArchivo);
            for (int i = 0; i < n; i++) {
                linea = lectura.nextLine();
                int pos = 0;
                while (linea.charAt(pos) != ',') {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                clave = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                pos += 1;
                for (int k = 0; k < 4; k++) {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                pos += 1;
                anio = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                titulo = linea.substring(pos);
                censo = new Censo(clave, anio, titulo);
                censos[contador++] = censo;
                pos = 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lectura2() {
        Censo censo;
        Scanner lectura;
        File unArchivo;
        int clave, anio, n = 10000, contador = 0;
        String titulo, linea;
        StringBuilder sb = new StringBuilder();
        unArchivo = new File("movie_titles2.txt");
        try {
            lectura = new Scanner(unArchivo);
            for (int i = 0; i < n; i++) {
                linea = lectura.nextLine();
                int pos = 0;
                while (linea.charAt(pos) != ',') {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                clave = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                pos += 1;
                for (int k = 0; k < 4; k++) {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                pos += 1;
                anio = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                titulo = linea.substring(pos);
                censo = new Censo(clave, anio, titulo);
                censos2[contador++] = censo;
                pos = 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lectura3() {
        Censo censo;
        Scanner lectura;
        File unArchivo;
        int clave, anio, n = 5000, contador = 0;
        String titulo, linea;
        StringBuilder sb = new StringBuilder();
        unArchivo = new File("movie_titles2.txt");
        try {
            lectura = new Scanner(unArchivo);
            for (int i = 0; i < n; i++) {
                linea = lectura.nextLine();
                int pos = 0;
                while (linea.charAt(pos) != ',') {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                clave = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                pos += 1;
                for (int k = 0; k < 4; k++) {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                pos += 1;
                anio = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                titulo = linea.substring(pos);
                censo = new Censo(clave, anio, titulo);
                censos3[contador++] = censo;
                pos = 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lectura4() {
        Censo censo;
        Scanner lectura;
        File unArchivo;
        int clave, anio, n = 2500, contador = 0;
        String titulo, linea;
        StringBuilder sb = new StringBuilder();
        unArchivo = new File("movie_titles2.txt");
        try {
            lectura = new Scanner(unArchivo);
            for (int i = 0; i < n; i++) {
                linea = lectura.nextLine();
                int pos = 0;
                while (linea.charAt(pos) != ',') {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                clave = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                pos += 1;
                for (int k = 0; k < 4; k++) {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                pos += 1;
                anio = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                titulo = linea.substring(pos);
                censo = new Censo(clave, anio, titulo);
                censos4[contador++] = censo;
                pos = 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lectura5() {
        Censo censo;
        Scanner lectura;
        File unArchivo;
        int clave, anio, n = 1000, contador = 0;
        String titulo, linea;
        StringBuilder sb = new StringBuilder();
        unArchivo = new File("movie_titles2.txt");
        try {
            lectura = new Scanner(unArchivo);
            for (int i = 0; i < n; i++) {
                linea = lectura.nextLine();
                int pos = 0;
                while (linea.charAt(pos) != ',') {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                clave = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                pos += 1;
                for (int k = 0; k < 4; k++) {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                pos += 1;
                anio = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                titulo = linea.substring(pos);
                censo = new Censo(clave, anio, titulo);
                censos5[contador++] = censo;
                pos = 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lectura6() {
        Censo censo;
        Scanner lectura;
        File unArchivo;
        int clave, anio, n = 500, contador = 0;
        String titulo, linea;
        StringBuilder sb = new StringBuilder();
        unArchivo = new File("movie_titles2.txt");
        try {
            lectura = new Scanner(unArchivo);
            for (int i = 0; i < n; i++) {
                linea = lectura.nextLine();
                int pos = 0;
                while (linea.charAt(pos) != ',') {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                clave = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                pos += 1;
                for (int k = 0; k < 4; k++) {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                pos += 1;
                anio = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                titulo = linea.substring(pos);
                censo = new Censo(clave, anio, titulo);
                censos6[contador++] = censo;
                pos = 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lectura7() {
        Censo censo;
        Scanner lectura;
        File unArchivo;
        int clave, anio, n = 100, contador = 0;
        String titulo, linea;
        StringBuilder sb = new StringBuilder();
        unArchivo = new File("movie_titles2.txt");
        try {
            lectura = new Scanner(unArchivo);
            for (int i = 0; i < n; i++) {
                linea = lectura.nextLine();
                int pos = 0;
                while (linea.charAt(pos) != ',') {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                clave = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                pos += 1;
                for (int k = 0; k < 4; k++) {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                pos += 1;
                anio = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                titulo = linea.substring(pos);
                censo = new Censo(clave, anio, titulo);
                censos7[contador++] = censo;
                pos = 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lectura8() {
        Censo censo;
        Scanner lectura;
        File unArchivo;
        int clave, anio, n = 10, contador = 0;
        String titulo, linea;
        StringBuilder sb = new StringBuilder();
        unArchivo = new File("movie_titles2.txt");
        try {
            lectura = new Scanner(unArchivo);
            for (int i = 0; i < n; i++) {
                linea = lectura.nextLine();
                int pos = 0;
                while (linea.charAt(pos) != ',') {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                clave = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                pos += 1;
                for (int k = 0; k < 4; k++) {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                pos += 1;
                anio = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                titulo = linea.substring(pos);
                censo = new Censo(clave, anio, titulo);
                censos8[contador++] = censo;
                pos = 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void lectura9() {
        Censo censo;
        Scanner lectura;
        File unArchivo;
        int clave, anio, n = 1, contador = 0;
        String titulo, linea;
        StringBuilder sb = new StringBuilder();
        unArchivo = new File("movie_titles2.txt");
        try {
            lectura = new Scanner(unArchivo);
            for (int i = 0; i < n; i++) {
                linea = lectura.nextLine();
                int pos = 0;
                while (linea.charAt(pos) != ',') {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                clave = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                pos += 1;
                for (int k = 0; k < 4; k++) {
                    sb.append(linea.charAt(pos));
                    pos += 1;
                }
                pos += 1;
                anio = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                titulo = linea.substring(pos);
                censo = new Censo(clave, anio, titulo);
                censos9[contador++] = censo;
                pos = 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
