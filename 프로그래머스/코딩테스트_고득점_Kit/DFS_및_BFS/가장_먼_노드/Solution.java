package 프로그래머스.코딩테스트_고득점_Kit.DFS_및_BFS.가장_먼_노드;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int idx;
    int dist;

    public Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}

public class Solution {
    int[] visited;
    ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    int max = 0;

    public int solution(int n, int[][] vertex) {
        visited = new int[n+1];
        Arrays.fill(visited, -1);
        int answer = 0;

        for(int i=0; i<n+1; i++)
            map.add(new ArrayList<>());

        for(int[] elem: vertex) {
            map.get(elem[0]).add(elem[1]);
            map.get(elem[1]).add(elem[0]);
        }

        bfs();

        for(int elem: visited)
            answer = elem == max ? answer + 1 : answer;

        return answer;
    }

    private void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        visited[1] = 0;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int idx = cur.idx;
            int dist = cur.dist;
            max = Math.max(max, dist);

            for(int elem: map.get(idx)) {
                if(visited[elem]==-1) {
                    q.add(new Node(elem, dist+1));
                    visited[elem] = dist+1;
                }
            }
        }
    }
}