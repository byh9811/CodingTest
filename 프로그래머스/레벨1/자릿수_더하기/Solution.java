package 프로그래머스.레벨1.자릿수_더하기;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(n>0) {
            answer += n%10;
            n /= 10;
        }

        return answer;
    }
}