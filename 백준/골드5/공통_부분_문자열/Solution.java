package 백준.골드5.공통_부분_문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int answer = 0;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0; i<str1.length(); i++) {
            for(int j=0; j<str2.length(); j++) {
                if(str1.charAt(i)!=str2.charAt(j))
                    continue;

                dp[i+1][j+1] = dp[i][j] + 1;
                answer = Math.max(answer, dp[i+1][j+1]);
            }
        }

        System.out.println(answer);
    }
}