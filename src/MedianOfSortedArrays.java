import java.util.ArrayList;
import java.util.Arrays;

class MedianOfSortedArrays {

    public static double findMedianSortedArrays(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> total = new ArrayList<>();
        boolean done = false;

        while (!done) {
            if (i < m && j < n) {
                // add smaller item to arraylist or add both if equal
                // then iterate the respective index
                if (A[i] < B[j])
                    total.add(A[i++]);
                else if (B[j] < A[i])
                    total.add(B[j++]);
                else {
                    total.add(A[i++]);
                    total.add(B[j++]);
                }
            }
            // add remaining items
            else if (i < m)
                total.add(A[i++]);
            else if (j < n)
                total.add(B[j++]);
            else
                done = true;
        }

        if (total.size() % 2 != 0)
            return (double) total.get(total.size() / 2);
        else {
            int mid = total.get((total.size() / 2));
            int midMinusOne = total.get((total.size() - 1) / 2);
            return (mid + midMinusOne) / 2.0;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] A = new int[]{1,2};
        int[] B = new int[]{3,4};
        int[] C = new int[]{1,2};
        int[] D = new int[]{3};

        double result = findMedianSortedArrays(A, B);
        double result1 = findMedianSortedArrays(C, D);

        System.out.println("Median of " + Arrays.toString(A) + " and " + Arrays.toString(B) + " is : " + result);
        System.out.println("Median of " + Arrays.toString(C) + " and " + Arrays.toString(D) + " is : " + result1);
    }

}