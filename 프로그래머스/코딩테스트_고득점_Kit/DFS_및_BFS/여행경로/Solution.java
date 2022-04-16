package 프로그래머스.코딩테스트_고득점_Kit.DFS_및_BFS.여행경로;

import java.util.*;

public class Solution {
    boolean[] visited;
    ArrayList<String> answer;
    String[][] tickets;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();
        this.tickets = tickets;

        dfs(0, "ICN", "ICN");

        Collections.sort(answer);

        return answer.get(0).split(" ");
    }

    public void dfs(int index, String start, String route) {
        if(index == tickets.length){
            answer.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(index+1, tickets[i][1], route+" "+tickets[i][1]);
                visited[i] = false;
            }
        }
    }

}