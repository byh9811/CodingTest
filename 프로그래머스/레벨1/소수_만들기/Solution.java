package 프로그래머스.레벨1.소수_만들기;

public class Solution {
    boolean[] visited;
    int answer = 0;

    public int solution(int[] nums) {
        visited = new boolean[nums.length];
        combination(0, 0, 0, nums);
        return answer;
    }

    private void combination(int index, int prev, int sum, int[] nums) {
        if(index==3) {
            if(isPrime(sum))
                answer++;
            return;
        }

        for(int i=prev; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sum += nums[i];
                combination(index+1, i, sum, nums);
                sum -= nums[i];
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int sum) {
        for(int i=2; i<=Math.sqrt(sum); i++) {
            if(sum%i==0)
                return false;
        }
        return true;
    }
}