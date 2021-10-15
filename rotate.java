/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

/**
 *
 * @author mbadika
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 * 
 */
public class rotate {
    public static void main(String[] args){
        int[] nums={1,2,3,4,5,6,7};
        int k=3;
        /*for(int i=0;i<nums.length-1;i++){
            int temp = nums[i];
            nums[i]=nums[i+1];
            nums[i+1]=temp;
        }
        
        System.out.println("O/P"); // Move first element to last
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        */
        // Move last element to first
         
         for(int j=1;j<=k;j++){
             for(int i=nums.length-1;i>0;i--){
                int temp = nums[i];
                nums[i]=nums[i-1];
                nums[i-1]=temp;
            }
         }
         
         
         System.out.println("O/P"); // Move first element to last
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        
    }
}
