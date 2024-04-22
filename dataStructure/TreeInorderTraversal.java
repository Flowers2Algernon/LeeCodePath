package dataStructure;

public class TreeInorderTraversal {

}
class Node{
    int key;
    Node left,right;
    public Node(int item){
        key = item;
        left = right = null;
    }
}

class BinaryTree{
    //Root of binary tree
    Node root;

    BinaryTree(){
        root = null;
    }

    //given a binary tree, print its node in inorder
    void printInorder(Node node){
        if (node == null){
            return;
        }
        //first recur on left child
        printInorder(node.left);

        //then print the data of node
        System.out.println(node.key+" ");

        //now recur on the right child
        printInorder(node.right);
    }


    //drive node
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);

        //functional call
        System.out.println("Inorder traversal of binary tree is ");
        binaryTree.printInorder(binaryTree.root);
    }







}




