package 프로그래머스.레벨1.크레인_인형뽑기_게임;

import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;
        for(int move: moves) {
            int i = 0;
            for(; i<board.length; i++) {
                if(board[i][move-1]!=0)
                    break;
            }
            if(i==board.length)
                continue;

            int pick = board[i][move-1];
            board[i][move-1] = 0;
            if(bucket.isEmpty() || bucket.peek()!=pick)
                bucket.add(pick);
            else {
                bucket.pop();
                answer += 2;
            }
        }

        return answer;
    }
}