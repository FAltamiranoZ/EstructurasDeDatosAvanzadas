package EDA;

/**
 *
 * @author Hagen
 */
public class AlgoritmosOrdenamientoOriginal {

    public static void inserciónDirecta(int[] arre) {
        int i, j, aux;
        for (i = 1; i < arre.length; i++) {
            j = i - 1;
            aux = arre[i];
            while (j >= 0 && aux < arre[j]) {
                arre[j + 1] = arre[j];
                j--;
            }
            arre[j + 1] = aux;
        }
    }

    public static void bubbleSort(int[] arre) {
        int l = arre.length;
        int aux;
        while (l > 0) {
            for (int i = 1; i < l; i++) {
                if (arre[i] < arre[i - 1]) {
                    aux = arre[i];
                    arre[i] = arre[i - 1];
                    arre[i - 1] = aux;
                }
            }
            l--;
        }
    }

    public static void quickSort(int arre[], int inferior, int superior) {
        int pivote = find_partition(arre, inferior, superior);
        if (inferior >= superior) {
            return;
        }
        quickSort(arre, inferior, pivote);
        quickSort(arre, pivote + 1, superior);
    }

    private static int find_partition(int arre[], int inferior, int superior) {
        int aux = 0;
        int pivote = arre[inferior];
        while (inferior < superior) {
            if (arre[inferior + 1] <= pivote) {
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

    public static void mergeSort(int[] datos, int min, int max) {
        int pivote;

        if (min >= max) {
            return;
        }
        pivote = (min + max) / 2;
        mergeSort(datos, min, pivote);
        mergeSort(datos, pivote + 1, max);

        int i = min, j = pivote + 1, k = 0;
        int[] temp = new int[max - min + 1];

        while (i <= pivote && j <= max) {
            if (datos[i] < datos[j]) {
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

    public static void main(String[] args) {
        int[] ejemplo = {1, 5, 3, 7, 2};
        int[] ejemplo2 = {4, 6, 3, 7};
        int[] ejemplo3 = {5, 27, 8, 2, 97, 6};
        int[] ejemplo4 = {7, -2, 8, 1, 65, 20};
        inserciónDirecta(ejemplo);
        for (int i = 0; i < ejemplo.length; i++) {
            System.out.println(ejemplo[i]);
        }
        System.out.println("Haha");
        bubbleSort(ejemplo2);
        for (int i = 0; i < ejemplo2.length; i++) {
            System.out.println(ejemplo2[i]);
        }
        System.out.println("Hehe");
        quickSort(ejemplo3, 0, ejemplo3.length - 1);
        for (int i = 0; i < ejemplo3.length; i++) {
            System.out.println(ejemplo3[i]);
        }
        System.out.println("Hihi");
        mergeSort(ejemplo4, 0, ejemplo4.length - 1);
        for (int i = 0; i < ejemplo4.length; i++) {
            System.out.println(ejemplo4[i]);
        }
    }
}
