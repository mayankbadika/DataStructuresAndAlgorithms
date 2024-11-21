//https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/?envType=daily-question&envId=2024-11-16
package myclass;

import java.util.Arrays;

public class ResultsArray2Pt {
    public static void main(String[] args) {
        ResultsArray2Pt obj = new ResultsArray2Pt();
        int[] arr = {1,2,3,4,3,2,5};
        int k = 3;
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

        while(j < nums.length) {
            if(j>0 && nums[j] == nums[j-1] + 1) {
                j++;
            } else {
                j++;
            }

            if(j-i+1 > k) {
                result[i] = nums[j-1];
                i++;
            }
        }

        return result;
    }
}
