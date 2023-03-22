package myclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public  class canSum {
    public static void main(String[] args){
        canSum obj = new canSum();

        System.out.println(obj.canSum(7,new int[] {5,3,4,7}, new HashMap<>()));
        System.out.println(obj.canSum(7,new int[] {2,3}, new HashMap<>()));
        System.out.println(obj.canSum(7,new int[] {2,4}, new HashMap<>()));
        System.out.println(obj.canSum(300,new int[] {7,14}, new HashMap<>()));
        System.out.println(obj.howSum(7,new int[] {2,3}, new HashMap<>()));
        System.out.println(obj.howSum(7,new int[] {5,3,4,7}, new HashMap<>()));
        System.out.println(obj.howSum(300,new int[] {7,14}, new HashMap<>()));
        System.out.println(obj.bestSum(7,new int[] {5,3,4,7}));
    }

    public boolean canSum(int target, int[] arr, HashMap<Integer,Boolean> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return true;
        if(target < 0) return false;

        for(int i = 0; i < arr.length; i++){
            int remainder = target - arr[i];
            if(canSum(remainder,arr, memo)){
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

    public List<Integer> howSum(int target, int[] arr, HashMap<Integer,List<Integer>> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        for(int i=0;i<arr.length;i++){
            int remainder = target - arr[i];
            List<Integer> resultarr = howSum(remainder,arr,memo);
            if (resultarr != null){
                resultarr.add(arr[i]);
                memo.put(target,resultarr);
                return resultarr;
            }
        }
        memo.put(target,null);
        return null;
    }

    public List<Integer> bestSum(int target, int[] arr){
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        List<Integer> shortestCombination = null;
        for(int i=0;i<arr.length;i++){
            int remainder = target - arr[i];
            List<Integer> resultarr = bestSum(remainder,arr);
            if (resultarr != null){
                resultarr.add(arr[i]);
                if (shortestCombination == null || resultarr.size() < shortestCombination.size()){
                    shortestCombination = resultarr;
                }
            }
        }
        return shortestCombination;
    }

}