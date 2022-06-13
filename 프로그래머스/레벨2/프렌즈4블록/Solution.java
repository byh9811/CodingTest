package 프로그래머스.레벨2.프렌즈4블록;

import java.util.HashSet;
import java.util.Set;

class Point {
    int col;
    int row;

    public Point(int col, int row) {
        this.col = col;
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        Point p = (Point)o;
        return p.row==row && p.col==col;
    }

    @Override
    public int hashCode() {
        return col*31+row;
    }
}

public class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++)
                map[i][j] = board[i].charAt(j);
        }

        int answer = 0;

        while(true) {
            int popped = pop(map, m, n);
            if(popped==0)
                break;

            pull(map);
            answer += popped;
        }

        return answer;
    }

    private int pop(char[][] map, int m, int n) {
        Set<Point> set = new HashSet<>();

        for(int i=0; i<m-1; i++) {
            for(int j=0; j<n-1; j++) {
                if(map[i][j]!='^' && map[i][j]==map[i+1][j] && map[i][j]==map[i][j+1] && map[i][j]==map[i+1][j+1]) {
                    set.add(new Point(i, j));
                    set.add(new Point(i+1, j));
                    set.add(new Point(i, j+1));
                    set.add(new Point(i+1, j+1));
                }
            }
        }

        for(Point p: set)
            map[p.col][p.row] = '^';

        return set.size();
    }

    private void pull(char[][] map) {
        for(int row=0; row<map[0].length; row++) {
            for(int col=map.length-1; col>=0; col--) {
                if(map[col][row]=='^') {
                    for(int tempCol=col-1; tempCol>=0; tempCol--) {
                        if(map[tempCol][row]!='^') {
                            map[col][row] = map[tempCol][row];
                            map[tempCol][row] = '^';
                            break;
                        }
                    }
                }
            }
        }
    }
}