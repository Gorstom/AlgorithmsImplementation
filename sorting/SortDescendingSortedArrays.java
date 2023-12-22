import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SortDescendingSortedArrays {
    public static void insertionSort(double[] A) {
        for (int j = 1; j < A.length; j++) {
            double key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
    }

    public static void merge(double[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        double[] L = new double[n1];
        double[] R = new double[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }
        int i = 0;
        int j = 0;
        int k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(double[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void mergeSort(double[] A) {
        mergeSort(A, 0, A.length - 1);
    }

    public static void swap(double[] A, int i, int j) {
        double temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    //partition will be used in quicksort
    public static int partition(double[] A, int p, int r) {
        double x = A[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return i + 1;
    }

    public static void quickSort(double[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public static void countingSort(double[] A, double[] B, double k) {
        int[] C = new int[(int) (k + 1)];

        for (int i = 0; i < A.length; i++)
            C[(int) A[i]]++;
        // C[i] now contains equal i elements
        for (int i = 1; i < C.length; i++)
            C[i] += C[i - 1];
        // C[i] now contains a number of elements less than or equal to i.

        for (int i = A.length - 1; i >= 0; i--) {
            B[C[(int) A[i]] - 1] = A[i];
            C[(int) A[i]]--;
        }
    }

    public static void bubbleSort(double[] A) {
        int n = A.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    double temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    public static void reverse(double[] array)
    {

        // Length of the array
        int n = array.length;

        // Swapping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            double temp = array[i];

            // Assigning the first half to the last half
            array[i] = array[n - i - 1];

            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        String fileName = "output2.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int hugeSize = 500000;
            int smallSize = 30;
            double[] hugeTemplateTable = new double[hugeSize];
            double[] smallTemplateTable = new double[smallSize];


            //filling template arrays
            Random random = new Random();
            for (int i = 0; i < hugeTemplateTable.length; i++) {
                double n = random.nextDouble() * 1000;
                n = Math.round(n);
                hugeTemplateTable[i] = n;
            }


            for (int i = 0; i < smallTemplateTable.length; i++) {
                double n = random.nextDouble() * 1000;
                n = Math.round(n);
                smallTemplateTable[i] = n;
            }

            double[] hugeDesceningSortedTemplateTable = smallTemplateTable.clone();
            double[] smallDesceningSortedTemplateTable = smallTemplateTable.clone();
            Arrays.sort(hugeDesceningSortedTemplateTable);
            reverse(hugeDesceningSortedTemplateTable);
            Arrays.sort(smallDesceningSortedTemplateTable);
            reverse(smallDesceningSortedTemplateTable);
            //template arrays are sorted descending

            double[] hugeInsertionSortTable = hugeDesceningSortedTemplateTable.clone();
            double[] smallInsertionSortTable = smallDesceningSortedTemplateTable.clone();
            double[] hugeMergeSortTable = hugeDesceningSortedTemplateTable.clone();
            double[] smallMergeSortTable = smallDesceningSortedTemplateTable.clone();
            double[] hugeQuickSortTable = hugeDesceningSortedTemplateTable.clone();
            double[] smallQuickSortTable = smallDesceningSortedTemplateTable.clone();
            double[] hugeCountingSortTable = hugeDesceningSortedTemplateTable.clone();
            double[] helpHugeCountingSortTable = new double[hugeCountingSortTable.length];
            double[] smallCountingSortTable = smallDesceningSortedTemplateTable.clone();
            double[] helpHSmallCountingSortTable = new double[smallCountingSortTable.length];
            double[] hugeBubbleSortTable = hugeDesceningSortedTemplateTable.clone();
            double[] smallBubbleSortTable = smallDesceningSortedTemplateTable.clone();

            long startTime = System.nanoTime();
            insertionSort(hugeInsertionSortTable);
            long endTime = System.nanoTime();
            System.out.println("After insertion sort for huge reverse sorted array:");

            long timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            insertionSort(smallInsertionSortTable);
            endTime = System.nanoTime();
            System.out.println("After insertion sort for small reverse sorted array:");

            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");


            startTime = System.nanoTime();
            mergeSort(hugeMergeSortTable);
            endTime = System.nanoTime();
            System.out.println("After merge sort for huge reverse sorted array:");

            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            mergeSort(smallMergeSortTable);
            endTime = System.nanoTime();
            System.out.println("After merge sort for small reverse sorted array:");

            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            quickSort(hugeQuickSortTable,0,hugeQuickSortTable.length-1);
            endTime = System.nanoTime();
            System.out.println("After quick sort for huge reverse sorted array:");

            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            startTime = System.nanoTime();
            quickSort(smallQuickSortTable,0,smallQuickSortTable.length-1);
            endTime = System.nanoTime();
            System.out.println("After quick sort for small reverse sorted array:");

            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");

            //----------------------
            startTime = System.nanoTime();
            int maximum = (int)hugeCountingSortTable[0];

            // Find the maximum value in the array
            for (int i = 1; i < hugeCountingSortTable.length; i++) {
                if (hugeCountingSortTable[i] > maximum)
                    maximum = (int)hugeCountingSortTable[i];
            }


            countingSort(hugeCountingSortTable,helpHugeCountingSortTable,maximum);
            endTime = System.nanoTime();
            System.out.println("After counting sort for huge reverse sorted array:");

            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");


            startTime = System.nanoTime();
            maximum = (int)smallCountingSortTable[0];

            // Find the maximum value in the array
            for (int i = 1; i < smallCountingSortTable.length; i++) {
                if (smallCountingSortTable[i] > maximum)
                    maximum = (int)smallCountingSortTable[i];
            }
            countingSort(smallCountingSortTable,helpHSmallCountingSortTable,maximum);
            endTime = System.nanoTime();
            System.out.println("After counting sort for small reverse sorted array:");

            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");


            startTime = System.nanoTime();
            bubbleSort(hugeBubbleSortTable);
            endTime = System.nanoTime();
            System.out.println("After bubble sort for huge reverse sorted array:");
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");
            bufferedWriter.append(timeElapsed + ",");


            startTime = System.nanoTime();
            bubbleSort(smallBubbleSortTable);
            endTime = System.nanoTime();
            System.out.println("After bubble sort for small reverse sorted array:");
            timeElapsed = endTime - startTime;
            System.out.println("Operation time: " + timeElapsed + " nanoseconds = "+ timeElapsed/1000 + " microseconds\n");

            String stringValue = String.valueOf(timeElapsed);
            bufferedWriter.append(stringValue);

            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
