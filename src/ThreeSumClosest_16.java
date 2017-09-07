import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by monkd on 2017/9/7.
 */
public class ThreeSumClosest_16 {
    // Time Limit Exceeded
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        //HashSet<Integer> set = new HashSet<>();
        //for (Integer n : nums) {
        //    set.add(n);
        //}
        //int[] numsUniq = new int[set.size()];
        //int m = 0;
        //for (Integer s : set) {
        //    numsUniq[m++] = s;
        //}
        //Arrays.sort(numsUniq);
        //并不能去重，如果nums=[1,-1,-1,1,3]
        //if(numsUniq.length < 3) numsUniq = nums;
        int[] numsUniq = nums;

        HashSet<Integer> sum = new HashSet<>();
        for (int i = 0; i < numsUniq.length - 2; i++) {
            for (int j = i + 1; j < numsUniq.length - 1; j++) {
                for (int k = j + 1; k < numsUniq.length; k++) {
                    sum.add(numsUniq[i] + numsUniq[j] + numsUniq[k]);
                }
            }
        }
        int[] sumUniq = new int[sum.size()];
        int m = 0;
        for (Integer s : sum) {
            sumUniq[m++] = s;
        }
        Arrays.sort(sumUniq);
        m = 0;
        if (sumUniq[0] >= target) {
            return sumUniq[0];
        }
        if (sumUniq[sumUniq.length - 1] <= target) {
            return sumUniq[sumUniq.length - 1];
        }
        while (m < sumUniq.length && sumUniq[m] < target) {
            m++;
        }
        //确保访问指数m不会溢出
        if (Math.abs(sumUniq[m - 1] - target) < Math.abs(sumUniq[m] - target)) {
            return sumUniq[m - 1];
        } else {
            return sumUniq[m];
        }
    }

    public int threeSumClosest2(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            //一般情况下，sum会趋于一个介于大于或小于的震荡环境下
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int target = in.nextInt();
        in.close();

        String[] strArr = str.split(" ");
        int[] numArr = new int[strArr.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        ThreeSumClosest_16 tsc = new ThreeSumClosest_16();
        System.out.println("args = [" + tsc.threeSumClosest(numArr, target) + "]");
    }
}
