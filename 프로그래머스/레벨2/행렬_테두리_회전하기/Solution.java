package 프로그래머스.레벨2.행렬_테두리_회전하기;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int count = 1;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++)
                map[i][j] = count++;
        }

        for(int i=0; i<queries.length; i++)
            answer[i] = rotate(queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1, map);

        return answer;
    }

    private int rotate(int y1, int x1, int y2, int x2, int[][] map) {
        int save = map[y1][x1];
        int min = save;

        for(int i=y1; i<y2; i++) {
            map[i][x1] = map[i+1][x1];
            min = Math.min(map[i][x1], min);
        }

        for(int i=x1; i<x2; i++) {
            map[y2][i] = map[y2][i+1];
            min = Math.min(map[y2][i], min);
        }

        for(int i=y2; i>y1; i--) {
            map[i][x2] = map[i-1][x2];
            min = Math.min(map[i][x2], min);
        }

        for(int i=x2; i>x1+1; i--) {
            map[y1][i] = map[y1][i-1];
            min = Math.min(map[y1][i], min);
        }

        map[y1][x1+1] = save;

        return min;
    }
}