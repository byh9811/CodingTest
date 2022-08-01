package 프로그래머스.레벨1.하샤드_수;

public class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int cur = x;

        while(cur>0) {
            sum += cur%10;
            cur /= 10;
        }

        return x%sum==0 ? true : false;
    }
}