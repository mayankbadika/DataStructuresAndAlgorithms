package myclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();

        System.out.println(obj.threeSum(new int[]{-1,0,1,2,-1,-4}).toString());
        System.out.println(obj.threeSum(new int[]{0,0,0,0}).toString());
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        result.clear();

        for(int i = 0; i<nums.length;i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            twoSum(-nums[i], i+1, nums.length-1, nums);
        }

        return result;
    }

    public void twoSum(int target, int i, int j, int[] nums) {
        while(i < j) {
            int currSum = nums[i] + nums[j];
            if(currSum == target) {
                result.add(new ArrayList<>(Arrays.asList(-target, nums[i], nums[j])));
                i++;
                j--;
            }else if(currSum > target) {
                j--;
                continue;
            } else if(currSum < target) {
                i++;
                continue;
            }

            while(i < j && nums[i] == nums[i-1]) i++;
        }
    }
}
