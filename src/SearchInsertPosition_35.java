import java.util.Scanner;

/**
 * Created by monkd on 2017/9/21.
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        if (nums.length == 0 || nums[start] > target) {
            return 0;
        }
        if (nums[end] < target) {
            return end + 1;
        }
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start > mid) {
            return mid + 1;
        }
        else //if (end < mid)
        {
            return mid;
        }
    }

    public int searchInsert2(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
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

        SearchInsertPosition_35 sip = new SearchInsertPosition_35();
        System.out.println(sip.searchInsert(numArr1, target));
    }
}
