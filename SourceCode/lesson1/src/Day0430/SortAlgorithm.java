package Day0430;

public class SortAlgorithm {
    //this is a sample code for different sorting algorithms

    //bubble sort
    public static void bubbleSort(int[] arr) {
        //bubble sort from right to left switch
        int n = arr.length;
        //from the higher index to the lower index
        for (int i = 0; i < n - 1; i++) {
            System.out.println("第"+(i+1)+"回目の外部ループです。");
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[j-1]) {
                    // swap arr[j] and arr[j-1]
                    System.out.println(arr[j] + "と" + arr[j-1] + "を交換します。");
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    System.out.println("交換後の配列: " + java.util.Arrays.toString(arr));
                }
            }
        }
    }

    //selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // swap the found minimum element with the first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    //insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    //main method to test the sorting algorithms
    public static void main(String[] args) {
        int[] arr = {5,2,9,1,6};
        System.out.println("Original array:");
        System.out.println(java.util.Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println("Sorted array using bubble sort:");
        System.out.println(java.util.Arrays.toString(arr));

        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(arr2);
        System.out.println("Sorted array using selection sort:");
        System.out.println(java.util.Arrays.toString(arr2));

        int[] arr3 = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(arr3);
        System.out.println("Sorted array using insertion sort:");
        System.out.println(java.util.Arrays.toString(arr3));


    }
}
