import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/7/4.
 */
public class sum_1 {
    //如果不想创建对象实例直接调用，必须定义为静态方法
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        int outer, inner;
        for (outer = 0; outer < nums.length; outer++) {
            for (inner = outer; inner < nums.length; inner++) {
                if (nums[outer] + nums[inner] == target) {
                    indices[0] = outer;
                    indices[1] = inner;
                }
            }
        }
        return indices;
    }

    //public static void main(String[] args) {
    //    ArrayList<Integer> numbers = new ArrayList<>();
    //    //怎么初始化不定长度int数组
    //    //System.arraycopy方法或Arrays类中的方法
    //    int target;
    //    Scanner in = new Scanner(System.in);
    //    int i = 0;
    //    //hasNext()结束的方式是ctrl+z；next()读取每一行，不是按空格，next默认的匹配方式是遇到空格和换行符，in.useDelimiter("\n");
    //    //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    //    while (in.hasNext()) {
    //        numbers.add(new Integer(Integer.parseInt(in.next())));
    //    }
    //    in.close();
    //    //System.in什么时候结束？
    //    Scanner in2 = new Scanner(System.in);
    //    target = Integer.parseInt(in2.next());
    //    in2.close();
    //    int[] intNumbers = new int[numbers.size()];
    //    Integer[] integetNumbers = new Integer[numbers.size()];
    //    numbers.toArray(integetNumbers);
    //    for (i = 0; i < integetNumbers.length; i++) {
    //        intNumbers[i] = integetNumbers[i].intValue();
    //    }
    //    // List<Integer> list=Arrays.asList(newNum); 将int数组转为ArrayList
    //    int[] tmp = twoSum(intNumbers, target);
    //    System.out.println(tmp.toString());
    //}
    public static void main(String[] args) {
        Scanner in1 = new Scanner(System.in);
        String str = in1.nextLine();
        String[] numList = str.split("\\s");
        int[] intNumbers = new int[numList.length];
        int i = 0;
        for (String s : numList) {
            intNumbers[i] = Integer.parseInt(s);
            i++;
        }
        //System.in什么时候结束？
        int target = Integer.parseInt(in1.next());
        in1.close();
        // List<Integer> list=Arrays.asList(newNum); 将int数组转为ArrayList
        int[] tmp = twoSum(intNumbers, target);
        for (int s : tmp) {
            System.out.print(s);
        }
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum3(int[] nums, int tarsget) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(tarsget - nums[i])){
                result[0] = i;
                result[1] = map.get(tarsget - nums[i]);
            }
            map.put(nums[i], i);
            //不添加此条件map.get(complement) != i的原因是：后添入当前键值对，判断是当前的并不存在
        }
        return result;
    }
}
