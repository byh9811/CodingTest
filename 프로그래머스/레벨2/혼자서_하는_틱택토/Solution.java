package 프로그래머스.레벨2.혼자서_하는_틱택토;

import java.util.*;

/*
1. 불가능한 경우는 다음과 같다.
    - X가 O보다 많을 경우
    - O가 X보다 2개 이상 많을 경우
    - O와 X의 수가 같고 O빙고가 없을 경우
    - O가 X보다 1개 많고 X빙고가 있을 경우
2. 위의 경우에는 0, 다른 경우에는 1을 반환한다.

풀이 시간: 31분 55초
*/
class Solution {
    public int solution(String[] board) {
        int[] num = getNum(board);
        int numO = num[0];
        int numX = num[1];
        
        if(numO<numX || numO>numX+1 || (numO==numX && hasOBingo(board)) || (numO==numX+1 && hasXBingo(board)))
            return 0;
        
        return 1;
    }
    
    private int[] getNum(String[] board) {
        int numO = 0;
        int numX = 0;
        
        for(String row: board) {
            for(int i=0; i<row.length(); i++) {
                if(row.charAt(i)=='O')
                    numO++;
                else if(row.charAt(i)=='X')
                    numX++;
            }
        }
        
        return new int[] {numO, numX};
    }
    
    private boolean hasOBingo(String[] board) {
        
        // row bingo
        for(String row: board) {
            if(row.equals("OOO"))
                return true;
        }
        
        // col bingo
        for(int i=0; i<board.length; i++) {
            if(board[0].charAt(i)=='O' && board[1].charAt(i)=='O' && board[2].charAt(i)=='O')
                return true;
        }
        
        // dia bingo
        if(board[0].charAt(0)=='O' && board[1].charAt(1)=='O' && board[2].charAt(2)=='O')
            return true;
        
        if(board[0].charAt(2)=='O' && board[1].charAt(1)=='O' && board[2].charAt(0)=='O')
            return true;
        
        return false;
    }
    
    private boolean hasXBingo(String[] board) {
        
        // row bingo
        for(String row: board) {
            if(row.equals("XXX"))
                return true;
        }
        
        // col bingo
        for(int i=0; i<board.length; i++) {
            if(board[0].charAt(i)=='X' && board[1].charAt(i)=='X' && board[2].charAt(i)=='X')
                return true;
        }
        
        // dia bingo
        if(board[0].charAt(0)=='X' && board[1].charAt(1)=='X' && board[2].charAt(2)=='X')
            return true;
        
        if(board[0].charAt(2)=='X' && board[1].charAt(1)=='X' && board[2].charAt(0)=='X')
            return true;
        
        return false;
    }
}