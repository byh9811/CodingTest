package 프로그래머스.레벨1.소수_찾기;

import java.util.Arrays;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(!isPrime[i])
                continue;

            answer++;
            for(int j=i+i; j<=n; j+=i)
                isPrime[j] = false;
        }

        for(int i=(int)Math.sqrt(n)+1; i<=n; i++) {
            if(isPrime[i])
                answer++;
        }

        return answer;
    }
}