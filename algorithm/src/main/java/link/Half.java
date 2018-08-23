package link;


/**
 * 将一个链表的后面一般间隔插入前面一般，比如 1 2 3 4 ——> 1 3 2 4
 */
public class Half {


    public static void main(String[] args) {

        Node listNode1 = new Node(1);
        Node listNode2 = new Node(2);
        Node listNode3 = new Node(3);
        Node listNode4 = new Node(4);

        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=null;

        Node node = insertHalf(listNode1);

        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }


    }

    public static Node insertHalf(Node node){

        if (node==null)
            return node;
        Node p=node,q=node;
        int length=0;
        while (p!=null){
            length++;
            p=p.next;
        }
        if (length<=2)
            return node;
        int half=length/2;
        Node m=node;
        while (--half>0){
            m=m.next;
        }
        p=node;
        q=m.next;
        m.next=null;

        Node tq,tp,t=new Node(0);
        while (q!=null){
            tp=p.next;
            p.next=null;
            t.next=p;
            t=t.next;
            p=tp;

            tq=q.next;
            q.next=null;
            t.next=q;
            t=t.next;
            q=tq;
        }
        return node;
    }


}
