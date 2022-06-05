package 프로그래머스.레벨2.빛의_경로_사이클;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int rowLen, colLen;
    boolean[][][] visited;
    int[] dx = {0, 1, 0, -1};   // up, right, down, left
    int[] dy = {1, 0, -1, 0};

    public int[] solution(String[] grid) {
        rowLen = grid.length;
        colLen = grid[0].length();

        visited = new boolean[rowLen][colLen][4];
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<rowLen; i++) {
            for(int j=0; j<colLen; j++) {
                for(int k=0; k<4; k++) {
                    if(!visited[i][j][k])
                        answer.add(progress(i, j, k, grid));
                }
            }
        }

        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int progress(int row, int col, int dir, String[] grid) {
        int cnt = 0;

        while(!visited[row][col][dir]) {
            visited[row][col][dir] = true;
            cnt++;

            row = (row+dy[dir]+rowLen) % rowLen;
            col = (col+dx[dir]+colLen) % colLen;
            if(grid[row].charAt(col)=='L')
                dir = dir==3 ? 0 : dir+1;
            else if(grid[row].charAt(col)=='R')
                dir = dir==0 ? 3 : dir-1;
        }

        return cnt;
    }
}