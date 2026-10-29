package dsa.arrays;

public class SubArrayWithSumK {

    public static int getSubArrayWithSumK(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;

        int sum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];  // expand window

            while (sum > k) {   // shrink window
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,1,7,99};
        int k = 99;

        System.out.println(getSubArrayWithSumK(arr,k));

    }
}
