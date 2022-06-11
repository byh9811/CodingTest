package 프로그래머스.레벨2.nX2_타일링;

public class Solution {
    public int solution(int n) {
        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;

        for(int i=2; i<n; i++)
            ways[i] = (ways[i-1]+ways[i-2]) % 1000000007;

        return ways[n-1];
    }
}