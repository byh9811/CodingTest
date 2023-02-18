package 실전용;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. .을 기준으로 밖으로 나갈 수가 없으면? 도형의 일부
 * 2. 전체 원소 개수 - 밖으로 나가지는 .의 개수 = 정답
 * 3. .을 기준으로 BFS ㄱㄱ
 *
 */
public class Solution {
    char[][] map;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public int solution(String[] grid) {
        int inner = 0;
        map = new char[grid.length][grid[0].length()];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                map[i][j] = grid[i].charAt(j);
            }
        }

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j]=='#')
                    continue;

                inner += bfs(i, j);
            }
        }

        return map.length*map[0].length-inner;
    }

    private int bfs(int i, int j) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        xq.add(j);
        yq.add(i);
        visited[i][j] = true;
        while(!xq.isEmpty()) {
            int x = xq.poll();
            int y = yq.poll();

            if(x==0 || y==0 || x==map[0].length-1 || y==map.length-1)
                return 0;

            for(int k=0; k<4; k++) {
                int nextX = x + dx[k];
                int nextY = y + dy[k];
                if(nextX>=0 && nextX<map[0].length && nextY>=0 && nextY<map.length && !visited[nextY][nextX] );
            }
        }

        return 1;
    }
}