package myclass;

import java.util.ArrayList;
import java.util.List;

/*
    Write a function to flatten an array, the function takes an array and depth as arguments.
    Input: arr=[ 1, 2, [ 3, 4, 5, [ 6, 7 ] ], 8, 9 ] depth = 1
    Output: arr=[ 1, 2, 3, 4, 5, [ 6, 7 ], 8, 9 ]
 */

public class FlatArray {
    public static void main(String[] args) {
        List<Object> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(List.of(3, 4, 5, List.of(6, 7)));
        arr.add(8);
        arr.add(9);

        int depth = 1;

        FlatArray flat = new FlatArray();
        List<Object> result= flat.flattenArray(arr, depth);
        System.out.println(result);
    }

    public List<Object> flattenArray(List<Object> arr, int depth) {
        if(depth < 1) return arr;

        List<Object> result = new ArrayList<>();
        for(Object a : arr) {
            if(a instanceof List) {
                result.addAll(flattenArray((List<Object>) a, depth -1));
            } else {
                result.add(a);
            }
        }

        return result;
    }
}
