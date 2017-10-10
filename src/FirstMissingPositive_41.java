import java.util.Scanner;

/**
 * Created by monkd on 2017/10/10.
 */
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        //存在问题，并不能完全“排序”
        //for (int i = 0; i < nums.length; i++) {
        //    if (nums[i] != i + 1) {
        //        if (nums[i] > 0 && nums[i] <= nums.length) {
        //            swap(nums, i, nums[i] - 1);
        //        }//保证索引正常
        //    }
        //}
        int i = 0;
        while ( i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }//保证索引正常;此外若交换双方相等则会陷入死循环，且无交换必要
                else {
                    i++;
                }
            } else {
                i++;
            }
        }
        int res = 0;
        while (res < nums.length && nums[res] == res + 1) {
            res++;
        }
        return res+1;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
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

        FirstMissingPositive_41 fmp = new FirstMissingPositive_41();
        System.out.println("args = [" + fmp.firstMissingPositive(numArr1) + "]");
    }
}
