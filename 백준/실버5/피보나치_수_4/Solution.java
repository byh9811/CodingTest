package 백준.실버5.피보나치_수_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.print(0);
            return;
        }
        BigInteger[] dp = new BigInteger[n+1];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for(int i=2; i<=n; i++)
            dp[i] = dp[i-1].add(dp[i-2]);

        System.out.print(dp[n]);
    }
}