package 프로그래머스.고득점_Kit.DFS_및_BFS.타겟_넘버;

public class Solution {
    int[] numbers;
    int target;
    int answer = 0;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);

        return answer;
    }

    private void dfs(int idx, int sum) {
        if(idx==numbers.length) {
            if(sum==target)
                answer++;
            return;
        }

        dfs(idx+1, sum+numbers[idx]);
        dfs(idx+1, sum-numbers[idx]);
    }
}