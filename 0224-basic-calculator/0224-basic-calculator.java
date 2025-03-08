import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
        }

        if (number != 0) {
            result += sign * number;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution calculator = new Solution();
        System.out.println(calculator.calculate("1 + 1")); // Output: 2
        System.out.println(calculator.calculate(" 2-1 + 2 ")); // Output: 3
        System.out.println(calculator.calculate("(1+(4+5+2)-3)+(6+8)")); // Output: 23
    }
}
