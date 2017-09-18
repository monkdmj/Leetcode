import java.util.Scanner;

/**
 * Created by monkd on 2017/9/15.
 */
public class DivideTwoIntegers_29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        //if (dividend == Integer.MIN_VALUE) {
        //    if (divisor == -1) {//overflow
        //        return Integer.MAX_VALUE;
        //    } else {
        //        dividend = Integer.MIN_VALUE + 1;
        //    }
        //}
        boolean flag = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = false;
        }
        //-2147483648的绝对值还是-2147483648，所以单独考虑,abs只能返回int,必须是-(long)dividend
        //long dividendL = Math.abs((long)dividend); //也可以
        long dividendL = dividend > 0 ? dividend : -(long)dividend;
        long divisorL = divisor > 0 ? divisor : -(long)divisor;
        int result = 0;
        long c = 1, sub = divisorL;
        while (dividendL >= sub) {
            sub = (sub << 1);
            c = (c << 1);
        }
        while (dividendL >= divisorL) {
            if (dividendL >= sub) {
                dividendL -= sub;
                result += c;
                if (result < 0) {
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                sub = (sub >> 1);
                c = (c >> 1);
            }
        }
        return flag ? result : -result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target1 = in.nextInt();
        int target2 = in.nextInt();
        in.close();

        // test
        //long test = 2147483648L;
        //System.out.println((int)test);

        DivideTwoIntegers_29 dti = new DivideTwoIntegers_29();
        System.out.println("args = [" + dti.divide(target1, target2) + "]");
    }
}
