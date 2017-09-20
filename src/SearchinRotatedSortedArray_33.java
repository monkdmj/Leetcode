import java.util.Scanner;

/**
 * Created by monkd on 2017/9/20.
 */
public class SearchinRotatedSortedArray_33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int pivot = -1;//不能初始化为0，防止pivot = len-2/len-1两种情况混淆
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        if(pivot == -1) pivot = nums.length - 1;
        if (target > nums[pivot] || target < nums[(pivot + 1)%nums.length]) {
            return -1;
        } else if (target <= nums[nums.length - 1]) {
            return binarySearch(nums, (pivot + 1)%nums.length, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, pivot, target);
        }
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int midium = 0;
        //while (left < right) {
        midium = (left + right) / 2;
        //假如一进入此函数就相等
        if (left < right) {
            if (nums[midium] == target) {
                return midium;
            } else if (nums[midium] > target) {
                return binarySearch(nums, left, midium, target);
            } else {
                return binarySearch(nums, midium + 1, right, target);
            }
        } else {
            if (nums[midium] == target) {
                return midium;
            } else {
                return -1;
            }
        }
        //}
    }

    public int search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
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

        SearchinRotatedSortedArray_33 sirsa = new SearchinRotatedSortedArray_33();
        System.out.println(sirsa.search(numArr1, target));
    }
}
