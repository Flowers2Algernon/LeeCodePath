package easy;

public class Solution404 {
    public static void main(String[] args) {

    }

    //这是一个binary tree，每一个左节点的下标都能计算出来，但是给定的只是一个类似于链表一样的节点
    public int sumOfLeftLeaves(TreeNode root) {
        return inOrderDFS(root,false);
    }
    public int inOrderDFS(TreeNode node, boolean isLeft){
        if (node == null){
            return 0;
        }
        if (node.right==null&&node.left==null){
            return isLeft?node.val:0;
        }
        int leftNodeSum = inOrderDFS(node.left,true);
        int rightNodeSum = inOrderDFS(node.right,false);
        return leftNodeSum+rightNodeSum;
    }
}

