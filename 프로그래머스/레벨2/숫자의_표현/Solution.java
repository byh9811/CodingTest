package 프로그래머스.레벨2.숫자의_표현;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1, end = 1, sum = 1;

        while(end<=n) {
            if(sum>n)
                sum -= start++;
            else if(sum<n)
                sum += ++end;
            else {
                answer++;
                sum = sum - start++ + ++end;
            }
        }

        return answer;
    }
}