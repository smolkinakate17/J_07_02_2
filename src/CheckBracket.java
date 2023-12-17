import java.util.*;

public class CheckBracket {
    private static int switchChar(Stack<Character> stack, char c, int i) {
        switch (c) {
            case ')' -> {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return i;
                }
            }
            case ']' -> {
                if (!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return i;
                }
            }
            default -> {
                if (!stack.empty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int checkBracket(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '(' && chars[i] != '[' && chars[i] != '{' && chars[i] != ')' && chars[i] != ']' && chars[i] != '}') {
                continue;
            }
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else {
                int flag = switchChar(stack, chars[i], i);
                if (flag != -1) {
                    return i;
                }
            }
        }
        if (!stack.empty()) {
            return chars.length;
        }
        return -1;
    }
}
