package myclass;

import java.util.Arrays;

public class FindLengthOfShortestSubarray {

    public static void main (String[] args) {
        int[] arr = {1,2,3,10,4,2,3,5};
        int[] arr2 = {2,2,2,1,1,1};

        FindLengthOfShortestSubarray obj = new FindLengthOfShortestSubarray();
        System.out.print(obj.findLengthOfShortestSubarray(arr2));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        // Step 1: Find the longest non-decreasing prefix
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If the entire array is already sorted
        if (left == n - 1) return 0;

        int right = n-1;
        while (right > 0 && arr[right -1] <= arr[right]) {
            right --;
        }
        // Calculate the initial minimum length of the subarray to remove:
        // 1. `n - left - 1` represents the length of the subarray to remove if we only consider
        //    removing elements after the longest non-decreasing prefix (`arr[0]` to `arr[left]` is sorted).
        // 2. `right` represents the length of the subarray to remove if we only consider removing
        //    elements before the longest non-decreasing suffix (`arr[right]` to `arr[n - 1]` is sorted).
        // We take the minimum of these two values as the initial guess for the result, because we want
        // the shortest subarray removal that leaves the remaining part of the array sorted.

        int result = Math.min(n - left - 1, right);

        int i = 0; int j = right;
        while(i<=left && j <n) {
            if(arr[i] <= arr[j]) {
                result = Math.min(result, j - i -1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}
