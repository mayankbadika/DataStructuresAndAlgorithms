package myclass;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        int n = 4; int k =2;

        Combinations obj = new Combinations();
        System.out.println(obj.combine(n, k));
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1, new ArrayList<>());
        return result;
    }

    public void helper(int n, int k, int index, List<Integer> list) {
        if(list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index;i<=n;i++) {
            list.add(i);
            helper(n, k, i+1, list);
            list.remove(list.size() -1);
        }
    }


}
