package 프로그래머스.레벨1.약수의_합;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n%i!=0)
                continue;

            answer += i;
            if(n/i!=i)
                answer += n/i;
        }

        return answer;
    }
}