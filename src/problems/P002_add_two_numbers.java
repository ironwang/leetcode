package problems;

/**
 * Created by wanghongkai on 2017/1/6.
 *
 * 问题：求两个用特定结构表示的整数的和，该结构为链表，由个位开始组织成一个数
 *
 * 思路：用一个数表示是否进位，同步遍历两个链表，一个当前节点为空另一个不为空时，用特殊的构造的为0的节点代替，直到两个都为空，检查进位
 */
public class P002_add_two_numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val1 = l1.val;
        int val2 = l2.val;
        int singleSum = (val1 + val2) % 10;
        int ten = (val1 + val2) / 10;
        ListNode result = new ListNode(singleSum);
        ListNode now = result;
        ListNode empty = new ListNode(0);
        ListNode node;
        while (true) {
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 == null) {
                if (ten == 1) {
                    node = new ListNode(1);
                    now.next = node;
                }
                return result;
            } else if (l1 == null) {
                l1 = empty;
            } else if (l2 == null) {
                l2 = empty;
            }
            val1 = l1.val;
            val2 = l2.val;
            node = new ListNode((val1 + val2 + ten) % 10);
            ten = (val1 + val2 + ten) / 10;
            now.next = node;
            now = node;
        }
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
