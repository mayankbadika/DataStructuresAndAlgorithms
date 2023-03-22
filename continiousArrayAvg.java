//https://medium.com/gitconnected/grokking-the-coding-interview-pattern-sliding-window-20ef83ae5872
package myclass;

public class continiousArrayAvg {
    public static void main(String args[]){
    int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;
        continiousArrayAvg obj = new continiousArrayAvg();
        double[] result= obj.ArrayAvg(arr,K);
        for (int i=0;i<=result.length-1;i++){
            System.out.println(result[i]);
        }
    }

    public double[] ArrayAvg(int[] arr, int k){
        double[] avg = new double[k];
        int start = 0;
        int end = 0;
        double windowSum = 0.00;

        for(int i=0 ;i<=arr.length-1; i++){
            windowSum += arr[i];
            end++;
            if (end == k){
                if (start>0){
                    windowSum = windowSum - arr[start];
                }

                avg[start] = windowSum/k;
                start++;
                end --;
            }
        }

        /*for(int i= 0; i<k;i++){
            windowSum += arr[i];
        }
        avg[0] = windowSum/k;

        while(end<=arr.length-1){
            windowSum = windowSum - arr[start-1] + arr[end];
            avg[start] = windowSum/k;
            start++; end++;
        }
        */
        return avg;
    }
}