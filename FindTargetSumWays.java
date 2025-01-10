package myclass;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSumWays {
    Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;

        FindTargetSumWays obj = new FindTargetSumWays();

        System.out.println(obj.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    public int helper(int[] nums, int target, int start, int sum) {
        if(sum == target && start == nums.length) return 1;
        // Create a unique key for the current state
        String key = start + "," + sum;

        // Check if the result for the current state is already computed
        if (map.containsKey(key)) return map.get(key);

        if(start == nums.length) return 0;
        map.put(key ,helper(nums, target, start+1, sum+nums[start]) + helper(nums, target, start+1, sum-nums[start]));

        return map.get(key);
    }
}
