import java.util.Scanner;

/**
 * Created by monkd on 2017/9/15.
 */
public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = dummy1;
        ListNode tail = head;
        while (tail != null) {
            if (tail.next != null) {
                dummy2.next = tail.next;//必须断开第一个节点与第二个节点的链接，否则会产生无穷集
                dummy2 = dummy2.next;
                tail.next = tail.next.next;
            }
            dummy2.next = tail;
            dummy2 = dummy2.next;
            tail = tail.next;
        }
        return dummy1.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        in.close();

        String[] strArr1 = str1.split(" ");
        int[] numArr1 = new int[strArr1.length];
        for (int i = 0; i < numArr1.length; i++) {
            numArr1[i] = Integer.parseInt(strArr1[i]);
        }
        SwapNodesInPairs_24 snip = new SwapNodesInPairs_24();
        snip.creatListNode(numArr1).printListNode();
        snip.swapPairs(snip.creatListNode(numArr1)).printListNode();
    }
}
