import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by monkd on 2017/9/14.
 */
public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    public List<String> generateParenthesis2(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));//Lists[0]为""即f(0)

        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();
            //List[i]代表f(i)的情况
            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        //(f(j))f(i-1-j), f(i)由f(i-1)的各项及()添加的位置确定
                        list.add("(" + first + ")" + second);
                    }
                }
            }

            lists.add(list);
        }

        return lists.get(lists.size() - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        in.close();

        GenerateParentheses_22 gp = new GenerateParentheses_22();
        System.out.println("args = [" + gp.generateParenthesis(target) + "]");
    }
}
