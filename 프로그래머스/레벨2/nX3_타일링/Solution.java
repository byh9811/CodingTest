package 프로그래머스.레벨2.nX3_타일링;

public class Solution {
    public int solution(int n) {
        long[] dp = new long[n/2+1];
        dp[1] = 3;

        for(int i=2; i<=n/2; i++) {
            long sum = 0l;
            sum += dp[i-1] * 3;
            sum %= 1000000007;

            for(int j=i-2; j>=1; j--) {
                sum += dp[j] * 2;
                sum %= 1000000007;
            }

            dp[i] = sum+2;
        }

        return (int)dp[n/2];
    }
}