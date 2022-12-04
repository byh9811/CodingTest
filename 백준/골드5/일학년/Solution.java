package 백준.골드5.일학년;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        long[] dp = new long[21];
        dp[arr[0]] = 1;
        for(int i=1; i<N-1; i++)
            spread(dp, arr[i]);
        System.out.println(dp[arr[N-1]]);
    }

    private void spread(long[] dp, int next) {
        long[] temp = new long[21];
        for(int i=0; i<dp.length; i++) {
            if(dp[i]==0)
                continue;

            if(i-next>=0)
                temp[i-next] += dp[i];
            if(i+next<=20)
                temp[i+next] += dp[i];
        }

        for(int i=0; i<=20; i++)
            dp[i] = temp[i];
    }
}