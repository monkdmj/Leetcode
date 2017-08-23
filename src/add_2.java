import java.util.Scanner;

/**
 * Created by monkd on 2017/8/14.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

    public int getVal() {
        return this.val;
    }

    public void addNode(ListNode newNode) {
        if (this.next == null) {
            this.next = newNode;
        } else
            this.next.addNode(newNode);
    }

    public void printListNode() {
        System.out.print(this.val);
        if (this.next != null) {
            System.out.print("->");
            this.next.printListNode();
        }
    }
}

//class List{
//    ListNode head;
//    public ListNode creatListNode(int[] nums){
//        //ListNode head;  //head = null 会出现java.lang.NullPointerException，但是这样却又没初始化，所以最好放在类中作为私有变量
//
//        for (int n : nums){
//            ListNode tmp = new ListNode(n);
//            head.addNode(tmp);
//        }
//        return head;
//    }
//}

public class add_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //ListNode head;
        //head.val = l1.val + l2.val;
        int flag = 0;
        int first = l1.val + l2.val;
        if (first >= 10) {
            first -= 10;
            flag = 1;
        }
        ListNode head = new ListNode(first);
        ListNode l3 = head;
        //注意两个三位数相加结果为四位数的情况flag == 1
        //还得注意一种情况，若当前l1为null,l1.next会引发java.lang.NullPointerException，造成判断条件出错
        while ((l1.next != null || l2.next != null) || flag == 1) {
            //l1 = l1.next;
            //l2 = l2.next;
            ListNode tmp;
            if (l1.next == null && l2.next == null) {
                //l1.val = 0;  //java.lang.NullPointerException如果l1为null,l1.val访问出错
               tmp = new ListNode(flag);
            }
            else if (l1.next != null && l2.next == null) {
                l1 = l1.next;
                tmp = new ListNode(l1.val + flag);
            }
            else if (l1.next == null && l2.next != null) {
                l2 = l2.next;
                tmp = new ListNode(l2.val + flag);
            }
            else {
                l1 = l1.next;
                l2 = l2.next;
                tmp = new ListNode(l1.val + l2.val + flag);
            }
            //ListNode tmp = null;  //必须重新创建
            //tmp.val = l1.val + l2.val + flag;
            if (tmp.val >= 10) {
                tmp.val -= 10;
                flag = 1;
            } else
                flag = 0;  //必须有
            l3.next = tmp;
            l3 = tmp;
            //试比较两者之间的速度区别：addNode更耗时间，虽然简洁
            //head.addNode(tmp);
        }
        return head;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;//机智！能后移才后移
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }//最高位进位的情况
        return dummyHead.next;
    }

    public ListNode creatListNode(int[] nums) {
        if (nums == null)
            return null;
        ListNode head = new ListNode(nums[0]);  //head = null 会出现java.lang.NullPointerException，但是这样却又没初始化，所以最好放在类中作为私有变量
        ListNode traverse = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode tmp = new ListNode(nums[i]);
            traverse.next = tmp;
            traverse = tmp;
        }
        return head;
        //ListNode head;  //head = null 会出现java.lang.NullPointerException，但是这样却又没初始化，所以最好放在类中作为私有变量
        //for (int n : nums){
        //    ListNode tmp = new ListNode(n);
        //    head.addNode(tmp);
        //}
        //return head;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        in.close();
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        int[] num1 = new int[str1.length];
        int[] num2 = new int[str2.length];
        int i = 0, j = 0;
        for (String s : str1) {
            num1[i] = Integer.parseInt(s);
            i++;
        }
        for (String s : str2) {
            num2[j] = Integer.parseInt(s);
            j++;
        }
        add_2 ins = new add_2();
        ListNode L1 = ins.creatListNode(num1);
        ListNode L2 = ins.creatListNode(num2);
        ListNode L3 = ins.addTwoNumbers(L1, L2);
        L3.printListNode();
    }
}
