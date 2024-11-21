package myclass;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPatterns {

    public static void main(String[] args) {
        String input = "3[a2[c]]";

        List<String> list = extractPattern(input);

        System.out.println(list);
    }

    public static List<String> extractPattern(String input) {
        List<String> matching = new ArrayList<>();

        Pattern pattern = Pattern.compile("(\\d+)\\[([a-zA-Z]+)\\]");

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            matching.add(matcher.group(1)+","+matcher.group(2));
        }

        return matching;
    }
}
