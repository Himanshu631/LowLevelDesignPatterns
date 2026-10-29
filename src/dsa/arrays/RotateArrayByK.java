package dsa.arrays;

import java.util.Arrays;

public class RotateArrayByK {

    public static void rotateArray(int[] arr, int k) {

        int[] arrRev = reverse(arr, 0, arr.length-1);

        reverse(arrRev, 0, k-1);
        reverse(arrRev, k, arr.length-1);

        for (int i = 0; i < arrRev.length; i++) {
            System.out.print(arrRev[i] + " ");
        }
        return;
    }

    public static int[] reverse(int[] arr, int left, int right) {
        while (left<=right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int k = 7;

        rotateArray(arr, k);
    }
}
