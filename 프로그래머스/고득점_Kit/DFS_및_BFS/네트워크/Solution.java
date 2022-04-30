package 프로그래머스.고득점_Kit.DFS_및_BFS.네트워크;

import java.util.*;

public class Solution {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    private void bfs(int fi, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(fi);
        visited[fi] = true;

        while(!q.isEmpty()) {
            int i = q.poll();

            for(int j=0; j<visited.length; j++) {
                if(!visited[j] && computers[i][j]>0) {
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}