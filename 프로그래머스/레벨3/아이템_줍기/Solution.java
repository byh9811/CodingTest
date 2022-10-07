package 프로그래머스.레벨3.아이템_줍기;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;
    int state;

    public Point(int x, int y, int state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }
}

public class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        int[][] map = new int[101][101];
        for(int[] rect: rectangle) {
            for(int i=rect[0]*2; i<=rect[2]*2; i++) {
                for(int j=rect[1]*2; j<=rect[3]*2; j++) {
                    if(map[j][i]==-1)
                        continue;

                    if(i==rect[0]*2 || i==rect[2]*2 || j==rect[1]*2 || j==rect[3]*2)
                        map[j][i] = 1;
                    else
                        map[j][i] = -1;
                }
            }
        }

        boolean[][] visited = new boolean[101][101];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(characterX, characterY, 0));
        visited[characterY][characterX] = true;

        while(true) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int state = cur.state;
            if(x==itemX && y==itemY)
                return state/2;

            if(x!=0 && map[y][x-1]==1 && !visited[y][x-1]) {
                q.add(new Point(x-1, y, state+1));
                visited[y][x-1] = true;
            }

            if(x!=map.length-1 && map[y][x+1]==1 && !visited[y][x+1]) {
                q.add(new Point(x+1, y, state+1));
                visited[y][x+1] = true;
            }

            if(y!=0 && map[y-1][x]==1 && !visited[y-1][x]) {
                q.add(new Point(x, y-1, state+1));
                visited[y-1][x] = true;
            }

            if(y!=map.length-1 && map[y+1][x]==1 && !visited[y+1][x]){
                q.add(new Point(x, y+1, state+1));
                visited[y+1][x] = true;
            }
        }
    }
}