package 백준.골드5.적록색약;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;

    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    int N;
    char[][] map;
    boolean[][] visited;
    int answer1, answer2;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++)
                map[i][j] = input.charAt(j);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    bfs(i, j);
                    answer1++;
                }
            }
        }

        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                if(map[i][j]=='G')
                    map[i][j] = 'R';
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    bfs(i, j);
                    answer2++;
                }
            }
        }

        System.out.print(answer1 + " " + answer2);
    }

    private void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visited[i][j] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();

            if(p.x!=0 && !visited[p.y][p.x-1] && map[p.y][p.x-1]==map[i][j]) {
                q.add(new Point(p.y, p.x-1));
                visited[p.y][p.x-1] = true;
            }
            if(p.x!=N-1 && !visited[p.y][p.x+1] && map[p.y][p.x+1]==map[i][j]) {
                q.add(new Point(p.y, p.x+1));
                visited[p.y][p.x+1] = true;
            }
            if(p.y!=0 && !visited[p.y-1][p.x] && map[p.y-1][p.x]==map[i][j]) {
                q.add(new Point(p.y-1, p.x));
                visited[p.y-1][p.x] = true;
            }
            if(p.y!=N-1 && !visited[p.y+1][p.x] && map[p.y+1][p.x]==map[i][j]) {
                q.add(new Point(p.y+1, p.x));
                visited[p.y+1][p.x] = true;
            }
        }
    }
}