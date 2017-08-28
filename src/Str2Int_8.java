import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by monkd on 2017/8/28.
 */
public class Str2Int_8 {
    public int myAtoi(String str) throws Exception{
        char[] charStr = str.toCharArray();
        long charInt = 0;
        boolean upLow = true; // 默认为整数
        for (int i = 0; i < charStr.length; i++) {
            if (i == 0) {
                if (charStr[i] >= '0' && charStr[i] <= '9') {
                    charInt = charInt * 10 + (charStr[i] - '0');
                } else if (charStr[i] == '+') {
                    upLow = true;
                } else if (charStr[i] == '-') {
                    upLow = false;
                } else {
                    throw new Exception("not suitable char");
                }
            } else {
                if (charStr[i] >= '0' && charStr[i] <= '9') {
                    charInt = charInt * 10 + (charStr[i] - '0');
                } else {
                    throw new Exception("not suitable char");
                }
            }
        }
        if (!upLow) {
            charInt = -charInt;
        }
        if (charInt > Integer.MAX_VALUE || charInt < Integer.MIN_VALUE) {
            throw new Exception("overflow");
        }
        return (int) charInt;
    }

    public int myAtoi2(String str){
        //if (str == "") ERROR
        if (str.equals(""))
        {
            return 0;
        }
        char[] charStr = str.trim().toCharArray();  //去掉字符串前后空格
        //long charInt = 0; // long会在存储的时候本身就产生溢出
        // BigDecimal:不可变的、任意精度的有符号十进制数
        //BigInteger charInt = new BigInteger("0");//BigInteger.valueOf(0); -->ERROR
        //leetcode提交的时候在类前面加上import java.math.BigInteger;
        BigInteger charInt = BigInteger.ZERO;  // 必须初始化
        boolean upLow = true; // 默认为整数
        for (int i = 0; i < charStr.length; i++) {
            if (i == 0) {
                if (charStr[i] >= '0' && charStr[i] <= '9') {
                    charInt = charInt.multiply(new BigInteger("10")).add(BigInteger.valueOf(charStr[i] - '0'));
                } else if (charStr[i] == '+') {
                    upLow = true;
                } else if (charStr[i] == '-') {
                    upLow = false;
                } else {
                    return 0;
                }
            } else {
                if (charStr[i] >= '0' && charStr[i] <= '9') {
                    charInt = charInt.multiply(new BigInteger("10")).add(BigInteger.valueOf(charStr[i] - '0'));
                } else {
                    //return 0;
                    break;
                }
            }
        }
        if (!upLow) {
            charInt = new BigInteger("0").subtract(charInt);
        }
        if (charInt.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) == 1) {
            return Integer.MAX_VALUE;
        } else if (charInt.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) == -1) {
            return Integer.MIN_VALUE;
        }
        return charInt.intValue();
    }

    //long版本：错误
    public int myAtoi3(String str) {
        char[] charStr = str.trim().toCharArray();
        long charInt = 0;
        boolean upLow = true; // 默认为整数
        for (int i = 0; i < charStr.length; i++) {
            if (i == 0) {
                if (charStr[i] >= '0' && charStr[i] <= '9') {
                    charInt = charInt * 10 + (charStr[i] - '0');
                } else if (charStr[i] == '+') {
                    upLow = true;
                } else if (charStr[i] == '-') {
                    upLow = false;
                } else {
                    return 0;
                }
            } else {
                if (charStr[i] >= '0' && charStr[i] <= '9') {
                    charInt = charInt * 10 + (charStr[i] - '0');
                } else {
                    //return 0;
                    break;
                }
            }
        }
        if (!upLow) {
            charInt = -charInt;
        }
        if (charInt > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (charInt < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) charInt;
    }

    public static int myAtoi4(String str) {
        if (str == null || str.length() == 0)
            return 0;//
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) sum * sign;
    }

    public int myAtoi5(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        Str2Int_8 atoi = new Str2Int_8();
        try {
            System.out.println("args = [" + atoi.myAtoi2(str) + "]");
        } catch (Exception e) {
            System.out.println("args = [" + e.toString() + "]");
        }
    }
}
