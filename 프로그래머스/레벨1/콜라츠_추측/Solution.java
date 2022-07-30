package 프로그래머스.레벨1.콜라츠_추측;

public class Solution {
    public int solution(int num) {
        long n = num;
        int answer = 0;

        while(n!=1 && answer<500) {
            if((n&1)==1)
                n = n * 3 + 1;
            else
                n /= 2;
            answer++;
        }
        
        return answer==500 ? -1 : answer;
    }
}