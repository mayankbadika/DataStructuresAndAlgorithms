package myclass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VowelStrings {
    public static void main(String[] args) {
        String[] words = {"bzmxvzjxfddcuznspdcbwiojiqf","mwguoaskvramwgiweogzulcinycosovozppl","uigevazgbrddbcsvrvnngfrvkhmqszjicpieahs","uivcdsboxnraqpokjzaayedf","yalc","bbhlbmpskgxmxosft","vigplemkoni","krdrlctodtmprpxwditvcps","gqjwokkskrb","bslxxpabivbvzkozzvdaykaatzrpe","qwhzcwkchluwdnqjwhabroyyxbtsrsxqjnfpadi","siqbezhkohmgbenbkikcxmvz","ddmaireeouzcvffkcohxus","kjzguljbwsxlrd","gqzuqcljvcpmoqlnrxvzqwoyas","vadguvpsubcwbfbaviedr","nxnorutztxfnpvmukpwuraen","imgvujjeygsiymdxp","rdzkpk","cuap","qcojjumwp","pyqzshwykhtyzdwzakjejqyxbganow","cvxuskhcloxykcu","ul","axzscbjajazvbxffrydajapweci"};
        int[][] queries = {{4, 4},{6, 17},{10, 17},{9, 18},{17, 22},{5, 23},{2, 5},{17, 21},{5, 17},{4, 8},{7, 17},{16, 19},{7, 12},{9, 20},{13, 23},{1, 5},{19, 19}};
        VowelStrings obj = new VowelStrings();
        Arrays.stream(obj.vowelStrings(words, queries)).forEach(System.out::print);
    }

    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public int[] vowelStrings(String[] words, int[][] queries) {
        // Precompute the valid words (words that start and end with a vowel)
        int[] prefixSum = new int[words.length];

        if(isVowel(words[0].charAt(0)) && isVowel(words[0].charAt(words[0].length() - 1))) {
            prefixSum[0] = 1;
        }

        for (int i = 1; i < words.length; i++) {
            String word = words[i];

            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                prefixSum[i] = prefixSum[i-1] + 1;
            } else {
                prefixSum[i] = prefixSum[i-1];
            }
        }

        // Step 3: Answer the queries using the prefix sum array
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (start == 0) {
                result[i] = prefixSum[end];
            } else {
                result[i] = prefixSum[end] - prefixSum[start - 1];
            }
        }

        return result;
    }

    // Helper function to check if a character is a vowel
    public boolean isVowel(char ch) {
        return vowels.contains(ch);
    }
}
