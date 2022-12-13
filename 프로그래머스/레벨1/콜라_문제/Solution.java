package 프로그래머스.레벨1.콜라_문제;

public class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(n>=a) {
            int q = n / a;
            int r = n % a;
            answer += q * b;
            n = q * b + r;
        }

        return answer;
    }
}