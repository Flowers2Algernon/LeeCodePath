package dataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class ImplementationOfTreeDataStructure {

}
class GFG{
    //function to print the parent of each line
    public static void printParents(int node, Vector<Vector<Integer>> adj, int parent){
        //current node is Root, thus, has no parent
        if (parent == 0){
            System.out.println(node +"->Root");
        }else {
            System.out.println(node +"->"+parent);
        }

        //using DFS
        for (int i =0;i<adj.get(node).size();i++){
            if (adj.get(node).get(i) != parent){
                printParents(adj.get(node).get(i),adj,node);
            }
        }}

        //Function to print the children of each node
        public static void printChildren(int Root, Vector<Vector<Integer>> adj){
            //Queue for the BFS
            Queue<Integer> q = new LinkedList<>();

            //pushing the Root
            q.add(Root);

            //visit array that to keep track of nodes that have been visited
            int vis[] = new int[adj.size()];
            Arrays.fill(vis,0);

            //BFS
            while (q.size()!=0) {
                int node = q.peek();
                q.remove();
                vis[node] = 1;
                System.out.println(node + "->");

                for (int i = 0; i < adj.get(node).size(); i++) {
                    if (vis[adj.get(node).get(i)] == 0) {
                        System.out.println(adj.get(node).get(i) + " ");
                        q.add(adj.get(node).get(i));
                    }
                }
                System.out.println();
            }
    }
    //Function to print leaf nodes
    public static void printLeafNodes(int Root, Vector<Vector<Integer>> adj){
        //leadNodes only have one edge and are not the root
        for (int i =0;i<adj.size();i++){
            if (adj.get(i).size()==1 && i!=Root){
                System.out.println(i+ " ");
            }
            System.out.println();
        }
    }


    //Function to print the degree of each node
    public static  void printDegrees(int Root,Vector<Vector<Integer>> adj){
        for (int i=0;i<adj.size();i++){
            System.out.print(i + ": ");
            if (i==Root){
                System.out.println(adj.get(i).size());
            }else System.out.println(adj.get(i).size()-1);
        }
    }

    //drive code
    public static void main(String[] args) {
        //Number of nodes
        int N = 7;
        int Root = 1;

        //adjacency list to store the tree
        Vector<Vector<Integer>> adj = new Vector<Vector<Integer>>();
        for (int i=0;i<N+1;i++){
            adj.add(new Vector<Integer>());
        }

        //creat the tree
        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(1).add(4);
        adj.get(4).add(1);
        adj.get(2).add(5);
        adj.get(5).add(2);

        adj.get(2).add(6);
        adj.get(6).add(2);

        adj.get(4).add(7);
        adj.get(7).add(4);

        //print the parents of each node
        System.out.println("the parent of each nodes are: ");
        printParents(Root,adj,0);

        System.out.println("print the children of each node:");
        printChildren(Root,adj);

        System.out.println("print the leaf nodes of each nodes:");
        printLeafNodes(Root,adj);

        System.out.println("print degrees of each node:");
        printDegrees(Root,adj);
    }


















}