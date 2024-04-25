package medium;

/*Given the root of a binary tree and two integers val and depth,
add a row of nodes with value val at the given depth depth.
Note that the root node is at depth 1.
The adding rule is:
Given the integer depth, for each not null tree node cur at the depth depth - 1,
create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all,
then create a tree node with value val as the new root of the whole original tree,
and the original tree is the new root's left subtree.*/
public class Solution623 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 4;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val  = 2;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 3;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.val = 1;
//        TreeNode treeNode4 = new TreeNode();
        treeNode.left = treeNode1;
        treeNode.right = null;
        treeNode1.left = treeNode2;
        treeNode2.right = treeNode3;
        Solution623 solution623 = new Solution623();
        solution623.addOneRow(treeNode,1,3);

    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //首先处理depth == 1的情况--将原有的树设置为新节点的left subtree
        if (depth == 1) {
            TreeNode treeNode = new TreeNode();
            treeNode.val = val;
            treeNode.left = root;
            return treeNode;
        }
        //接下来是递归
        dfs(root, val, depth, 1);
        return root;
    }

    //递归需要返回什么？返回treeNode? 还是depth的值？需要设置一个值带到递归函数里面来表示当前是哪一层
    public TreeNode dfs(TreeNode root, int val, int depth, int nowDepth) {//此处需要附加表示是左节点还是右节点的布尔值，但是并不意味着一个左节点后面就不能加原来节点的右节点
        if (root == null ){
            return null;
        }
        if (nowDepth != depth - 1) {
            nowDepth++;
           root.right = dfs(root.right, val, depth, nowDepth);
           root.left = dfs(root.left, val, depth, nowDepth);
            return root;
        } else {//此处插入操作有问题
            TreeNode treeNodeLeft = new TreeNode(val);
            TreeNode treeNodeRight = new TreeNode(val);
            treeNodeLeft.left = root.left;
            treeNodeRight.right = root.right;
            root.left = treeNodeLeft;
            root.right = treeNodeRight;
            return root;
        }
    }

}
