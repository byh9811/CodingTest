package 백준.골드5.동전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++)
                coins[j] = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(br.readLine());
            int[][] dp = new int[N+1][M+1];
            for(int j=0; j<=N; j++)
                dp[j][0] = 1;
            for(int j=0; j<=M; j++)
                dp[0][j] = 0;
            for(int j=1; j<=N; j++) {
                for(int k=1; k<coins[j] && k<=M; k++)
                    dp[j][k] = dp[j-1][k];
                for(int k=coins[j]; k<=M; k++)
                    dp[j][k] = dp[j-1][k] + dp[j][k-coins[j]];
            }

            System.out.println(dp[N][M]);
        }
    }
}