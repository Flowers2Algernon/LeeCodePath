package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
The edges in the graph are represented as a 2D integer array edges,
where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
You want to determine if there is a valid path that exists from vertex source to vertex destination.
Given edges and the integers n, source, and destination,
return true if there is a valid path from source to destination, or false otherwise.
 */
public class Solution1971 {
    public static void main(String[] args) {
        int n = 6;
//        int[][] arr = {{4, 3}, {1, 4}, {4,8},{1,7},{6,4},{4,2},{7,4}, {4,0},{0,9},{5,4}};
      int[][] arr = {{0,1},{2,3},{4,5},{3,4},{1,2}};  //[0,1],[2,3],[4,5],[3,4],[1,2]
        int source = 0;
        int destination =5;
        Solution1971 solution1971 = new Solution1971();
        System.out.println(solution1971.validPath2(n, arr, source, destination));
    }
//    public boolean validPath(int n, int[][] edges, int source, int destination) {
//        if (source == destination) {return true;}
//        //use dfs to solve
//        for (int i = 0; i < edges.length; i++) {
//            if (edges[i][0] == source || edges[i][1] == source){
//
//            }
//        }
//
//    }
//
//    public boolean dfs(int n, int[][] edges, int source, int destination,boolean[] visited) {
//        if ()
//    }


    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        //关键是每次到死胡同后能回退到前一个结点，前一个结点到死胡同后能回退到前前一个结点
        //这就需要用栈来存储路径上的分叉点。当走到死胡同时，从栈中取一个结点，直到栈中没有结点且没找到才返回false。
        if (source == destination) {return true;}
        int pathCode = source;
        int location = -1;
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if((edges[i][0]==pathCode || edges[i][1]==pathCode) && !visited[i] ){
                if (edges[i][0]==destination||edges[i][1] == destination){
                    return true;
                }else {
                    location = i;
                    deque.addFirst(pathCode);
                    if (edges[i][0]==pathCode){
                        pathCode = edges[i][1];
                    }else if (edges[i][1]==pathCode){
                        pathCode = edges[i][0];
                    }
                    visited[i] = true;
//                    i = 0;
                    if (i>(edges.length-1)/2){i=0;}
                }
            } else if (i==edges.length-1) {
                if (deque.isEmpty()){
                    return false;
                }
                pathCode = deque.pollFirst();
                visited[location] = true;
                i = 0;
            }
        }
        return false;
    }
}
