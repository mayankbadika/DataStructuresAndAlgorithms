package myclass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SnakeToCamel {
    public static void main(String[] args) {
        String src = "This is the doc_string for __secret_fun";
        String result = ConvertToCamelCase(src);
        //System.out.println(result);
    }

    public static String ConvertToCamelCase(String src) {
        // Regular expression to find lowercase followed by uppercase letters
        String regex = "[a-z]_+[a-z]";
        /*Pattern pattern = Pattern.compile(regex);
        StringBuilder sb = new StringBuilder();

        String[] str = src.split(" ");

        for(String s: str){
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()) {
                int sub = s.indexOf('_');
                char charAfterUnderscore = s.charAt(sub+1);
                System.out.println(charAfterUnderscore);
                char capitalNextletter = Character.toUpperCase(charAfterUnderscore);

                System.out.println(s);
            }
            sb.append(s);
        }

        return sb.toString();

         */
        String replacement = "$2".toUpperCase();
        src = src.replaceAll(regex, replacement);

        return src;
    }
}

