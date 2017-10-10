import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by monkd on 2017/9/22.
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    /**
     * The main idea reminds an approach for solving coins/knapsack problem - to store the result for all i < target
     * and create the solution from them. For that for each t from 1 to our target we try every candidate which is
     * less or equal to t in ascending order. For each candidate "c" we run through all combinations
     * for target t-c starting with the value greater or equal than c to avoid duplicates
     * and store only ordered combinations.
     * @param cands
     * @param t
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] cands, int t) {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                    // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
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

        CombinationSum_39 cs = new CombinationSum_39();
        //System.out.println("args = [" + Arrays.toString(cs.combinationSum(numArr1, target)) + "]");
    }
}
