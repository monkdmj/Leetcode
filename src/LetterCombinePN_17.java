import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by monkd on 2017/9/7.
 */
public class LetterCombinePN_17 {
    public List<String> letterCombinations(String digits) {
        //digits.toLowerCase();
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] ref = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> invertRef = new ArrayList<>();
        int multi = 1;
        for (int i = 0; i < digits.length(); i++) {
            invertRef.add(ref[digits.charAt(i) - '0']);
            multi = multi * ref[digits.charAt(i) - '0'].length();
        }
        List<String> letterCom = new ArrayList<>();
        for (int i = 0; i < multi; i++) {
            char[] ch = new char[digits.length()];
            int tmp = 1;
            for (int j = invertRef.size() - 1; j >= 0; j--) {
                ch[j] = invertRef.get(j).charAt((i / tmp) % invertRef.get(j).length());
                tmp = tmp * invertRef.get(j).length();
            }
            letterCom.add(String.valueOf(ch));//此处切不可是ch.toString(),其返回字符串地址
        }
        return letterCom;
    }

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations2(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);  //
            //当第一次函数返回的时候，还处在最内层循环内，当内层循环结束，调用该循环的函数也会返回
        }
    }

    /** digits.length()=3
     * String letters = KEYS[(digits.charAt(0) - '0')];
     * for (int i = 0; i < letters.length(); i++) {
     *     String letters = KEYS[(digits.charAt(1) - '0')];
     *     for (int i = 0; i < letters.length(); i++) {
     *         String letters = KEYS[(digits.charAt(2) - '0')];
     *         for (int i = 0; i < letters.length(); i++) {
     *             if (3 >= digits.length()) {
     *                 ret.add(prefix);
     *                 return;
     }
     * @解释上述递归过程
     */


    public List<String> letterCombinations3(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        //ans.pop();  removes and returns the first element of this list, removeFirst
        //ans.push("w"); inserts the element at the front of this list, addFirst
        //ans.element();  Retrieves, but does not remove, the head (first element) of this list
        //ans.offer("w"); Adds the specified element as the tail (last element) of this list
        //ans.poll();   Retrieves and removes the head (first element) of this list.
        //ans.remove(); Retrieves and removes the head (first element) of this list.
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            //peek() 返回head first但不remove
            while (ans.peek().length() == i) /*此条件保证当前循环add的项是下次循环remove的项，并不是当前的*/{
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        LetterCombinePN_17 lcpn = new LetterCombinePN_17();
        System.out.println("args = [" + lcpn.letterCombinations(str) + "]");
    }
}
