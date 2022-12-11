package 프로그래머스.레벨1.삼총사;

public class Solution {
    int answer = 0, sum = 0;

    public int solution(int[] number) {
        boolean[] visited = new boolean[number.length];
        combination(0, 0, number, visited);
        return answer;
    }

    private void combination(int idx, int start, int[] number, boolean[] visited) {
        if(idx>=3) {
            if(idx==3 && sum==0)
                answer++;
            return;
        }

        for(int i=start; i<number.length; i++) {
            if(visited[i])
                continue;

            visited[i] = true;
            sum += number[i];
            combination(idx+1, i+1, number, visited);
            visited[i] = false;
            sum -= number[i];
        }
    }
}