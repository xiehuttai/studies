package leetcode.easy.linkadd;

/**
 * 1. 要完善，还要考虑int范围问题；
 * 2. 应该使用链表来模拟进位来实现；
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Main {

    public static void main(String[] args) {
        ListNode _364= new ListNode(3);
        _364.next=new ListNode(6);
        _364.next.next=new ListNode(4);
        ListNode _641= new ListNode(6);
        _641.next=new ListNode(4);
        _641.next.next=new ListNode(1);
        ListNode listNode = new Main().addTwoNumbers(_364, _641);

        ListNode _0_0 = new ListNode(0);
        ListNode _0_1 = new ListNode(0);


        ListNode listNode_0_0 = new Main().addTwoNumbers(_0_0, _0_1);

        System.out.println(listNode);

        System.out.println(listNode_0_0);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int v1= getValue(l1);
        int v2= getValue(l2);
        int sum = v1+v2;

        ListNode tempNode=null;
        ListNode currNode=null;
        ListNode rootNode=null;

        if (sum==0){
            return new ListNode(0);
        }

        while(sum!=0){
            currNode = new ListNode(sum%10);
            if(rootNode==null){
                rootNode=currNode;
            }
            if(tempNode!=null){
                tempNode.next=currNode;
            }
            tempNode=currNode;
            sum=sum/10;
        }
        return rootNode;
    }

    public int getValue(ListNode l)
    {
        int value=0;
        int count=1;
        while(l!=null)
        {
            int temp=l.val;
            for(int i=1;i<count;i++)
            {
                temp*=10;
            }
            count++;
            value+=temp;
            l=l.next;
        }
        return value;
    }

}
