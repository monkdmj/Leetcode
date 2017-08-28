import java.util.Scanner;

/**
 * Created by monkd on 2017/8/25.
 */
public class ZigZag_6 {
    public String convert(String s, int numRows) {
        int length = s.length();
        String r = "";
        int brance = 0;
        if (numRows == 1) {
            return s;
        }
        while ((brance * (numRows - 1)) < length) {
            brance++;
        }//获取多少条“边”，条件的小于号值得寻味，必须在numRows大于1的情况下
        char[] result = new char[length];
        int j = 0;
        for (int k = 0; k < (brance + 1) / 2; k++) {
            result[j++] = s.charAt(2 * k * (numRows - 1));
        }
        if (numRows >= 3) {
            for (int i = 1; i < numRows - 1; i++) {
                for (int k = 0; k < brance; k++) {
                    if ((k & 1) == 1 && ((k + 1) * (numRows - 1) - i) < length)
                        result[j++] = s.charAt((k + 1) * (numRows - 1) - i);
                    else if((k & 1) == 0 && (k * (numRows - 1) + i) < length)
                        result[j++] = s.charAt(k * (numRows - 1) + i);
                }
            }
        }
        for (int k = 0; k < (brance + 1) / 2; k++) {
            if((2 * k + 1) * (numRows - 1) < length)
                result[j++] = s.charAt((2 * k + 1) * (numRows - 1));
        }
        //r = result.toString();  //地址转化为字符串
        //String strStringType="my string"; //创建一个字符串变量strStringType
        //char[] chrCharArray; //创建一个字符数组chrCharArray
        //chrCharArray = strStringType.toCharArray(); //将字符串变量转换为字符数组
        //strStringType= String.valueOf(chrCharArray ); //将字符数组转换为字符串
        r = String.valueOf(result);
        return r;
    }

    public String convert2(String s, int numRows) {
        if(numRows<=1)return s;
        StringBuilder[] sb=new StringBuilder[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder("");   //init every sb element **important step!!!!
        }
        int incre=1;
        int index=0;
        for(int i=0;i<s.length();i++){
            sb[index].append(s.charAt(i));
            if(index==0){incre=1;}
            if(index==numRows-1){incre=-1;}
            index+=incre;
        }
        String re="";
        for(int i=0;i<sb.length;i++){
            re+=sb[i];
        }
        return re.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        int n1 = Integer.parseInt(in.nextLine());
        in.close();

        //test:
        //System.out.println(s1.substring(0,s1.length()));

        ZigZag_6 lp = new ZigZag_6();
        //System.out.print(lp.convert(s1, n1));
        System.out.print(lp.convert2(s1, n1));
    }
}
