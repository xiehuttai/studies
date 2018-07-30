package tree;


public class BuildTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = reConstructBinaryTree(pre, in);
        preVistor(node);
        midVistor(node);
        aftVistor(node);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        int val = pre[0];
        TreeNode node = new TreeNode(pre[0]);
        if (pre.length==1){
            node.left=null;
            node.right=null;
            return node;
        }

        int index = getIndex(val, in);
        int[] preLeft=subIntArray(pre,1,index);
        int[] inLeft=subIntArray(in,0,index-1);
        int[] preRight=subIntArray(pre,index+1,pre.length-1);
        int[] inRight=subIntArray(in,index+1,pre.length-1);

        if (preLeft.length >0)
            node.left = reConstructBinaryTree(preLeft, inLeft);
        else
            node.left=  null;

        if (preRight.length>0)
            node.right= reConstructBinaryTree(preRight, inRight);
        else
            node.right=null;
        return node;
    }

    public static void preVistor(TreeNode node){
        if (node==null)
            return;
        System.out.print(node.val+" ");
        preVistor(node.left);
        preVistor(node.right);
    }

    public static void midVistor(TreeNode node){
        if (node==null)
            return;
        midVistor(node.left);
        System.out.print(node.val+" ");
        midVistor(node.right);
    }


    public static void aftVistor(TreeNode node){
        if (node==null)
            return;
        aftVistor(node.left);
        aftVistor(node.right);
        System.out.print(node.val+" ");
    }

    public static int getIndex(int val,int[] array){
        int index=0;
        while (array[index]!=val)
            index++;
        return index;
    }

    public static int[] subIntArray(int[] array,int begin,int end){
        int[] result = new int[end-begin+1];
        int i=0;
        while (begin<=end)
            result[i++]=array[begin++];
        return result;
    }



}
