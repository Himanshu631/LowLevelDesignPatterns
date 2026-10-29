package dsa.arrays;

import java.util.Arrays;

public class TwoSum {

    public static boolean checkTwoSumExists(int[] arr, int k) {

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;

        while (left < right){
            int sum = arr[left] + arr[right];
            if (sum == k) {
                return true;
            }
            else if (sum>k) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,4,2,5,7,8};
        int k = 13;

        System.out.println(checkTwoSumExists(arr, k));
    }
}
