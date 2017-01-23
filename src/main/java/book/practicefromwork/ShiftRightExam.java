package book.practicefromwork;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hovaheb on 1/11/2017.
 */
public class ShiftRightExam {

    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        for (int counter = 1; counter <= K; counter++) {
            int n = A.length - 1;
            int temp = A[n];
            for (int i = 0; i < n; i++) {
                A[n - i] = A[n - i - 1];
            }
            A[0] = temp;
        }
        return A;
    }

    public static int borderSolution(int[] A) {
        // write your code in Java SE 8
        int bordersNum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (bordersNum > 10000000) return -1;
            for (int j = i + 1; j < A.length; j++) {
                int min1 = i - A[i];
                int max1 = i + A[i];
                int max2 = j + A[j];
                int min2 = j - A[j];
                if (!(min2 > max1)) {
                    if (min1 >= min2 || max1 <= max2) {
                        bordersNum++;
                        continue;
                    }
                }
                if (!(min2 > max1)) {
                    if (min2 >= min1 || max2 <= max1) {
                        bordersNum++;
                        continue;
                    }
                }
            }
        }

        return bordersNum;
    }


    public static int bestSolution(int[] A) {
        // write your code in Java SE 8
        int counter = 0, j = 0;
        long[] upper = new long[A.length];
        long[] lower = new long[A.length];

        for (int i = 0; i < A.length; i++) {
            lower[i] = (long) i - A[i];
            upper[i] = (long) i + A[i];
        }

        Arrays.sort(lower);
        Arrays.sort(upper);

        for (int i = 0; i < A.length; i++) {
            while (j < A.length && upper[i] >= lower[j]) {
                counter += j - i;
                j++;
            }
            if (counter > 10000000) return -1;
        }

        return counter;
    }

    public static int Bricksolution(int[] H) {
        // write your code in Java SE 8
        int i = 0;
        int index = 0;
        ArrayList indexes = new ArrayList();
        do {
            if (H[i] <= H[i + 1]) {
                i++;
            } else {
                indexes.add(i);
                i++;
            }
        } while (i < H.length);
        return 0;
    }


    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int[] B = {1, 5, 2, 1, 4, 0};
        int[] C = {1, 10, 100, 1};
        int[] D = {1, 2147483647, 0};
        int k = 4;
        int[] result = solution(A, k);
        /*for(int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }*/
        //System.out.println(" \nNumber of Borders : " + borderSolution(B));
        /*System.out.println("Number of Borders : " + borderSolution(B));
        System.out.println("Best : " + bestSolution(B));*/

        int[] Bricks = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        System.out.println("Number of Bricks : " + Bricksolution(Bricks));
    }
}
