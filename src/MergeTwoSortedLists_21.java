import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by monkd on 2017/9/12.
 */
public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode mergeList = new ListNode(0);
        //mergeList.next = l1.val < l2.val ? l1 : l2;
        ListNode first = mergeList;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                first.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                first.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    first.next = l1;
                    l1 = l1.next;
                } else {
                    first.next = l2;
                    l2 = l2.next;
                }
            }
            first = first.next;
        }
        return mergeList.next;
    }

    public ListNode creatListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode travese = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode tmp = new ListNode(nums[i]);
            travese.next = tmp;
            travese = tmp;
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        in.close();

        String[] strArr1 = str1.split(" ");
        String[] strArr2 = str2.split(" ");
        int[] numArr1 = new int[strArr1.length];
        int[] numArr2 = new int[strArr2.length];
        for (int i = 0; i < numArr1.length; i++) {
            numArr1[i] = Integer.parseInt(strArr1[i]);
        }
        for (int i = 0; i < numArr2.length; i++) {
            numArr2[i] = Integer.parseInt(strArr2[i]);
        }
        Arrays.sort(numArr1);
        Arrays.sort(numArr2);
        MergeTwoSortedLists_21 mtsl = new MergeTwoSortedLists_21();
        mtsl.creatListNode(numArr1).printListNode();
        mtsl.creatListNode(numArr2).printListNode();
        mtsl.mergeTwoLists(mtsl.creatListNode(numArr1), mtsl.creatListNode(numArr2)).printListNode();
    }
}
