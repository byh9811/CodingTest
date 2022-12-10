package 백준.골드5.상범_빌딩;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int l, r, c, cnt;

    public Point(int l, int r, int c, int cnt) {
        this.l = l;
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

public class Solution {
    int L, R, C;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L==0)
                break;

            char[][][] map = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];
            int[] startPoint = new int[3];
            for(int i=0; i<L; i++) {
                for(int j=0; j<R; j++) {
                    String row = br.readLine();
                    for(int k=0; k<C; k++) {
                        map[i][j][k] = row.charAt(k);
                        if(map[i][j][k]=='S') {
                            startPoint[0] = i;
                            startPoint[1] = j;
                            startPoint[2] = k;
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs(startPoint[0], startPoint[1], startPoint[2], map, visited);
            if(result==0)
                sb.append("Trapped!\n");
            else
                sb.append("Escaped in ").append(result).append(" minute(s).\n");
        }
        System.out.println(sb);
    }

    private int bfs(int l, int r, int c, char[][][] map, boolean[][][] visited) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(l, r, c, 0));
        visited[l][r][c] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            if(map[p.l][p.r][p.c]=='E')
                return p.cnt;

            if(p.l!=0 && map[p.l-1][p.r][p.c]!='#' && !visited[p.l-1][p.r][p.c]) {
                q.add(new Point(p.l-1, p.r, p.c, p.cnt+1));
                visited[p.l-1][p.r][p.c] = true;
            }
            if(p.l!=L-1 && map[p.l+1][p.r][p.c]!='#' && !visited[p.l+1][p.r][p.c]) {
                q.add(new Point(p.l+1, p.r, p.c, p.cnt+1));
                visited[p.l+1][p.r][p.c] = true;
            }
            if(p.r!=0 && map[p.l][p.r-1][p.c]!='#' && !visited[p.l][p.r-1][p.c]) {
                q.add(new Point(p.l, p.r-1, p.c, p.cnt+1));
                visited[p.l][p.r-1][p.c] = true;
            }
            if(p.r!=R-1 && map[p.l][p.r+1][p.c]!='#' && !visited[p.l][p.r+1][p.c]) {
                q.add(new Point(p.l, p.r+1, p.c, p.cnt+1));
                visited[p.l][p.r+1][p.c] = true;
            }
            if(p.c!=0 && map[p.l][p.r][p.c-1]!='#' && !visited[p.l][p.r][p.c-1]) {
                q.add(new Point(p.l, p.r, p.c-1, p.cnt+1));
                visited[p.l][p.r][p.c-1] = true;
            }
            if(p.c!=C-1 && map[p.l][p.r][p.c+1]!='#' && !visited[p.l][p.r][p.c+1]) {
                q.add(new Point(p.l, p.r, p.c+1, p.cnt+1));
                visited[p.l][p.r][p.c+1] = true;
            }
        }

        return 0;
    }
}