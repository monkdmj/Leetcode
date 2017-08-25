import java.util.Scanner;

/**
 * Created by monkd on 2017/8/25.
 * 第一种方法53/94时超时，虽然“从长计议”，先确定子字符串长度，再依次判断，找到后就退出
 * 第二种方法94/94时超时
 */
public class longestPalindrome_5 {
    public String longestPalindrome(String s) {
        String r = "";
        int length = s.length();
        outer:
        for (int len = length; len > 0; len--) {
            for (int i = 0; i <= length - len; i++) {
                if (isPalindromeByCharAtSingle(s.substring(i, i + len))) {
                    r = s.substring(i, i + len);
                    break outer;
                }
            }
        }
        return r;
    }

    public String longestPalindrome2(String s) {
        String r = "";
        int maxLength = 0;
        int length = s.length();
        int left = 0, right = 0;

        boolean flag = false;
        for(int i = 0; i < length; i++){
            String tmp = "";
            //1,偶展开
            left = i;
            right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                flag = true;
            }
            if (flag) {
                tmp = s.substring(left + 1, right - 1 + 1); // + 1是因为不包括右边界
                if (tmp.length() > maxLength) {
                    r = tmp;
                    maxLength = tmp.length();
                    flag = false;
                }
            }

            //2,奇展开
            left = i - 1;
            right = i + 1;
            //限定大小的条件必须在前面
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                //flag = true;
            }
            tmp = s.substring(left + 1, right - 1 + 1);
            if (tmp.length() > maxLength) {
                r = tmp;
                maxLength = tmp.length();
                //flag = false;
            }
        }
        return r;
    }

    public String longestPalindrome3(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * 通过调用StringBuffer的对象的reverse()方法，来判断翻转前后字符串是否相等，确定是否为回文
     *
     * @param s
     * @return
     */
    public static boolean isPalindromeByBuffer(String s) {
        String strOrigin = filterLetterAndDigit(s);
        //将strOrigin作为输入参数，构造一个StringBuffer对象
        StringBuffer strBuf = new StringBuffer(strOrigin);
        //调用StringBuffer对象自带的reverse()方法进行字符串翻转，最后调用toString()返回一个String类型字符串
        String strAfterReverse = strBuf.reverse().toString();
        //通过equals()方法判断原来的字符串和翻转后的字符串是否相等，来确定是否为回文
        return strOrigin.equals(strAfterReverse);
    }

    /**
     * 通过字符串中的对称位置字符串是否相同来判断是否为回文,这里用了两个变量low和high来分别对应字符串对称位置的index
     *
     * @param s
     * @return
     */
    public static boolean isPalindromeByCharAt(String s) {
        //low和high分别对应字符串对称位置的index，以此来判断所有对称位置字符是否相同
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high))
                return false;  // 不是回文
            low++;
            high--;
        }
        return true;           // 是回文
    }

    /**
     * 通过字符串中的对称位置字符串是否相同来判断是否为回文,这里用了一个变量i来对应字符串对称位置的index
     *
     * @param s
     * @return
     */
    public static boolean isPalindromeByCharAtSingle(String s) {
        //通过对称下标的关系使用一个变量即可判断所有对称位置字符是否相同
        for (int i = 0; i < s.length() / 2; i++) {
            //只有当前一半字符串和后一半字符串对应位置相同，那么才是回文，只有有一个对称位置的字符不同就不是回文
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 通过调用Character.isLetterOrDigit(Char char)过滤字母或者数字，判断字母或者数字的组合是否为回文
     *
     * @param s
     * @return String
     */
    public static String filterLetterAndDigit(String s) {
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                //调用StringBuffer的append(Char char)方法,将输入的字母或者数字加入其中
                strBuf.append(s.charAt(i));
            }
        }
        //返回String类型，需要将StringBuffer转换为String，需要调用StringBuffer对象的toString()方法
        return strBuf.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        in.close();

        //test:
        //System.out.println(s1.substring(0,s1.length()));

        longestPalindrome_5 lp = new longestPalindrome_5();
        System.out.print(lp.longestPalindrome2(s1));
    }
}
