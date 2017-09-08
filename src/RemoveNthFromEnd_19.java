import java.util.Scanner;

/**
 * Created by monkd on 2017/9/8.
 */
//class ListNode{
//    int val;
//    ListNode next;
//    ListNode(int v){
//        val = v;
//    }
//}

public class RemoveNthFromEnd_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            length++;
        }
        if (n > length) {
            return head;
        }
        int target = length + 1 - n;
        int i = 1;
        if (target == 1) {
            return head.next;
        }
        p = head;
        ListNode preP = p;
        while (p != null) {
            preP = p;
            i++;
            p = p.next;
            if (i == target) {
                if (i == length) {
                    preP.next = null;
                } else {
                    preP.next = p.next;
                }
                break;
            }
        }
        return head;
    }

    // First we will add an auxiliary "dummy" node, which points to the list head.
    // The "dummy" node is used to simplify some corner cases such as a list with only one node, or removing the head of the list.
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    /**The above algorithm could be optimized to one pass. Instead of one pointer, we could use two pointers.
     * The first pointer advances the list by n+1 steps from the beginning, while the second pointer starts
     * from the beginning of the list. Now, both pointers are exactly separated by nn nodes apart.
     * We maintain this constant gap by advancing both pointers together until the first pointer arrives past
     * the last node. The second pointer will be pointing at the nnth node counting from the last. We relink
     * the next pointer of the node referenced by the second pointer to point to the node's next next node.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
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
        String str = in.nextLine();
        int target = in.nextInt();
        in.close();

        String[] strArr = str.split(" ");
        int[] numArr = new int[strArr.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        RemoveNthFromEnd_19 rnfe = new RemoveNthFromEnd_19();
        rnfe.creatListNode(numArr).printListNode();
        rnfe.removeNthFromEnd(rnfe.creatListNode(numArr), target).printListNode();
    }
}
