import java.util.*;

/**
 * Created by monkd on 2017/8/14.
 * 第一、二个方法[Time Limit Exceeded]
 */
public class LongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        boolean flag = false;
        if(s.length() == 1)
            return 1;
        // 类似au,c,abc之类的输出为0
        // aab，由于j+
        // 从字符串开始，寻找直到出现重复的字符，出现重复，则跳出内层循环
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                //regionMatches:两个字符串从各自索引开始是否相同
                //matches:正则匹配，某字符串是否符合规则
                //charAt;返回指定位置的字符
                //substring(i,j):不包括j
                int index = s.substring(i, j).indexOf(s.charAt(j));
                // index 从0开始返回；
                if (index >= 0) {
                    flag = true;
                    if (j - i > maxLength) {
                        maxLength = j - i;
                    }
                    i += index;   //
                    break;
                }
                if (j == s.length() - 1){
                    if(!flag){
                        if (j - i + 1 > maxLength) {
                            maxLength = j - i + 1;
                        }
                    }
                }
            }
            flag = false;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s){
        int maxLength = 0;
        if(s.length() == 0)
            return 0;
        // 类似au,c,abc之类的输出为0
        // aab，由于j+
        // 从字符串开始，寻找直到出现重复的字符，出现重复，则跳出内层循环
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                //regionMatches:两个字符串从各自索引开始是否相同
                //matches:正则匹配，某字符串是否符合规则
                //charAt;返回指定位置的字符
                //substring(i,j):不包括j
                int index = s.substring(i, j).indexOf(s.charAt(j));
                // index 从0开始返回；
                if (index < 0) {
                    maxLength = Math.max(maxLength, j - i);
                }
                else{
                    i += index;
                    break;
                }

            }
        }
        return maxLength + 1;
    }

    public int lengthOfLongestSubstring3(String s){
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring4(String s){
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int j = 0, i = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1); // 保存的最大值是判断重复前一次的值，因此需要加1
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        //System.out.print(str.substring(0,2));  //test 不包括j
        LongestSubstring_3 ls = new LongestSubstring_3();
        System.out.print(ls.lengthOfLongestSubstring(str));
    }
}
