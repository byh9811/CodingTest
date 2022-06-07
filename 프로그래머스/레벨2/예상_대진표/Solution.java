package 프로그래머스.레벨2.예상_대진표;

public class Solution {
    public int solution(int n, int a, int b) {
        a--;
        b--;

        for(int round=1; round<=20; round++) {
            if(a/(int)Math.pow(2, round)==b/(int)Math.pow(2, round))
                return round;
        }

        return n;
    }
}