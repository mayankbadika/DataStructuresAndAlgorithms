//https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/?envType=daily-question&envId=2024-11-16
package myclass;

import java.util.Arrays;

public class ResultsArray {
    public static void main(String[] args) {
        ResultsArray obj = new ResultsArray();
        int[] arr = {1,4};
        int k = 1;
        int [] result = obj.resultsArray(arr, k);
        for(int i =0;i<result.length;i++) {
            System.out.print(result[i]+ " ");
        }
    }

    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;

        int[] result = new int[n - k + 1];
        Arrays.fill(result, -1);

        int i =0; int j = 0;

        while(i < nums.length) {
            if(k == 1) {
                result[i] = nums[i];
                i++;
                continue;
            }

            j = i+1;

            while(j < nums.length) {
                if (nums[j] != nums[j - 1] + 1) break;

                if (j - i + 1 == k) {
                    result[i] = nums[j];
                    break;
                }
                j++;
            }
            i++;
        }

        return result;
    }
}
