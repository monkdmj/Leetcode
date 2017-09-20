import java.util.Scanner;
import java.util.Stack;

/**
 * Created by monkd on 2017/9/19.
 */
public class LongestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0 || s == null) {
            return 0;
        }
        for (int i = len; i > 0; i--) {
            for (int j = 0; j <= len - i; j++) {
                if (isValid(s.substring(j, j + i))) {
                    return i;
                }
            }
        }
        return 0;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    //)()()()(()()()()(  无法识别为8，只能识别为14
    public int longestValidParentheses2(String s) {
        int len = s.length();
        if (len == 0 || s == null) {
            return 0;
        }
        int maxLen = 0, tmpLen = 0;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty()) {
                    //刚开始就进入此或者完全配对
                    maxLen = tmpLen > maxLen ? tmpLen : maxLen;
                    stack.clear();
                    tmpLen = 0;
                } else {
                    if (stack.peek() == c) {
                        stack.pop();
                        tmpLen += 2;
                    } else {
                        maxLen = tmpLen > maxLen ? tmpLen : maxLen;
                        stack.clear();
                        tmpLen = 0;
                    }
                }
            }
            //if
        }
        return tmpLen > maxLen ? tmpLen : maxLen;
    }

    public int longestValidParentheses3(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public int longestValidParentheses4(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses5(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        in.close();

        LongestValidParentheses_32 lvp = new LongestValidParentheses_32();
        System.out.println("args = [" + lvp.longestValidParentheses2(str1) + "]");
    }
}
