package 백준.골드5.보물섬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    int cnt;

    public Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Solution {
    int N, M;
    boolean[][] map;
    boolean[][] visited;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<M; j++) {
                if(input.charAt(j)=='L')
                    map[i][j] = true;
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]) {
                    visited = new boolean[N][M];
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    private int bfs(int i, int j) {
        int cnt = 0;
        Queue<Point> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new Point(j, i, 0));

        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            cnt = p.cnt;

            if(x!=0 && !visited[y][x-1] && map[y][x-1]) {
                visited[y][x-1] = true;
                q.add(new Point(x-1, y, cnt+1));
            }
            if(x!=M-1 && !visited[y][x+1] && map[y][x+1]) {
                visited[y][x+1] = true;
                q.add(new Point(x+1, y, cnt+1));
            }
            if(y!=0 && !visited[y-1][x] && map[y-1][x]) {
                visited[y-1][x] = true;
                q.add(new Point(x, y-1, cnt+1));
            }
            if(y!=N-1 && !visited[y+1][x] && map[y+1][x]) {
                visited[y+1][x] = true;
                q.add(new Point(x, y+1, cnt+1));
            }
        }

        return cnt;
    }
}