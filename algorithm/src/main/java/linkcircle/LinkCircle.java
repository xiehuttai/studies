package linkcircle;

/**
 * 判断一个链表是否有环，时间复杂度o(n)
 */
public class LinkCircle {

    public static boolean hasLoop(Node n){
        //定义两个指针tmp1,tmp2
        Node tmp1 = n;
        Node tmp2 = n.next;

        while(tmp2!=null){
            int d1 = tmp1.val;
            int d2 = tmp2.val;
            if(d1 == d2)return true;//当两个指针重逢时，说明存在环，否则不存在。
            tmp1 = tmp1.next;  //每次迭代时，指针1走一步，指针2走两步
            tmp2 = tmp2.next.next;
            if(tmp2 == null)return false;//不存在环时，退出
        }
        return true; //如果tmp2为null，说明元素只有一个，也可以说明是存在环
    }

}
