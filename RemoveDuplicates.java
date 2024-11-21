package myclass;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,1};

        RemoveDuplicates obj = new RemoveDuplicates();
        obj.removeDuplicates(nums);
        System.out.println("final array");
        obj.printArr(nums);
    }
    public int removeDuplicates(int[] nums) {
        int dup = 1;
        int prev = nums[0];
        int k = nums.length-1;
        int i = 1;

        while(i <= k) {
            if(prev == nums[i]) {
                dup++;
            } else {
                dup =1;
            }

            if(dup == 3) {
                //Swap elements
                int n = i;
                while(n+1< nums.length-1) {
                    int temp = nums[n];
                    nums[n] = nums[n+1];
                    nums[n+1] = temp;
                    n++;
                }
                int temp = nums[n];
                nums[n] = nums[k];
                nums[k] = temp;

                k--;
                dup--;
                printArr(nums);
                continue;
            }

            prev = nums[i];
            i++;
        }

        return k+1;
    }

    public void printArr(int[] nums) {
        for(int i =0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
