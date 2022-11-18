package 백준.골드5.합분해;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[K+1][N+1];
        for(int i=1; i<=N; i++)
            dp[1][i] = 1;
        for(int i=1; i<=K; i++)
            dp[i][1] = i;

        for(int i=2; i<=K; i++) {
            for(int j=2; j<=N; j++)
                dp[i][j] = (dp[i-1][j]+dp[i][j-1]) % 1000000000;
        }

        System.out.println(dp[K][N]);
    }
}