package 백준.골드5.암호코드;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password = br.readLine();
        int[] dp = new int[password.length()];
        if(password.length()==0) {
            System.out.println(0);
            return;
        } else if(password.length()==1) {
            System.out.println(password.charAt(0)=='0' ? 0 : 1);
            return;
        } else {
            int num = Integer.parseInt(password.substring(0, 2));
            if(num==10 || num==20) {
                dp[0] = 0;
                dp[1] = 1;
            } else if(num<10 || num%10==0) {
                System.out.println(0);
                return;
            } else if(num<=26) {
                dp[0] = 1;
                dp[1] = 2;
            } else {
                dp[0] = 1;
                dp[1] = 1;
            }
        }

        for(int i=2; i<dp.length; i++) {
            int num = Integer.parseInt(password.substring(i-1, i+1));
            if(num==10 || num==20) {
                dp[i] = dp[i-2] % 1000000;
                dp[i-1] = 0;
            } else if(num%10==0) {
                System.out.println(0);
                return;
            } else if(num<=26) {
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000;
            } else {
                dp[i] = dp[i-1] % 1000000;
            }
        }

        System.out.println(dp[dp.length-1]);
    }
}