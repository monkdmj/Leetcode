import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by monkd on 2017/9/21.
 */
public class CountSay_38 {
    public String countAndSay(int n) {
        String str = "1";
        while (n > 1) {
            str = genStr(str);
            n--;
        }
        return str;
    }

    /**
     * //第一种：
     String [] arr = {"41","a","5","g56"};
     String s1 = Arrays.toString(arr);
     System.err.println(s1);//[41, a, 5, g56]
     //第二种：
     String s2 = StringUtils.join(arr);
     System.err.println(s2);//41a5g56
     //第三种：
     String s3 = StringUtils.join(arr,",");
     System.err.println(s3);//41,a,5,g56
     //第四种：
     StringBuffer s4 = new StringBuffer();
     for (String string : arr) {
     s4.append(string);
     }
     System.err.println(s4.toString());//41a5g56
     * @param string
     * @return
     */
    public String genStr(String string) {
        List<String> strList = new ArrayList<>();//count不一定是单字符，比如11个1
        int count = 1;
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1)) {
                count++;
            } else {
                strList.add(String.valueOf(count));
                strList.add(String.valueOf(string.charAt(i)));
                count = 1;
            }
        }
        strList.add(String.valueOf(count));
        strList.add(String.valueOf(string.charAt(string.length() - 1)));

        String[] res = (String[]) strList.toArray(new String[strList.size()]);
        //return res.toString(); //输出字符串地址
        StringBuffer s4 = new StringBuffer();
        for (String s : res) {
            s4.append(s);
        }
        return s4.toString();
    }

    //思路一样，但又更加简洁
    public String countAndSay2(int n) {
        StringBuilder curr=new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i=1;i<n;i++){
            prev=curr;
            curr=new StringBuilder();
            count=1;
            say=prev.charAt(0);

            for (int j=1,len=prev.length();j<len;j++){
                if (prev.charAt(j)!=say){
                    curr.append(count).append(say);
                    count=1;
                    say=prev.charAt(j);
                }
                else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        in.close();

        CountSay_38 cs = new CountSay_38();
        System.out.println("args = [" + cs.countAndSay(target) + "]");
    }
}
