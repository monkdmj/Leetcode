import java.util.Scanner;

/**
 * Created by monkd on 2017/8/28.
 *
 */
public class ReverseInt_7 {
    public int reverse(int x) {
        String str = "" + x;
        //String a="abcde";
        //StringBuilder b = new StringBuilder(a);
        //System.out.print(b.reverse().toString());

        char[] charStr = str.toCharArray();
        String reverseStr = "";
        if (charStr[0] >= '0' && charStr[0] <= '9') {
            for (int i = charStr.length - 1; i >= 0; i--) {
                reverseStr += charStr[i];
            }
        } else {
            reverseStr += charStr[0];
            for (int i = charStr.length - 1; i >= 1; i--) {
                reverseStr += charStr[i];
            }
        }
        long reverseInt = Long.parseLong(reverseStr);
        if (reverseInt > Integer.MAX_VALUE || reverseInt < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) reverseInt;
        }

    }

    public int reverse2(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        int num = Integer.parseInt(str);

        ReverseInt_7 ri = new ReverseInt_7();
        System.out.print(ri.reverse(num));
    }

}
