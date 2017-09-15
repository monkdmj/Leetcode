import java.util.Scanner;

/**
 * Created by monkd on 2017/9/15.
 */
public class RemoveDuplicatesfSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return 0;
        }
        int result = len;
        for (int i = 0, j = 0; i < len; i++) {
            while (i < len - 1 && nums[i + 1] == nums[i]) {
                result--;
                i++;
            }
            nums[j] = nums[i];
            j++;
        }
        return result;
    }

    public int removeDuplicates2(int[] A) {
        if (A.length==0) return 0;
        int j=0;
        for (int i=0; i<A.length; i++)
            if (A[i]!=A[j]) A[++j]=A[i];
        return ++j;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        in.close();

        String[] strArr1 = str1.split(" ");
        int[] numArr1 = new int[strArr1.length];
        for (int i = 0; i < numArr1.length; i++) {
            numArr1[i] = Integer.parseInt(strArr1[i]);
        }

        RemoveDuplicatesfSortedArray_26 ad = new RemoveDuplicatesfSortedArray_26();
        System.out.println("args = [" + ad.removeDuplicates(numArr1) + "]");
    }
}
