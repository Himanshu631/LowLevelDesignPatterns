package dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {

    public static int[] unionOfSortedArrays(int[] arr1, int[] arr2) {

        int left = 0;
        int right = 0;

        List<Integer> res = new ArrayList<>();

        int len1 = arr1.length;
        int len2 = arr2.length;

        while (left < len1 && right < len2) {
            if (arr1[left] > arr2[right]) {
                addIfNotDuplicate(res, arr2[right]);
                right++;
            } else if (arr1[left] == arr2[right]) {
                addIfNotDuplicate(res, arr2[right]);
                left++;
                right++;
            }
            else {
                addIfNotDuplicate(res, arr1[left]);
                left++;
            }
        }

        if (left < len1) {
            while (left < len1) {
                addIfNotDuplicate(res, arr1[left]);
                left++;
            }
        }

        if (right < len2) {
            while (right < len2) {
                addIfNotDuplicate(res, arr2[right]);
                right++;
            }
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }

        return null;
    }

    private static void addIfNotDuplicate(List<Integer> res, int val) {
        if (res.isEmpty() || res.get(res.size() - 1) != val) {
            res.add(val);
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,3,4,5,6,7,8};

        unionOfSortedArrays(arr1, arr2);

    }
}
