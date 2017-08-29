import java.util.Scanner;

/**
 * Created by monkd on 2017/8/28.
 */
public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -x;
        } // 默认负数不是回文数字
        String str = String.valueOf(x);
        int[] num = new int[str.length()];
        int i = 0, backup = x;
        long reverseInt = 0;
        while (backup != 0) {
            num[i++] = backup % 10;
            backup /= 10;
        }
        for (int j = 0; j < num.length; j++) {
            reverseInt = reverseInt * 10 + num[j];
            if (reverseInt * sign > Integer.MAX_VALUE || reverseInt * sign < Integer.MIN_VALUE) {
                return false;
            }
        }
        if (reverseInt == x) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        } // 默认负数不是回文数字
        String str = String.valueOf(x);
        int[] num = new int[str.length()];
        int i = 0, backup = x;
        long reverseInt = 0;
        while (backup != 0) {
            num[i++] = backup % 10;
            backup /= 10;
        }
        for (int j = 0; j < num.length; j++) {
            reverseInt = reverseInt * 10 + num[j];
            if (reverseInt > Integer.MAX_VALUE) {
                return false;
            }
        }
        if (reverseInt == x) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome3(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //test

        PalindromeNumber_9 pN = new PalindromeNumber_9();
        System.out.println("args = [" + pN.isPalindrome(Integer.parseInt(str)) + "]");
    }
}

