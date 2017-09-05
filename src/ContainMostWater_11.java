import java.util.Scanner;

/**
 * Created by monkd on 2017/9/4.
 */
public class ContainMostWater_11 {
    //Time Limit Exceeded
    public int maxArea(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int maxA = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = (j - i) * (Math.min(height[i], height[j]));
                if (temp > maxA) {
                    maxA = temp;
                }
                //maxA = Math.max(maxA, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxA;
    }

    /** Now, to maximize the area, we need to consider the area between the lines of larger lengths.
     * If we try to move the pointer at the longer line inwards, we won't gain any increase in area,
     * since it is limited by the shorter line*/

    /** Here is a simple proof for the solution.
     * Use v[low, high] indicates the volume of container with low and high. suppose height[low] < height[high],
     * then we move low to low+1, that means we ingored v[low, high-1],v[low, high-2],etc, if this is safe,
     * then the algorithm is right, and it's obvious that v[low, high-1],high[low, high-2]......can't be
     * larger than v[low, high] since its width can't be larger than high-low, and its height is limited by height[low].*/
    public int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strArray = str.split(str);
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        ContainMostWater_11 cmw = new ContainMostWater_11();
        System.out.println("args = [" + cmw.maxArea(intArray) + "]");
    }
}
