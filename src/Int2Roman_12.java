import java.util.Scanner;

/**
 * Created by monkd on 2017/9/5.
 */
public class Int2Roman_12 {
    public String intToRoman(int num) {
        /** I-1 V-5 X-10 L-50 C-100 D-500 M-1000
         * 1-3、6-8右添1，4、9左加1
         * StringBuilder sb = new StringBuilder(); sb.append();sb.toString()
         */
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    public String intToRoman2(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        in.close();

        Int2Roman_12 i2r = new Int2Roman_12();
        System.out.println("args = [" + i2r.intToRoman(number) + "]");
    }
}
