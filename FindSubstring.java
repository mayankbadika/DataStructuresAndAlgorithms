package myclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubstring {
    public static void main(String args[]) {

        FindSubstring obj = new FindSubstring();
        String s = "ababababab";
        String[] words = {"ababa","babab"};

        System.out.println(obj.findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int minWord = words[0].length();
        int windowSize = minWord * words.length;
        List<Integer> result = new ArrayList<>();

        for(int i =0; i < words.length; i++) {
            map2.put(words[i], map2.getOrDefault(words[i], 0) + 1);
        }

        int i = 0; int j = minWord;

        while(j <= s.length()) {
            String st = s.substring(j-minWord,j);
            if(map2.containsKey(st)) {
                map1.put(st, map1.getOrDefault(st, 0) + 1);
            }


            if(j-i == windowSize) {
                if(checkConcat(map1, map2)) result.add(i);
                String oldWord = s.substring(i, i+minWord);
                if(map2.containsKey(oldWord)) {
                    int value = map1.get(oldWord);
                    value -= 1;

                    if(value == 0) {
                        map1.remove(oldWord);
                    } else {
                        map1.put(oldWord, value);
                    }
                }
                i += 1;
            }
            j += 1;
        }

        return result;
    }

    public boolean checkConcat(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        for(String key : map2.keySet()) {
            if(!map1.containsKey(key)) return false;
            if(map1.get(key) != map2.get(key)) return false;
        }

        return true;
    }
}
