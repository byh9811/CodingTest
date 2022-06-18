package 프로그래머스.레벨2.전력망을_둘로_나누기;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=1; i<n+1; i++)
            map.put(i, new ArrayList<>());

        for(int[] wire: wires) {
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

        for(int[] wire: wires) {
            int weight = dfs(wire[0], wire, map, new boolean[n+1]);
            System.out.println(weight);
            answer = Math.min(answer, Math.abs(n-weight-weight));
        }

        return answer;
    }

    private int dfs(int start, int[] brokenWire, HashMap<Integer, ArrayList<Integer>> map, boolean[] visited) {
        ArrayList<Integer> list = map.get(start);
        visited[start] = true;
        int ret = 1;

        for(int next: list) {
            if((start==brokenWire[0] && next==brokenWire[1]) || (start==brokenWire[1] && next==brokenWire[0]) || visited[next])
                continue;
            visited[next] = true;
            ret += dfs(next, brokenWire, map, visited);
        }

        return ret;
    }
}