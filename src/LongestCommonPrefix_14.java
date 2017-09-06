import java.util.Scanner;

/**
 * Created by monkd on 2017/9/5.
 */
public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        //不存在或者为空
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1); // 好处：后面若有不符合的，前面不必重新判断，肯定包含
                // if (pre.isEmpty()) return "";
            }
        }
        return pre;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        String[] strs = str.split(" ");

        LongestCommonPrefix_14 lcp = new LongestCommonPrefix_14();
        System.out.println("args = [" + lcp.longestCommonPrefix(strs) + "]");
    }
}
