import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by monkd on 2017/9/18.
 */
public class NextPermutation_31 {
    int[] numArr1;

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        System.out.println("args = [" + Arrays.toString(nums) + "]");
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        in.close();

        String[] strArr1 = str1.split(" ");
        NextPermutation_31 np = new NextPermutation_31();
        np.numArr1 = new int[strArr1.length];
        for (int i = 0; i < np.numArr1.length; i++) {
            np.numArr1[i] = Integer.parseInt(strArr1[i]);
        }
        np.nextPermutation(np.numArr1);
        System.out.println("args = [" + Arrays.toString(np.numArr1) + "]");
    }
}
