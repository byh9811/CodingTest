package 프로그래머스.레벨2.리코챗_로봇;

import java.util.*;

/*
1. 전형적인 BFS
2. 단계를 구해야 하므로 q의 사이즈만큼 도는 것을 반복한다.
3. 한번 이동시 끝까지 이동해야 한다..

풀이 시간: 52분 20초
*/
class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    
    public int solution(String[] board) {
        char[][] map = new char[board.length][board[0].length()];
        int sx = 0;
        int sy = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length(); j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j]=='R') {
                    sx = j;
                    sy = i;
                }
            }
        }
        
        return bfs(map, sx, sy);
    }
    
    private int bfs(char[][] map, int sx, int sy) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        visited[sy][sx] = true;
        int cnt = 0;
        
        while(!q.isEmpty()) {
            int qSize = q.size();
            cnt++;
            for(int t=0; t<qSize; t++) {   
                int[] cur = q.poll();
                int curx = cur[0];
                int cury = cur[1];

                for(int i=0; i<4; i++) {
                    int x = getNextX(curx, cury, i, map);
                    int y = getNextY(curx, cury, i, map);

                    if(visited[y][x]) {
                        continue;
                    }

                    if(map[y][x]=='G') {
                        return cnt;
                    }
                    
                    q.add(new int[]{x, y});
                    visited[y][x] = true;
                    // System.out.printf("%d, %d, %d, %d\n", y, x, i, cnt);
                }
            }
        }
        
        return -1;
    }
    
    private int getNextX(int x, int y, int d, char[][] map) {
        if(d==1 || d==3) {
            return x;
        }
        
        while(!isOut(x, y, map.length, map[0].length) && map[y][x]!='D') {
            x += dx[d];
        }
        
        return x - dx[d];
    }
    
    private int getNextY(int x, int y, int d, char[][] map) {
        if(d==0 || d==2) {
            return y;
        }
        
        while(!isOut(x, y, map.length, map[0].length) && map[y][x]!='D') {
            y += dy[d];
        }
        
        return y - dy[d];
    }
    
    private boolean isOut(int x, int y, int rowSize, int colSize) {
        return x<0 || y<0 || y>rowSize-1 || x>colSize-1;
    }
}