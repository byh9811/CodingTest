package 프로그래머스.레벨1.정수_제곱근_판별;

public class Solution {
    public long solution(long n) {
        long sqrt = (long)Math.sqrt(n);
        if(sqrt*sqrt==n)
            return (long)Math.pow(sqrt+1, 2);
        else
            return -1;
    }
}