//https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
package myclass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        MaximumSubarraySum obj = new MaximumSubarraySum();
        int[] arr = {5,3,3,1,1};
        int k = 3;
        long result = obj.maximumSubarraySum(arr, k);
        System.out.print(result);
    }

    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long sum = 0;

        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();

        while (j < nums.length) {
            // If nums[j] is already in the set, shrink the window from the left
            if (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
                continue;
            }

            // Add nums[j] to the set and include it in the sum
            set.add(nums[j]);
            sum += nums[j];

            // Check if the window size is equal to k
            if (j - i + 1 == k) {
                // Update maxSum if the current sum is greater
                maxSum = Math.max(sum, maxSum);

                // Slide the window by removing nums[i] and updating the sum
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            // Move the right pointer
            j++;
        }

        return maxSum;
    }
}
