package 프로그래머스.레벨2.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int row;
    int col;
    int cnt;

    public Point(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}

public class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
    }

    private int bfs(int[][] map) {
        int rowSize = map.length;
        int colSize = map[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            int cnt = cur.cnt;

            if(row==rowSize-1 && col==colSize-1)
                return cnt;

            if(row!=0 && !visited[row-1][col] && map[row-1][col]==1) {
                q.add(new Point(row-1, col, cnt+1));
                visited[row-1][col] = true;
            }

            if(row!=rowSize-1 && !visited[row+1][col] && map[row+1][col]==1) {
                q.add(new Point(row+1, col, cnt+1));
                visited[row+1][col] = true;
            }

            if(col!=0 && !visited[row][col-1] && map[row][col-1]==1) {
                q.add(new Point(row, col-1, cnt+1));
                visited[row][col-1] = true;
            }

            if(col!=colSize-1 && !visited[row][col+1] && map[row][col+1]==1) {
                q.add(new Point(row, col+1, cnt+1));
                visited[row][col+1] = true;
            }
        }

        return -1;
    }
}