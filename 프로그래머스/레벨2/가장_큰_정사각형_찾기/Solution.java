package 프로그래머스.레벨2.가장_큰_정사각형_찾기;

public class Solution {
    public int solution(int[][] board) {
        int[][] map = new int[board.length+1][board[0].length+1];
        int max = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++)
                map[i+1][j+1] = board[i][j];
        }

        for(int i=1; i<map.length; i++) {
            for(int j=1; j<map[i].length; j++) {
                if(map[i][j]==0)
                    continue;

                int min = Math.min(Math.min(map[i-1][j-1], map[i-1][j]), map[i][j-1]);
                map[i][j] = min + 1;
                max = Math.max(map[i][j], max);
            }
        }

        return max*max;
    }
}