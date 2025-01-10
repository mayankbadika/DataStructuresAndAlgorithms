package myclass;
import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        String s = "1-1+1";
        BasicCalculatorII obj = new BasicCalculatorII();

        System.out.println(obj.calculate(s));
    }

    public int calculate(String s) {
        char[] ch = s.trim().toCharArray();
        int start = 0;
        int end = ch.length;
        Stack<Long> numbers = new Stack<>();
        Character prevOp = null;

        while (start < end) {
            char c = ch[start];
            if (c == '+' || c == '-') {
                prevOp = c;
            } else if (c == '*' || c == '/') {
                prevOp = c;
            } else if (c == ' ') {
                // Skip spaces
            } else {
                // Extract the full number (for multi-digit numbers)
                StringBuilder sb = new StringBuilder();
                while (start < end && Character.isDigit(ch[start])) {
                    sb.append(ch[start]);
                    start++;
                }
                long num = Long.parseLong(sb.toString());
                start--; // Adjust for the main loop increment

                if (prevOp != null) {

                    if(prevOp == '+') {
                        numbers.push(num);
                    }else if(prevOp == '-') {
                        numbers.push(-num);
                    }
                    else if (prevOp == '*') {
                        long num2 = num;
                        long num1 = numbers.pop();
                        numbers.push(num1 * num2);
                    } else {
                        long num2 = num;
                        long num1 = numbers.pop();
                        numbers.push(num1 / num2);
                    }
                    prevOp = null;
                } else {
                    numbers.push(num);
                }
            }
            start++;
        }

        // Sum up the results in the numbers stack
        long result = 0;
        while (!numbers.isEmpty()) {
            result += numbers.pop();
        }

        return (int) result; // Cast back to int
    }
}
