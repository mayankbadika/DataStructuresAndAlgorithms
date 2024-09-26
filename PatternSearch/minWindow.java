package PatternSearch;

import java.util.HashMap;

public class minWindow {


    public String patternSearch(String str, String pat){
        if(str==""||pat=="") return "";
        int i =0,j =0;
        String minstr="";
        int count =0; int minlength =Integer.MAX_VALUE;
        //int[] map_str = new int[128];
        int[] map_pat = new int[128];

        for(Character s :pat.toCharArray()){
            map_pat[s]++;
        }
        char currchar;

        for(j=0;j<str.length();j++){
            currchar = str.charAt(j);
            map_pat[currchar]--;
            if(map_pat[currchar]>=0){
                count++;
            }
            while(count==pat.length()){ // found window
                int currlength = j-(i-1);
                if(minlength>currlength){
                    minlength = currlength;
                    minstr = str.substring(i,j+1);
                }
                //try to reduce the current window
                if(++map_pat[str.charAt(i)]>0){
                    count--;
                }
                i++;

            }
        }

        return minstr;
    }


    public static void main(String[] args){
        String input = "this is a test string";
        String pat = "tist";
        minWindow obj = new minWindow();
        System.out.println(obj.patternSearch(input,pat));
    }

}
