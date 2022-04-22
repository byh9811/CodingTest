package 프로그래머스.레벨2.카카오프렌즈_컬러링북;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<visited.length; i++) {
            for(int j=0; j<visited[i].length; j++) {
                if(!visited[i][j] && picture[i][j]!=0) {
                    numberOfArea++;
                    int size = bfs(visited, picture, i, j);
                    maxSizeOfOneArea = Math.max(size, maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int bfs(boolean[][] visited, int[][] picture, int i, int j) {
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        int color = picture[i][j];
        int size = 0;
        rowQ.add(i);
        colQ.add(j);
        visited[i][j] = true;

        while(!rowQ.isEmpty()) {
            int row = rowQ.poll();
            int col = colQ.poll();
            size++;

            if(row!=0 && !visited[row-1][col] && picture[row-1][col]==color) {
                rowQ.add(row-1);
                colQ.add(col);
                visited[row-1][col] = true;
            }

            if(row!=visited.length-1 && !visited[row+1][col] && picture[row+1][col]==color) {
                rowQ.add(row+1);
                colQ.add(col);
                visited[row+1][col] = true;
            }

            if(col!=0 && !visited[row][col-1] && picture[row][col-1]==color) {
                rowQ.add(row);
                colQ.add(col-1);
                visited[row][col-1] = true;
            }

            if(col!=visited[row].length-1 && !visited[row][col+1] && picture[row][col+1]==color) {
                rowQ.add(row);
                colQ.add(col+1);
                visited[row][col+1] = true;
            }
        }

        return size;
    }
}