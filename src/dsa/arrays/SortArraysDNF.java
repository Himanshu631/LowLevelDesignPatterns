package dsa.arrays;

public class SortArraysDNF {

    public static  void sortArray(int[] arr) {
        int left = 0;
        int right = arr.length -1;
        int mid = 0;

        while (mid<=right) {
            if (arr[mid] == 0) {
                swap(arr, mid, left);
                left++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, right);
                right--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,1,1,2,0,0,2,0,0,0,0,1};
        sortArray(arr);
    }
}
