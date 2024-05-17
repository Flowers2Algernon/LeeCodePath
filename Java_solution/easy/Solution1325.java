package easy;
/*Given a binary tree root and an integer target, delete all the leaf nodes with value target.
Note that once you delete a leaf node with value target,
if its parent node becomes a leaf node and has the value target,
 it should also be deleted (you need to continue doing that until you cannot).*/
public class Solution1325 {
    public static void main(String[] args) {
        TreeNode binaryTree = new TreeNode();
        binaryTree= new TreeNode(1);
        binaryTree.left = new TreeNode(2);
        binaryTree.right = new TreeNode(3);
        binaryTree.left.left = new TreeNode(2);
        binaryTree.right.left = new TreeNode(2);
        binaryTree.right.right = new TreeNode(4);
        Solution1325 solution1325 = new Solution1325();
        TreeNode treeNode = solution1325.removeLeafNodes(binaryTree, 2);
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        //find the leaf
        //determine if equals target
        //yse, delete it
        //need to loop? since the delete leave will make

        return findTheRemovedLeafNodes(root,target);
    }
    public TreeNode findTheRemovedLeafNodes(TreeNode root, int target){
        if (root==null) return null;
        root.left = removeLeafNodes(root.left,target);
        root.right=removeLeafNodes(root.right,target);//先递归再判断删除，而不是先判断删除再递归
        if (root.val==target&&root.right==null&&root.left==null){
            return null;
        }
        return root;

    }
    public TreeNode findTheRemovedLeafNodes1(TreeNode root, int target){
        if (root==null) return null;
        if (root.left==null&&root.right==null){
            //delete target leaf node
            if (root.val==target) return null;//此处没有真正删除，赋值为null后还是一样会存在
            return root;
        }
        //travers and find the leaf nodes
        removeLeafNodes(root.left,target);//没有删除的原因是只是单纯将当前结点设置为Null，但是并没有改变父节点对它的引用。
        //因此，尽管你将其设置为null,但该结点还是存在于树中，解决方法见findTheRemovedLeafNodes
        removeLeafNodes(root.right,target);
        return root;
    }
}
