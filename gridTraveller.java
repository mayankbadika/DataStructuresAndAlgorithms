package myclass;

import java.util.HashMap;

public class gridTraveller {

    public static void main (String[] args){
        gridTraveller obj = new gridTraveller();
        HashMap<String, Integer> memo = new HashMap<>();
        System.out.println(obj.gridTraveller(2,3, memo));

    }

    public int gridTraveller(int m, int n, HashMap<String, Integer> memo){
        String key = m+","+n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;

        memo.put(key,gridTraveller(m-1,n, memo) + gridTraveller(m, n-1, memo));

        return memo.get(key);
    }

}