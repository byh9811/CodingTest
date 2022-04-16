package DP.도둑질;

public class Solution {
    public int solution(int[] money) {
        int size = money.length;

        if(size==3) {
            int big = Math.max(money[0], money[1]);
            return Math.max(big, money[2]);
        }

        // 첫 집을 터는 경우
        int[] dp = new int[size];
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = dp[0] + money[2];
        for(int i=3; i<size-1; i++)
            dp[i] = Math.max(dp[i-3], dp[i-2]) + money[i];
        int candidate1 = Math.max(dp[size-3], dp[size-2]);

        // 첫 집을 털지 않는 경우
        dp[0] = 0;
        dp[2] = money[2];
        for(int i=3; i<size; i++)
            dp[i] = Math.max(dp[i-3], dp[i-2]) + money[i];
        int candidate2 = Math.max(dp[size-2], dp[size-1]);

        return Math.max(candidate1, candidate2);
    }
}