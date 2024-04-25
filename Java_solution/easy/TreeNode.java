package easy;

public class TreeNode {
    int val;
    easy.TreeNode left;
    easy.TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, easy.TreeNode left, easy.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

