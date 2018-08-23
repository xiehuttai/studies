package link;

public class Node {

    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        return  ((Node) obj).val==this.val;
    }

}
