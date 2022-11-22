package 백준.골드5.내려가기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];
        for(int i=0; i<3; i++)
            minDp[0][i] = maxDp[0][i] = arr[0][i];

        for(int i=1; i<N; i++) {
            for(int j=0; j<3; j++) {
                maxDp[i][j] = max(maxDp, i, j) + arr[i][j];
                minDp[i][j] = min(minDp, i, j) + arr[i][j];
            }
        }

        System.out.println(max(maxDp, N, 1) + " " + min(minDp, N, 1));
    }

    private int min(int[][] dp, int i, int j) {
        int min = dp[i-1][j];

        if(j!=0)
            min = Math.min(min, dp[i-1][j-1]);
        if(j!=2)
            min = Math.min(min, dp[i-1][j+1]);

        return min;
    }

    private int max(int[][] dp, int i, int j) {
        int max = dp[i-1][j];

        if(j!=0)
            max = Math.max(max, dp[i-1][j-1]);
        if(j!=2)
            max = Math.max(max, dp[i-1][j+1]);

        return max;
    }
}