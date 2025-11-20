public class BubleSort {

    public static void main(String[] args) {
        int[] arreglo = {5, 2, 9, 1, 5, 6};

        bubbleSort(arreglo);

        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean intercambio;

        for (int i = 0; i < n - 1; i++) {
            intercambio = false;

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    // Intercambiar
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    intercambio = true;
                }
            }

            // Si no hubo ningún intercambio, ya está ordenado
            if (!intercambio) {
                break;
            }
        }
    }
}
