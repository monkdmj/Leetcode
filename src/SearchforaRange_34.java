import com.sun.deploy.util.ArrayUtil;
//import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * Created by monkd on 2017/9/20.
 */
public class SearchforaRange_34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums == null || nums.length == 0 || nums[start] > target || nums[end] < target) {
            return new int[]{-1,-1};
        }
        int pivotIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                pivotIndex = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (pivotIndex == -1) {
            return new int[]{-1,-1};
        }
        ArrayList<Integer> range = new ArrayList<>();
        int backup = pivotIndex;
        //range.add(backup);
        while (--backup >= 0 && nums[backup] == target) {}
        range.add(++backup);
        backup = pivotIndex;
        while (++backup <= nums.length - 1 && nums[backup] == target) {}
        range.add(--backup);

        //asList()
        //if (range.size() == 1) {
        //    range.add(pivotIndex);
        //}
        Integer[] searchRange = (Integer[])range.toArray(new Integer[range.size()]);
        //int[] searchRange = ArrayUtils.toPrimitive(range);
        //intValue()  valueof(int a)
        int[] searchRange2 = Arrays.stream(searchRange).mapToInt(Integer::valueOf).toArray();
        return searchRange2;
    }

    public int[] searchRange2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums == null || nums.length == 0 || nums[start] > target || nums[end] < target) {
            return new int[]{-1,-1};
        }
        int pivotIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                pivotIndex = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (pivotIndex == -1) {
            return new int[]{-1,-1};
        }
        int[] range = new int[2];
        int backup = pivotIndex;
        //range.add(backup);
        while (--backup >= 0 && nums[backup] == target) {}
        range[0] = ++backup;
        backup = pivotIndex;
        while (++backup <= nums.length - 1 && nums[backup] == target) {}
        range[1] = --backup;

        return range;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        int target = in.nextInt();
        in.close();

        String[] strArr1 = str1.split(" ");
        int[] numArr1 = new int[strArr1.length];
        for (int i = 0; i < numArr1.length; i++) {
            numArr1[i] = Integer.parseInt(strArr1[i]);
        }

        SearchforaRange_34 sr = new SearchforaRange_34();
        System.out.println(Arrays.toString(sr.searchRange(numArr1, target)));
    }
}
