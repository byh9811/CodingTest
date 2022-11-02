package 백준.실버5.타일_장식물;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        long perimeter = 4;
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
            perimeter += dp[i] * 2;
        }

        System.out.print(perimeter);
    }
}