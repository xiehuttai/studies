package leetcode.easy.linkadd;

/**
 * 1. 要完善，还要考虑int范围问题；
 * 2. 应该使用链表来模拟进位来实现；
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Main {

    public static void main(String[] args) {

        ListNode _364 = new ListNode(3);
        _364.next = new ListNode(6);
        _364.next.next = new ListNode(4);
        ListNode _641 = new ListNode(6);
        _641.next = new ListNode(4);
        _641.next.next = new ListNode(1);

        ListNode listNode_364_641 = new Main().addTwoNumbers(_364, _641);


        int v_364 = new Main().getValue(_364);
        int v_641 = new Main().getValue(_641);

        ListNode listNode = new Main().addTwoNumbers(v_364, v_641);

        ListNode _0_0 = new ListNode(0);
        ListNode _0_1 = new ListNode(0);


        ListNode listNode_0_0 = new Main().addTwoNumbers(_0_0, _0_1);


        ListNode _4 = new ListNode(4);
        ListNode _6 = new ListNode(6);

        ListNode listNode_4_6 = new Main().addTwoNumbers(_4, _6);

        System.out.println("run");

    }

    public ListNode addTwoNumbers(int v1, int v2) {

        int sum = v1 + v2;

        ListNode tempNode = null;
        ListNode currNode = null;
        ListNode rootNode = null;

        if (sum == 0) {
            return new ListNode(0);
        }

        while (sum != 0) {
            currNode = new ListNode(sum % 10);
            if (rootNode == null) {
                rootNode = currNode;
            }
            if (tempNode != null) {
                tempNode.next = currNode;
            }
            tempNode = currNode;
            sum = sum / 10;
        }
        return rootNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode rootNode = null;
        ListNode currNode = null;
        ListNode tempNode = null;
        int add = 0;
        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                int v1 = l1.val;
                int v2 = l2.val;
                int sum = v1 + v2 + add;
                if (sum > 9) {
                    add = 1;
                    tempNode = new ListNode(sum - 10);
                } else {
                    add = 0;
                    tempNode = new ListNode(sum);
                }

            }

            if (l1 == null && l2 != null) {
                int sum = l2.val + add;
                if (sum > 9) {
                    add = 1;
                    tempNode = new ListNode(sum - 10);
                } else {
                    tempNode = new ListNode(sum);
                    add = 0;
                }
            }

            if (l1 != null && l2 == null) {
                int sum = l1.val + add;
                if (sum > 9) {
                    add = 1;
                    tempNode = new ListNode(sum - 10);
                } else {
                    tempNode = new ListNode(sum);
                    add = 0;
                }
            }

            if (rootNode == null) {
                rootNode = tempNode;
                currNode = rootNode;
            } else {
                currNode.next = tempNode;
                currNode = currNode.next;
            }

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (l1==null && l2 ==null && add==1)
            currNode.next=new ListNode(1);

        return rootNode;
    }

    public int getValue(ListNode l) {
        int value = 0;
        int count = 1;
        while (l != null) {
            int temp = l.val;
            for (int i = 1; i < count; i++) {
                temp *= 10;
            }
            count++;
            value += temp;
            l = l.next;
        }
        return value;
    }

}
