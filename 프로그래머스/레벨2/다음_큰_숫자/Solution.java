package 프로그래머스.레벨2.다음_큰_숫자;

public class Solution {
    public int solution(int n) {
        int num1 = Integer.bitCount(n);

        for(int i=n+1; i<=1000000; i++) {
            if(Integer.bitCount(i)==num1)
                return i;
        }

        return 0;
    }
}