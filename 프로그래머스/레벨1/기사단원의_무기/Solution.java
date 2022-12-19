package 프로그래머스.레벨1.기사단원의_무기;

public class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i=1; i<=number; i++) {
            double root = Math.sqrt(i);
            int divisor = 0;
            for(int j=1; j<root; j++) {
                if(i%j==0)
                    divisor += 2;
            }
            if(root==(int)root)
                divisor++;
            answer += divisor>limit ? power : divisor;
        }

        return answer;
    }
}