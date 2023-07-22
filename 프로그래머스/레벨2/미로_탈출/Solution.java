package 프로그래머스.레벨2.미로_탈출;

import java.util.*;

/*
1. BFS로 이동을 구현한다.
2. 특이한 점은 레버 위치를 도착 전에 한 번 들러야 한다는 것이다.
3. 레버 위치까지 도착하는 최단 경로, 레버 위치에서 도착 지점까지 이동하는 최단 경로로 나누어 더하면 될 것 같다.

풀이 시간: 22분 30초
*/
class Solution {
    int n, m;
    char[][] map;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    public int solution(String[] maps) {
        int sx=0, sy=0, mx=0, my=0, ex=0, ey=0;
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = maps[i].charAt(j);
                
                if(map[i][j]=='S') {
                    sx = j;
                    sy = i;
                } else if(map[i][j]=='L') {
                    mx = j;
                    my = i;
                } else if(map[i][j]=='E') {
                    ex = j;
                    ey = i;
                }
            }
        }
        
        int firstRoute = bfs(sx, sy, mx, my);
        int secondRoute = bfs(mx, my, ex, ey);
        
        if(firstRoute==-1 || secondRoute==-1) {
            return -1;
        }
        
        return firstRoute + secondRoute;
    }
    
    private int bfs(int srcX, int srcY, int destX, int destY) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{srcX, srcY});
        visited[srcY][srcX] = true;
        int step = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int t=0; t<size; t++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                if(x==destX && y==destY) {
                    return step;
                }

                for(int i=0; i<4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if(!isOut(nx, ny) && !visited[ny][nx] && map[ny][nx]!='X') {
                        q.add(new int[]{nx, ny});
                        visited[ny][nx] = true;
                    }
                }
            }
            
            step++;
        }
        
        return -1;
    }
    
    private boolean isOut(int x, int y) {
        return x<0 || x>m-1 || y<0 || y>n-1;
    }
}