package SWEA.D4.미로1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
* 1. bfs를 이용하여 도착지에 도착할 수 있는지 확인한다.
* 2. 도착 여부에 따라 1이나 0을 형식에 맞게 출력한다.
* */
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int test_case = Integer.parseInt(br.readLine());
            int[][] map = new int[16][16];
            Point start = null;
            for(int i=0; i<map.length; i++) {
                String input = br.readLine();
                for(int j=0; j<map.length; j++) {
                    map[i][j] = input.charAt(j) - '0';
                    if (map[i][j]==2)
                        start = new Point(j ,i);
                }
            }

            System.out.printf("#%d %d\n", test_case, reachable(start, map) ? 1 : 0);
        }
    }

    private boolean reachable(Point start, int[][] map) {
        boolean reach = false;
        boolean[][] visited = new boolean[map.length][map.length];
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Point cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            if(map[y][x]==3) {
                reach = true;
                break;
            }

            if(y!=0 && map[y-1][x]!=1 && !visited[y-1][x]) {
                q.add(new Point(x, y-1));
                visited[y-1][x] = true;
            }

            if(x!=0 && map[y][x-1]!=1 && !visited[y][x-1]) {
                q.add(new Point(x-1, y));
                visited[y][x-1] = true;
            }

            if(y!=map.length-1 && map[y+1][x]!=1 && !visited[y+1][x]) {
                q.add(new Point(x, y+1));
                visited[y+1][x] = true;
            }

            if(x!=map.length-1 && map[y][x+1]!=1 && !visited[y][x+1]) {
                q.add(new Point(x+1, y));
                visited[y][x+1] = true;
            }
        }

        return reach;
    }
}