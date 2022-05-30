package 프로그래머스.레벨2.피로도;

public class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        dfs(0, k, dungeons, visited);

        return answer;
    }

    private void dfs(int index, int curFatigue, int[][] dungeons, boolean[] visited) {
        boolean recalled = false;

        for(int i=0; i<dungeons.length; i++) {
            int reqFatigue = dungeons[i][0];
            int useFatigue = dungeons[i][1];

            if(!visited[i] && reqFatigue<=curFatigue) {
                visited[i] = true;
                dfs(index+1, curFatigue-useFatigue, dungeons, visited);
                visited[i] = false;
                recalled = true;
            }
        }

        if(!recalled)
            answer = Math.max(answer, index);
    }
}