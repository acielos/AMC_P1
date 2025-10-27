public final class Quicksort {
    public static void sort(double[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(double[] arr, int low, int high) {
        while (low < high) {
            int p = partition(arr, low, high);

            // Tail call elimination to reduce recursion depth
            if (p - low < high - p) {
                quickSort(arr, low, p - 1);
                low = p + 1;
            } else {
                quickSort(arr, p + 1, high);
                high = p - 1;
            }
        }
    }

    private static int partition(double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Example usage
    public static void main(String[] args) {
        double[] data = {5.3, 1.2, 4.4, 2.9, 3.1, 0.5};
        Quicksort.sort(data);
        for (double d : data) System.out.print(d + " ");
    }
}