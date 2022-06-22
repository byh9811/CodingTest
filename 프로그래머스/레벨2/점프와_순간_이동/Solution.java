package 프로그래머스.레벨2.점프와_순간_이동;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(n!=0) {
            if((n&1)==0)
                n /= 2;
            else {
                answer++;
                n -= 1;
            }
        }

        return answer;
    }
}