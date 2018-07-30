package link;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ListNode listNode67 = new ListNode(67);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode24 = new ListNode(24);
        ListNode listNode58 = new ListNode(58);

        listNode67.next=listNode0;
        listNode0.next=listNode24;
        listNode24.next=listNode58;

        ArrayList<Integer> integers = printListFromTailToHead(listNode67);
        System.out.println(integers);

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode p=listNode;
        if (p==null)
            return  new ArrayList<>();
        else {
            ArrayList<Integer> list= printListFromTailToHead(p.next);
                    list.add(p.val);
            return list;
        }
    }

}
