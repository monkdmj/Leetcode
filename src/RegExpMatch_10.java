import java.util.Scanner;

/**
 * Created by monkd on 2017/8/29.
 */
public class RegExpMatch_10 {
    public boolean isMatch(String s, String p) {
        return helper(s,p,0,0);
    }
    private boolean helper(String s, String p, int i, int j)
    {
        if(j==p.length())
            return i==s.length();

        if(j==p.length()-1 || p.charAt(j+1)!='*')  //注意此处细节：防止p.charAt(j+1)访问不存在
        {
            if(i==s.length()|| s.charAt(i)!=p.charAt(j) && p.charAt(j)!='.')//一般情况指的是，p不是.的时候还不等，肯定false;p为.,s为不为.，都满足
                return false;  //特殊情况，p后面一个不为*，但s已经遍历结束，gg
            else
                return helper(s,p,i+1,j+1);
        }
        //p.charAt(j+1)=='*'
        while(i<s.length() && (p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)))
        {
            if(helper(s,p,i,j+2))// 此处的作用是？"aaa"  "a*a"   ----非贪婪模式：保证p中最后的a能被匹配
                return true;
            i++;
        }
        return helper(s,p,i,j+2);  // aaab  a*b
    }

    //不完整，第四部分没敢写
    public boolean isMatch3(String s, String p) {
        if (!p.contains(".") && !p.contains("*")) {
            if (!s.equals(p)) {
                return false;
            } else {
                return true;
            }
        } else if (p.contains(".") && !p.contains("*")) {
            if (p.length() != s.length()) {
                return false;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (p.charAt(i) != '.') {
                        if (p.charAt(i) != s.charAt(i)) {
                            return false;
                        }
                    }
                }
                return true;
            }
        } else if (!p.contains(".") && p.contains("*")) {
            int j = 0;
            for (int i = 0; i < p.length() - 1; i++) {
                if (p.charAt(i + 1) == '*') {
                    if (p.charAt(i) != s.charAt(j) || j > s.length() - 1) {  // aaab aaabc*a*
                        i++; // 移过*号
                        //j不变
                    } else {
                        while (s.charAt(++j) == p.charAt(i)) {
                        }
                        i++;
                    }
                } else {
                    if (p.charAt(i) != s.charAt(j)) {
                        return false;
                    }
                    j++;
                }
            }
            if (j != s.length() - 1) {  //aaabbc a*bb
                return false;
            } else {
                return true;
            }
        } else {  //p.contains(".") && p.contains("*")
            return false;
        }
    }

    /**
     * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
     * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     * 3, If p.charAt(j) == '*': here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     */
    public boolean isMatch2(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();

        RegExpMatch_10 re = new RegExpMatch_10();
        System.out.println("args = [" + re.isMatch(s, p) + "]");
    }
}
