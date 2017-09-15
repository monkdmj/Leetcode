import java.util.Scanner;

/**
 * Created by monkd on 2017/9/15.
 */
public class ImplementstrStr_28 {
    public int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        if (hl == 0 && nl == 0) {
            return 0;
        }
        if (hl < nl || !haystack.contains(needle)) {
            return -1;
        }
        for (int i = 0; i < hl; i++) {
            if (haystack.substring(i, i + nl).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        //*********
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        //*********
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        in.close();

        ImplementstrStr_28 is = new ImplementstrStr_28();
        System.out.println("args = [" + is.strStr(str1, str2) + "]");
    }
}
