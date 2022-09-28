package 백준.실버5.삼의_배수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        int cnt = 0;

        while(X.length()!=1) {
            cnt++;
            X = sumEachDigit(X);
        }

        System.out.println(cnt);
        System.out.println(Integer.parseInt(X)%3==0 ? "YES" : "NO");
    }

    private String sumEachDigit(String X) {
        int ret = 0;

        for(int i=0; i<X.length(); i++)
            ret += X.charAt(i) - '0';

        return String.valueOf(ret);
    }
}