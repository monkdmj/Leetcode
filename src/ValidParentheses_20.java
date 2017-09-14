import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by monkd on 2017/9/8.
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }
        LinkedList<Character> cList = new LinkedList<>();
        cList.add(' ');
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length()-1 && isMatched(s.charAt(i), s.charAt(i + 1))) {
                i++;
            } else {
                if (isMatched(cList.peekLast(), s.charAt(i))) {
                    //while (i < s.length() && isMatched(cList.peekLast(), s.charAt(i))) {
                    //    cList.removeLast();
                    //    i++;
                    //}
                    cList.removeLast();
                }else{
                    cList.add(s.charAt(i));
                }
            }
        }
        return cList.peekLast() == ' ' ? true : false;
    }

    public boolean isMatched(char left, char right) {
        return (left == '(' && right == ')') || (left == '[' && right == ']') || (left == '{' && right == '}') ? true : false;
    }

    public boolean isValid2(String s) {
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        ValidParentheses_20 vp = new ValidParentheses_20();
        System.out.println("args = [" + vp.isValid(str) + "]");
    }
}
