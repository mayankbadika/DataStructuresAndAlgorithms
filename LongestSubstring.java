package myclass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
    Example 1:
    Input: “ABCDEFGABEF”
    Output: 7
    Explanation: The longest substring without repeating characters are “ABCDEFG”, “BCDEFGA”, and “CDEFGAB” with lengths of 7

    Example 2:
    Input: “GEEKSFORGEEKS”
    Output: 7
    Explanation: The longest substrings without repeating characters are “EKSFORG” and “KSFORGE”, with lengths of 7
 */
public class LongestSubstring {

    public static  void main (String[] args) {
        LongestSubstring obj = new LongestSubstring();

        System.out.println("ABCDEFGABEF result is = "+ obj.longestSubstring("ABCDEFGABEF"));

        System.out.println("GEEKSFORGEEKS result is = "+ obj.longestSubstring("GEEKSFORGEEKS"));
    }


    public String longestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        String result ="";
        int i =0;

        for(int j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            while(set.contains(c)) {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(c);

            if(maxLength < (j - i)) {
                maxLength = (j - i);
                result = s.substring(i, j);
            }
        }

        return result;
    }
}
