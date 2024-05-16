package easy;


import java.util.List;

public class Solution2331 {
    public static void main(String[] args) {
        TreeNode binaryTree = new TreeNode();
        binaryTree= new TreeNode(1);
        binaryTree.left = new TreeNode(2);
        binaryTree.right = new TreeNode(3);
        binaryTree.left.left = new TreeNode(4);
        binaryTree.left.right = new TreeNode(5);
        Solution2331 solution2331 = new Solution2331();
        solution2331.evaluateTree(binaryTree);
    }
    public boolean evaluateTree(TreeNode root) {
        if(root.left==null&&root.right==null){
            if (root.val==0)return false;
            return true;
        }
        //不是leaf node
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        if (root.val==2) return left||right;
        return left&&right;
    }
    private void printInorder(TreeNode node,List<Integer> nodes){
        if (node==null){
            return;
        }
        printInorder(node.left,nodes);
        printInorder(node.right,nodes);
        System.out.println(node.val+" ");
        nodes.add(node.val);
    }
}
