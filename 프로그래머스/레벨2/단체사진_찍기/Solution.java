package 프로그래머스.레벨2.단체사진_찍기;

import java.util.HashMap;

public class Solution {
    char[] characters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    int count = 0;
    HashMap<Character, Integer> line;
    boolean[] visited;
    String[] data;

    public int solution(int n, String[] data) {
        line = new HashMap<>();
        this.data = data;
        visited = new boolean[8];
        dfs(0);

        return count;
    }

    private void dfs(int index) {
        if(index==8) {
            for(String condition: data) {
                char fir = condition.charAt(0);
                char sec = condition.charAt(2);
                char operator = condition.charAt(3);
                int num = condition.charAt(4) - '0';
                int dist = Math.abs(line.get(fir) - line.get(sec)) - 1;

                switch (operator) {
                    case '=': if(dist!=num) return; break;
                    case '<': if(dist>=num) return; break;
                    default: if(dist<=num) return;
                }
            }

            count++;
            return;
        }

        for(int i=0; i<8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                line.put(characters[i], index);
                dfs(index+1);
                visited[i] = false;
                line.remove(characters[i]);
            }
        }
    }
}