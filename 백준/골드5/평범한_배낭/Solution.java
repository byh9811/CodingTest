package 백준.골드5.평범한_배낭;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] weights = new int[N+1];
        int[] values = new int[N+1];
        int[] dp = new int[K+1];

        for(int i=0; i<N; i++) {
            String[] input2 = br.readLine().split(" ");
            weights[i] = Integer.parseInt(input2[0]);
            values[i] = Integer.parseInt(input2[1]);
        }

        for(int i=1; i<=N; i++) {
            for(int j=K; j-weights[i]>=0; j--)
                dp[j] = Math.max(dp[j], dp[j-weights[i]]+values[i]);
        }

        System.out.println(dp[K]);
    }
}