package 백준.골드5.LCS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();

        int[][] dp = new int[input1.length()+1][input2.length()+1];
        for(int i=1; i<=input1.length(); i++) {
            for(int j=1; j<=input2.length(); j++) {
                if(input1.charAt(i-1)==input2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[input1.length()][input2.length()]);
    }
}