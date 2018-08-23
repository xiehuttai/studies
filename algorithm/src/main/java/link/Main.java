package link;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Node listNode67 = new Node(67);
        Node listNode0 = new Node(0);
        Node listNode24 = new Node(24);
        Node listNode58 = new Node(58);

        listNode67.next=listNode0;
        listNode0.next=listNode24;
        listNode24.next=listNode58;

        ArrayList<Integer> integers = printListFromTailToHead(listNode67);
        System.out.println(integers);

    }

    public static ArrayList<Integer> printListFromTailToHead(Node listNode) {
        Node p=listNode;
        if (p==null)
            return new ArrayList<>();
        else {
            ArrayList<Integer> list= printListFromTailToHead(p.next);
                    list.add(p.val);
            return list;
        }
    }

}
