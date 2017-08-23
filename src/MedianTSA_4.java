import java.util.Scanner;

/**
 * Created by monkd on 2017/8/23.
 */
public class MedianTSA_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(n == 0)
            return medianNum(nums1);
        double ans = 0.0;
        int[] index2 = new int[n];
        int[] num3 = new int[m + n];
        //index2[0] = binarySearch(nums1, nums2[0], 0, m - 1);
        index2[0] = insertToArrary(nums1, nums2[0]);
        num3[index2[0]] = nums2[0];
        for (int i = 1; i < n; i++) {
            //index2[i] = binarySearch(nums1, nums2[i], index2[i - 1], m - 1) + i;
            index2[i] = insertToArrary(nums1, nums2[i]) + i;
            num3[index2[i]] = nums2[i];
        }
        for (int i = 0, j = 0, k = 0; i < m + n; i++) {
            if (i != index2[k]) {
                num3[i] = nums1[j++];
            } else {
                if (k < n - 1)
                    k++;
            }
        }
        //if ((m + n) % 2 != 0) {
        //    ans = num3[(m + n - 1) / 2];
        //} else {
        //    ans = (num3[(m + n - 1) / 2] + num3[(m + n - 1) / 2 + 1]) / 2.0;
        //}
        ans = medianNum(num3);
        return ans;
    }

    public double medianNum(int[] num){
        int p = num.length;
        if (p % 2 != 0) {
            return num[(p - 1) / 2];
        } else {
            return  (num[(p - 1) / 2] + num[(p - 1) / 2 + 1]) / 2.0;
        }
    }

    public int binarySearch(int[] arr, int target, int from, int to) {
        int range = to - from;
        if (range > 0) {
            int mid = (to + from) / 2;
            if (arr[mid] > target) {
                return binarySearch(arr, target, from, mid - 1);
            } else {
                return binarySearch(arr, target, mid + 1, to);
            }
        } else {
            if (arr[from] > target) {//如 5, 要插入的是4  （含插入数在原数组左边界的情况）
                return from;
            } else {//包括插入数在原数组的 右边界的情况
                return from + 1;
            }
        }
    }

    public static int insertToArrary(int[] arr, int key) {
        int max, min, mid;
        min = 0;
        max = arr.length - 1;

        while (min <= max) {
            mid = (min + max) / 2;

            if (key > arr[mid])
                min = mid + 1;
            else if (key < arr[mid])
                max = mid - 1;
            else
                return mid;
            //在min<=max的情况下，遍历比较的最后结果是min=max，然后返回元素插入的位置
        }
        return min;
        //最后无论插入数在原数组左边界或右边界的情况下，返回min值，就是元素插入的位置
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        in.close();
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        int[] arr1 = new int[str1.length];
        int[] arr2 = new int[str2.length];
        for (int i = 0; i < str1.length; i++) {
            arr1[i] = Integer.parseInt(str1[i]);
        }
        for (int i = 0; i < str2.length; i++) {
            arr2[i] = Integer.parseInt(str2[i]);
        }

        MedianTSA_4 test = new MedianTSA_4();
        System.out.print(test.findMedianSortedArrays(arr1, arr2));
    }
}
