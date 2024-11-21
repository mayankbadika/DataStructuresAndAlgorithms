package myclass;

public class SortedSquares {

    public static void main(String[] args) {
        int[] arr = {-5,-4,-3,-2,-1};

        arr = sortedSquares(arr);

        for(int i =0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];
        int j = result.length-1;

        while(start <= end) {

            if(Math.abs(nums[start]) > Math.abs(nums[end])) {
                result[j--] = nums[start] * nums[start];
                start++;
            } else {
                result[j--] = nums[end] * nums[end];
                end--;
            }
        }

        return result;
    }
}
