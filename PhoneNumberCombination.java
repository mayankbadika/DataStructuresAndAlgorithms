package myclass;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombination {
    static List<String> result = new ArrayList<>();
    static String[][] combinations = {{""},{""},{"a","b","c"}, {"d","e","f"},{"g","h","i"}, {"j","k","l"},{"m","n","o"}, {"p","q","r","s"}, {"t","u","v"},{"w","x","y","z"}};

    public static void main(String[] args) {
        String s = "34";

        System.out.println(findPossibleWords(s).toString());
    }

    public static List<String> findPossibleWords(String s) {
        helper(s, 0, "");
        return result;
    }

    public static void helper(String s, int index, String combination) {
        if(index == s.length()) {
            result.add(combination);
            return;
        }

        int n = s.charAt(index) - '0';

        for(int i =0; i< combinations[n].length;i++) {
            String curr = combinations[n][i];
            helper(s, index+1, combination+curr);
        }
    }
}
