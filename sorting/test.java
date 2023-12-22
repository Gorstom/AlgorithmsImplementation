import java.util.*;

public class test {
    public static void radixSort(double[] A, double[] B, double k){

    }

//    public static void bucketSort(double[] A) {
//        //bucket sort musi mieć liczby w zakresie [0;1)
//        int n = A.length;
//
//        // Create empty buckets
//        List<List<Integer>> B = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            B.add(new ArrayList<>());
//        }
//
//        // Add elements to the buckets
//        for (double value : A) {
//            int bucketIndex = (n * value);
//            B.get(bucketIndex).add(value);
//        }
//
//        // Sort individual buckets using insertion sort
//        for (List<Integer> bucket : B) {
//            Collections.sort(bucket);
//        }
//
//        // Concatenate the sorted buckets
//        int index = 0;
//        for (List<Integer> bucket : B) {
//            for (int value : bucket) {
//                A[index++] = value;
//            }
//        }
//    }

    public static void heapSort(double[] A) {

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
    public static void main(String[] args) {
        int smallSize = 1000000;
        double[] smallTemplateTable = new double[smallSize];
        Random random = new Random();

        for (int i = 0; i < smallTemplateTable.length; i++) {
            int n = random.nextInt(1000);
            smallTemplateTable[i] = n;
        }

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(smallTemplateTable));


        bubbleSort(smallTemplateTable);

        System.out.println("After sorting:");
        System.out.println(Arrays.toString(smallTemplateTable));
    }
}
