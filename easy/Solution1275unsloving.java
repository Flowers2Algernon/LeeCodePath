package easy;

import org.junit.Test;

import java.util.Arrays;

/*
* 1275. Find Winner on a Tic Tac Toe Game
Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
* The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters,
* while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row,
* column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates
* that the ith move will be played on grid[rowi][coli].
* return the winner of the game if it exists (A or B).
* In case the game ends in a draw return "Draw".
* If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe),
* the grid is initially empty, and A will play first.
* 初始A先下，moves赋值moves[0]=[ , ].
* */
public class Solution1275unsloving {
    @Test
    public void test() {
        Solution127501 solution127501 = new Solution127501();
        int[][] moves = {{0,0},{1,1},{1,0},{1,2},{2,0}};
        solution127501.tictactoe(moves);
    }
}

class Solution127501 {
    public String tictactoe(int[][] moves) {
        //首先，提取出A和B分别的所有下棋点
        //再对A和B分别进行分析，switchcase模式匹配
        int[][] newArraysA = new int[moves.length][];
        int[][] newArraysB = new int[moves.length][];
        for (int i = 0, a = 0, b = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                newArraysA[a] = moves[i];
                a++;
            } else {
                newArraysB[b] = moves[i];
                b++;
            }
        }
        int count =0;
        for(int j =0;j<1;j++){
            switch (Arrays.toString(newArraysA[j])){
                case "0,0": count++;
                continue;
            }
        }

        return "S";
    }
}


