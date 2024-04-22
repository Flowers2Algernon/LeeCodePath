package medium;

public class Solution988 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(4);
        Solution988 solution988 = new Solution988();
        System.out.println(solution988.smallestFromLeaf(treeNode));
    }

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        return "";
    }

}

