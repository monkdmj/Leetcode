import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by monkd on 2017/9/5.
 */
public class Roman2Int_13 {
    // 存在问题，CM M的比较问题
    public int romanToInt(String s) {
        if (s == "") {
            return 0;
        }
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "D", "CD", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "L", "XL", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "V", "IV", "VI", "VII", "VIII", "IX"};
        //HashMap<String, Integer> M_map = new HashMap<>();
        //HashMap<String, Integer> C_map = new HashMap<>();
        //HashMap<String, Integer> X_map = new HashMap<>();
        //HashMap<String, Integer> I_map = new HashMap<>();
        //String[] result = new String[4];
        int[] result = new int[4];
        //boolean[] finded = {false, false, false};
        for (int i = M.length - 1; i >= 0; i--) {
            //M_map.put(M[i], i);
            if (s.indexOf(M[i]) != -1) {
                i = (i == 4 || i == 5) ? (i == 4 ? 5 : 4) : i;
                result[0] = i;
                break;
            }
        }
        for (int i = C.length - 1; i >= 0; i--) {
            //M_map.put(M[i], i);
            if (s.indexOf(C[i]) != -1) {
                i = (i == 4 || i == 5) ? (i == 4 ? 5 : 4) : i;
                result[1] = i;
                break;
            }
        }
        for (int i = X.length - 1; i >= 0; i--) {
            //M_map.put(M[i], i);
            if (s.indexOf(X[i]) != -1) {
                i = (i == 4 || i == 5) ? (i == 4 ? 5 : 4) : i;
                result[2] = i;
                break;
            }
        }
        for (int i = I.length - 1; i >= 0; i--) {
            //M_map.put(M[i], i);
            if (s.indexOf(I[i]) != -1) {
                i = (i == 4 || i == 5) ? (i == 4 ? 5 : 4) : i;
                result[3] = i;
                break;
            }
        }
        return result[0] * 1000 + result[1] * 100 + result[2] * 10 + result[3];

        //boolean[] finded = {false, false, false};
        //int tmp = 0;
        //for (int i = 0; i < s.length(); i++) {
        //    if ((s.charAt(i) == 'C' || s.charAt(i) == 'D') && !finded[0]) {
        //        result[0] = s.substring(0, i);
        //        finded[0] = true;
        //        tmp = i;
        //    }
        //    if ((s.charAt(i) == 'X' || s.charAt(i) == 'L') && !finded[1]) {
        //        result[1] = s.substring(tmp, i);
        //        finded[1] = true;
        //        tmp = i;
        //    }
        //    if ((s.charAt(i) == 'I' || s.charAt(i) == 'V') && !finded[2]) {
        //        result[2] = s.substring(tmp, i);
        //        finded[2] = true;
        //        result[3] = s.substring(i, s.length());
        //        break;
        //    }
        //}
        //return M_map.get(result[0]) * 1000 + C_map.get(result[1]) * 100 + X_map.get(result[2]) * 10 + I_map.get(result[3]);
    }

    public int romanToInt2(String s) {
        int sum=0;
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        char c[]=s.toCharArray();
        int count=0;

        for(;count<=s.length()-1;count++){
            if(c[count]=='M') sum+=1000;
            if(c[count]=='D') sum+=500;
            if(c[count]=='C') sum+=100;
            if(c[count]=='L') sum+=50;
            if(c[count]=='X') sum+=10;
            if(c[count]=='V') sum+=5;
            if(c[count]=='I') sum+=1;

        }

        return sum;

    }

    // 最为直接明白的方法
    public int romanToInt3(String s) {
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        Roman2Int_13 r2i = new Roman2Int_13();
        System.out.println("args = [" + r2i.romanToInt(str) + "]");
    }
}
