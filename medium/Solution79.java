package medium;

public class Solution79 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        boolean exist = new Solution79().exist(board, word);
        System.out.println(exist);
    }
    public static boolean search(char[][] board,int x, int y,String word,int index, boolean[][] visited){
        if (index == word.length()){
            return true;
        }
        //以下是检查是否数组下标越界和当前字符是否匹配
        if (x<0||y<0||x>=board.length||y>=board[0].length|| visited[x][y] ||board[x][y]!=word.charAt(index)){
            return false;
        }
        visited[x][y] = true;//标记当前位置已访问
        //递归探索四个方向
        if (search(board,x+1,y,word,index+1,visited)||search(board,x-1,y,word,index+1,visited)||search(board,x,y+1,word,index+1,visited)||search(board,x,y-1,word,index+1,visited)){
            return true;
        }
        visited[x][y] = false;//回溯，重置访问状态
        //注意，此实现包含回溯：即在当前路径不满足条件时，
        // 会撤销最近的选择，恢复状态，并继续尝试其他可能的路径，这是实现深度优先搜索（DFS）中重要的策略。
        return false;
    }

    public boolean exist(char[][] board, String word) {
        //其实就是个dfs的问题
        //创建一个ListString,将Dfs遍历得到的所有路径可能结果都放入到这个list String中，最后检查该List中是否由所需要的word--这是一个方法
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
               if (search(board,i,j,word,0,visited)){
                   return true;
               }
            }
        }
        return false;
    }
}
