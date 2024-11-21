package myclass;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1,2,3};

        Subsets obj = new Subsets();

        System.out.println(obj.subsets(arr));
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int index, List<Integer> list) {
        if(index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        //Include the current element in the subset
        list.add(nums[index]);
        helper(nums,index+1,list);
        list.remove(list.size() -1);

        //Don't include the current element
        helper(nums,index+1,list);
    }
}
