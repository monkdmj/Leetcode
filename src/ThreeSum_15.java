import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by monkd on 2017/9/7.
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return null;
        }
        List<List<Integer>> sum = new ArrayList<>();  // List is abstract,can't be initialed!
        List<List<Integer>> sumSet = new ArrayList<>();  // List is abstract,can't be initialed!
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[j] + nums[k] == -nums[i]) {
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        sum.add(tmp);
                    }
                }
            }
        }
        HashSet<List<Integer>> set = new HashSet<>(); // 不奏效
        for (List<Integer> s : sum) {
            set.add(s);
        }
        for (List<Integer> s : set) {
            sumSet.add(s);
        }
        return sumSet;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> set = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1, right = nums.length - 1, target = 0 - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1]) left++;
                        while(left < right && nums[right] == nums[right+1]) right--;
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        String[] strArr = str.split(" ");
        int[] numArr = new int[strArr.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        ThreeSum_15 ts = new ThreeSum_15();
        System.out.println("args = [" + ts.threeSum2(numArr) + "]");
    }
}
